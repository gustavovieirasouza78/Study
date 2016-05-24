import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		
		palavras.add("XX");
		palavras.add("bbb");
		palavras.add("dccc");
		palavras.add("AA");
		
		Comparator<String> comparador = new CompararPorTamanho();
		palavras.sort(comparador);
		
		palavras.sort(Comparator.comparing(s -> s.length()));  //lambda
		
		palavras.sort(Comparator.comparing(String::length));
		palavras.forEach(System.out::println);
		
		Consumer<String> consumer = s -> System.out.println(s);
		palavras.forEach(consumer);
		
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		palavras.forEach(System.out::println);

		
		for(String palavra:palavras){
			System.out.println(palavra);
		}		
	}
}
