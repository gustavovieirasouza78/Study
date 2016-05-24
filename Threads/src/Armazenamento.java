
public class Armazenamento {
	
	public static Armazenamento instancia = new Armazenamento();
	
	private String[] lista = new String[100];
	private int contador = 0;
	
	
	public synchronized void adicionaElemento(String elemento) {
		lista[contador] = elemento;
		contador++;
		if(contador == 100){
			this.notify();
		}
	}
	
	public String[] recuperaLista(){
		return lista;
	}

	public int getContador() {
		return contador;
	}
	

}
