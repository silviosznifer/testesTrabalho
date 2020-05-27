package br.com.bb.telegram;

import java.util.HashMap;
import java.util.Map;

public class PerguntasRespostas {
	Map<String,String> conversa = new HashMap<String,String>();
	
	public PerguntasRespostas() {
		String boasVindas = 
				"Olá! Bem vindo ao ManutBot! \n\n"+
						"Qual processo/tabela você gostaria de monitorar ?\n\n"+
						"  1 - Desembolso Dirco \n"+
						"  2 - Desembolso Dimpe \n" +
						"  3 - INRO_CLI";
						
		
		this.conversa.put("Oi", boasVindas);
		this.conversa.put("Olá", boasVindas);
		this.conversa.put("Ola", boasVindas);
		this.conversa.put("/start", boasVindas);
		this.conversa.put("Tudo bem. E vc ?", "Tudo ótimo!");
		this.conversa.put("3", "OK! Tabela/Processo '3' assinado com sucesso.");
	}
	
	public String responde(String pergunta) {
		String resposta = this.conversa.get(pergunta);
		if (pergunta.equals("3")) {
			// Assinaturas a = new Assinaturas();
			// a.assinar("3");
		}
		if (resposta == null) resposta = "Desculpa, não entendi. Pode reformular ?";
		return resposta;
	}
 
}
