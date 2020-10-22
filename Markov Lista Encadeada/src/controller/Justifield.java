package controller;

import java.util.LinkedList;

import javax.print.attribute.Size2DSyntax;

/*
 * Classe responsavel por justificar texto 
 * 
 * 90 caracteres por linha
 * 
 */
public class Justifield {

	@SuppressWarnings("unused")
	private LinkedList<String> listaText = new LinkedList<String>();
	private String textNotJustifield = null;
	private static final int LIMIT_LINES = 90;

	// Construtor da classe
	public Justifield(String txt) {

		if (!txt.isEmpty()) {

			this.textNotJustifield = txt;

		} else {
			throw new IllegalArgumentException("---- Erro do Programador ----\n"
					+ "Por favor preencha um valor não vazio como parametro no construtor da classe JUSTIFIELD !!!");
		}
	}

	public String retornarTextoJustificado() {

		return textoJustificado(this.listaJustificada(textNotJustifield));
	}

	/*
	 * Metodo responsavel por implementar a lista de acordo com o limite por linha
	 * (90 caracteres por linha) e espaçamento.
	 * 
	 */
	private LinkedList<String> listaJustificada(String texto) {

		String[] textoArray = texto.split(" ");
		
		LinkedList<String> listaJustificada = new LinkedList<String>();

		for (int i = 0; i < textoArray.length; i++) {

			String value = textoArray[i];

			if (value.contains(".") || value.contains("!") || value.contains("?")) {

				
				listaJustificada.add(value.trim());
				if(i < textoArray.length-1) {
				listaJustificada.add(" ");
				}

			} else {

				
				listaJustificada.add(value.trim());
				if(i < textoArray.length-1) {
					listaJustificada.add(" ");
				}	
			

			}

		}

		
		
		return listaJustificada;
	}


	private String textoJustificado(LinkedList<String> listaJustificada) {

		int contadorLinha = LIMIT_LINES;
		StringBuilder sBuffer = new StringBuilder();
		LinkedList<LinkedList<String>> texto = new LinkedList<LinkedList<String>>();
		LinkedList<String> linha = new LinkedList<String>();
	
		
		
		for (String textoString : listaJustificada) {
			

			if(contadorLinha < textoString.length()) {
				
				contadorLinha = 0;

				
			}			
			
			if (contadorLinha == 0 ) {
				
				texto.add(linha);
				linha = new LinkedList<String>();
				contadorLinha = LIMIT_LINES;
			}
			
			if(contadorLinha >= textoString.length()) {
				linha.add(textoString);
				contadorLinha -= textoString.length();
			}
		
			
			
			
		}
		
		
		
		for (LinkedList<String> line : texto) {
			

			
			
			if (caracteres(line) < LIMIT_LINES ) {
				
				int espacos = LIMIT_LINES - caracteres(line);

					while (espacos > 0) {

						for (int i = 0; i < line.size() ; i++) {
							
							if (line.get(i).contains(" ") &&  i < (line.size()-2) ) {

								line.set(i, line.get(i)+" ");

								espacos--;
								
								if (espacos == 0 ) {
									break;
								}
							}

						}

				}
				
			}
			
			for (String textoString : line) {
				
				sBuffer.append(textoString);
			
				
			}
			sBuffer.append("\n");
			
			
		}
		

		/*for (String texto : t) {
			
		
			for (int linha = 0; linha < list.size(); linha++) {
				
				if (contadorLinha > texto.length()) {
					
				}
				
			}
			

			if (contadorLinha < texto.length()) {

				
			
				while (contadorLinha > 0) {

					for (int i = 0; i < listLinha.size(); i++) {

						if (listLinha.get(i).contains(" ") || listLinha.get(i).contains("  ")) {

							listLinha.set(i, listLinha.get(i)+" ");
							
							contadorLinha--;
						}

					}

				}
				
				

				for (String string : listLinha) {

					 sBuffer.append(string);
					//System.out.println(string);

				}

				sBuffer.append("\n");

				listLinha = new LinkedList<String>();
				contadorLinha = LIMIT_LINES;
				
				

			} else {
				listLinha.add(texto);
				contadorLinha -= texto.length();
			}
			
			
	
			if (contadorLinha > texto.length()) {

				
					for (int i = 0; i < listLinha.size(); i++) {

						if (listLinha.get(i).contains(" ") || listLinha.get(i).contains("  ")) {

							listLinha.set(i, listLinha.get(i)+" ");
							
						
						}

					

					}
				
			}else
			
			if (contadorLinha == texto.length()) {
				
				for (int i = 0; i < listLinha.size(); i++) {

					if (listLinha.get(i).contains(" ") || listLinha.get(i).contains("  ")) {

						listLinha.set(i, listLinha.get(i)+" ");
						
					}

				}

			}

			

			if (contadorLinha == 0) {

				for (String string : listLinha) {

					 sBuffer.append(string);
					//System.out.println(string);

				}

				sBuffer.append("\n");
				listLinha = new LinkedList<String>();
				contadorLinha = LIMIT_LINES;
			}

		}*/

		return sBuffer.toString();
	}
	
	private int caracteres(LinkedList<String> lista) {
		
		int soma = 0;
		for (String txtString : lista) {
			soma += txtString.length(); 
			
		}
		
		return soma;
	}

}
