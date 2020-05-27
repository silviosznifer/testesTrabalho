package br.com.bb.telegram;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Assinaturas {
	Map<String,HashSet<String>> assinaturas = new HashMap<String,HashSet<String>>();
	
	public Assinaturas () {
		// TODO: Carrega assinaturas
	}
	
	public void assinar(String processo) {
		HashSet<String> processos = this.assinaturas.get(processo);
		processos.add(processo);
		
		// TODO: gravar assinaturas
		
	}

}
