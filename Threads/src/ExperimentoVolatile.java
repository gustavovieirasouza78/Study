
public class ExperimentoVolatile {

	public static void main(String[] args) {
		ExperimentoVolatile ev = new ExperimentoVolatile();
		ev.executar();
	}
	
	private volatile int a = 0;
	private volatile int b = 0;
	private boolean parar = false;
	
	public void executar(){

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (!parar){
					incrementar();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (!parar){
					verificar();
				}
			}
		}).start();		
		
		
		
	}
	
	public void incrementar(){
		a +=1;
		b +=1;
		if(a == Integer.MAX_VALUE){
			a = 0;
			b = 0;
		}
		
	}
	
	public void verificar(){
		if (b > a){
			System.out.println("Vixi, a = " + a + " e b = " + b);
			parar = true;
		}else{
			System.out.println("Tudo sobre controle, a = " + a + " e b =" + b);
		}
	}

}
