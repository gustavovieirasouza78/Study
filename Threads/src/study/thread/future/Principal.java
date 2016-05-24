package study.thread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Principal {

	public static void main(String[] args) {
		NotaFiscal[] notas = new NotaFiscal[10000];
		Random r = new Random(System.currentTimeMillis());
		
		for (int i = 0; i < notas.length; i++) {
			notas[i] = new NotaFiscal(Math.abs(r.nextInt()));
		}

		ExecutorService es = Executors.newCachedThreadPool();
		
		List<Future<Integer>> future = new ArrayList<Future<Integer>>() ;

		for (int i = 0; i < 10000; i+=100) {
			Soma nfs = new Soma(notas, i, i+100);
			Future<Integer> resultado = es.submit(nfs);
			future.add(resultado);
		}
		
		long totalnotas = 0;
		for (Future<Integer> future2 : future) {
			try {
				totalnotas += future2.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("O total das notas é: " + totalnotas);
		
		es.shutdown();
	}

}
