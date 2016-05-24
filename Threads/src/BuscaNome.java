import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class BuscaNome implements Runnable {

	private String nomeArquivo;
	private String procurado;
	
	public BuscaNome(String nomeArquivo, String procurado){
		this.nomeArquivo = nomeArquivo;
		this.procurado = procurado;
	}
	
	@Override
	public void run() {
		Scanner sc;
		try {
			sc = new Scanner(new FileInputStream(nomeArquivo));

			int numeroLinha = 1;
			while (sc.hasNext()){
				String line =  sc.nextLine();
				if (line.contains(procurado)){
						System.out.println("Encontrado no arquivo: " + nomeArquivo + 
										   " na linha: " + numeroLinha + 
										   " \"" + line + "\"");
				}
				numeroLinha++;
			}
			sc.close();		
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
			e.printStackTrace();
		}
	}

}
