import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestaColecoes {

	public static void main(String[] args) {
		
		List<String> nomes = new ArrayList<>();  //Lists allow repetition
		nomes.add("Gustavo");
		nomes.add("Damaris");
		nomes.add("Beatriz");
		nomes.add("Mateus");
		
		for(String nome : nomes){
			System.out.println(nome);
		}
		
		boolean temDamaris = nomes.contains("Damaris");
		if(temDamaris){
			Collections.sort(nomes);
			for(String nome : nomes){
				System.out.println(nome);
			}
		}
		
		List<Conta> contas = new ArrayList<Conta>();
		
		Conta c1 = new Conta(14560);
		Conta c2 = new Conta(4510);
		Conta c3 = new Conta(1063);		
		
		contas.add(c1);
		contas.add(c2);
		contas.add(c3);
		
		for(Conta conta: contas){
			System.out.println(conta.getNumero());
		}
		
		Collections.sort(contas);
		
		for(Conta conta: contas){
			System.out.println(conta.getNumero());
		}
		
		Set<String> nomesSet = new HashSet<String>();  // Set do not allows duplicate 
		nomesSet.add("Gustavo");
		nomesSet.add("Damaris");
		nomesSet.add("Gustavo");
		
		System.out.println(nomesSet.size());
		
		Map<String, Conta> contasMap = new HashMap<String, Conta>(); // Map, you can use a key
		contasMap.put("Damaris", c1);
		contasMap.put("Gustavo", c2);
		
		System.out.println(contasMap.size());
		System.out.println(contasMap.get("Damaris").getNumero());
		System.out.println(contasMap.get("Gustavo").getNumero());
	}
	

}
