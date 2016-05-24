
public class BarradeProgresso implements Runnable{

	public void run(){
		for (int i=0; i<10000; i++){
			System.out.println("Barra de Progresso");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}

	
}
