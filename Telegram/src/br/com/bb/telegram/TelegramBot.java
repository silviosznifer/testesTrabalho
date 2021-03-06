package br.com.bb.telegram;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public final class TelegramBot {

    private final String endpoint = "https://api.telegram.org/";
    private final String token;

    public TelegramBot(String token) {
        this.token = token;
    }

    public HttpResponse sendMessage(Integer chatId, String text) throws UnirestException {
        return Unirest.post(endpoint + "bot" + token + "/sendMessage")
                .field("chat_id", chatId)
                .field("text", text)
                .asJson();
    }

    public HttpResponse<JsonNode> getUpdates(Integer offset) throws UnirestException {
        return Unirest.post(endpoint + "bot" + token + "/getUpdates")
                .field("offset", offset)
                .asJson();
    }

    public void run() throws UnirestException {
        int last_update_id = 0; // controle das mensagens processadas
        HttpResponse<JsonNode> response;
        PerguntasRespostas pr = new PerguntasRespostas();
        while (true) {
            response = getUpdates(last_update_id++);
            if (response.getStatus() == 200) {
                JSONArray responses = response.getBody().getObject().getJSONArray("result");
                if (responses.isNull(0)) {
                    continue;
                } else {
                    last_update_id = responses
                            .getJSONObject(responses.length() - 1)
                            .getInt("update_id") + 1;
                }

                for (int i = 0; i < responses.length(); i++) {
                    JSONObject message = responses
                            .getJSONObject(i)
                            .getJSONObject("message");
                    
                    System.out.println(message);
                    
                    int chat_id = message
                            .getJSONObject("chat")
                            .getInt("id");
//                    String usuario = message
//                            .getJSONObject("chat")
//                            .getString("username");
                    String texto = message
                            .getString("text");
                    
                    System.out.println(texto);
                  
                    String resposta = pr.responde(texto);
                    
                    System.out.println(resposta);

                    sendMessage(chat_id, resposta);
                }
                
                
            }
        }
    }
}