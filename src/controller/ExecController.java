package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExecController {

	private String[] saida;
	
	public ExecController() {
		this.saida = null;
	}
	
	public String[] getSaida() {
		return(this.saida);
	}
	
	public void executaComando(String comando) {
		// Executa um comando de terminal (seja Windows ou Linux)
		String[] saida = null;
		try {
			// Executa o processo relacionado com o comando dado.
			Process p = Runtime.getRuntime().exec(comando);
			// Recebe uma sequência de bits enviadas pelo processo.
			InputStream is = p.getInputStream();
			// Faz a leitura dos bits recebidos
			InputStreamReader isr = new InputStreamReader(is);
			// Converte a leitura de Stream e armazena em um Buffer
			BufferedReader b = new BufferedReader(isr);
			// Retira uma String do Buffer
			String linha = b.readLine();
			StringBuffer sb = new StringBuffer();
			while(linha != null) {
				if(sb.length() >= 0) {
					sb.append("\n");  // Adiciona final de linha
				}
				sb.append(linha);     // Adiciona linha
				linha = b.readLine(); // Faz nova leitura
			}
			saida = sb.toString().split("\n"); // Gera saída em Array
		} catch (IOException e) {
			System.err.println(e);
		}
		this.saida = saida;
	}
}
