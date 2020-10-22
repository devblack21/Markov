
package controller;
import java.io.IOException;

public class Start {

	public static void main(String[] args) throws IOException {
		
		LeitorArquivo la = new LeitorArquivo("insira o caminho do arquivo");
		String a = null;
		Justifield justifield;
		StringBuffer sbBuffer = new StringBuffer();
		while ((a = la.proximaLinha()) != null) {
			sbBuffer.append(a);
		}
		
		try {
			
			justifield = new Justifield(sbBuffer.toString());
			System.out.println(justifield.retornarTextoJustificado());
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
}