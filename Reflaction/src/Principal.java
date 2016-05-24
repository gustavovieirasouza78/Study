import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Principal {

	public static void main(String[] args) {
		Mapeador mapeador = new Mapeador();
		try {
			mapeador.load("classes.prop");
			System.out.println(mapeador.getImplementacao(List.class));
			System.out.println(mapeador.getImplementacao(Map.class));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
