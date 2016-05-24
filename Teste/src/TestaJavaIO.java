import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Scanner;

public class TestaJavaIO {

	public static void main(String[] args) throws IOException {

		// Using InputStream
		InputStream is = new FileInputStream("leitura.txt");	// bytes
		InputStreamReader isr = new InputStreamReader(is);		// char
		BufferedReader br = new BufferedReader(isr);			// lines
			
		OutputStream os = new FileOutputStream("saida.txt");	//bytes
		OutputStreamWriter osw = new OutputStreamWriter(os);	// char
		BufferedWriter bw = new BufferedWriter(osw);			//lines
		
		String linha = br.readLine();
		
		while (linha != null){
			bw.append(linha);
			bw.newLine();
			linha = br.readLine();
		}	
		
		br.close();
		bw.close();

		
		//Easier to use Scanner method
		Scanner sc = new Scanner(new FileInputStream("leitura.txt"));
		PrintStream ps = new PrintStream("saida.txt");
		while (sc.hasNext()){
			ps.println(sc.nextLine());
		}
		sc.close();
		ps.close();
		
	}

}
