package br.com.bb.telegram;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public final class TelegramAtivo implements Runnable{

    private final String endpoint = "https://api.telegram.org/";
    private final String token;
    private final int segundos = 5;

    public TelegramAtivo(String token) {
        this.token = token;
    }

    public HttpResponse<JsonNode> sendMessage(Integer chatId, String text) throws UnirestException {
        return Unirest.post(endpoint + "bot" + token + "/sendMessage")
                .field("chat_id", chatId)
                .field("text", text)
                .asJson();
    }

    public void run() {
        while (true) {
        	try {
				Thread.sleep(this.segundos * 1000);
				// TODO: Verificar assinaturas
				// TODO: Verifica se os processos estão corretos e envia para quem tem assinatura
	            // sendMessage(826351867, "INRO_CLI: última atualização aconteceu em 12/08/2018. A tabela possui 1.456.234 registros.");
	            sendMessage(826351867, "INRO_CLI: última atualização aconteceu em 12/08/2018. A tabela possui 1.456.234 registros.");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnirestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
    }
}