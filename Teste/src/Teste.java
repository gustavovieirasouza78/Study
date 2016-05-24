
import java.util.ArrayList;

/**
 * Teste javaDoc
 * 
 * @author Gustavo
 * @function Print Number Names
 * 
 * Call the methods
 * 
 */
public class Teste {
	public static void main (String args[]){
	  String[] arr = {"Um", "Dois", "Tres","Quatro"};

	  Print print = new Print();
	  try {
		print.print(arr);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Print Error");
		e.printStackTrace();
	}
	  
	Math math = new Math();
	double pi = math.PI();
	print.print(pi);
	  
	}

  
}
