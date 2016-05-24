package study.thred.basic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * The ideia is have a very delay class
 */
public class Multiplicar implements ActionListener {

	private JTextField primeiro;
	private JTextField segundo;
	private JTextArea resultado;
	
	public Multiplicar(JTextField primeiro, JTextField segundo, JTextArea resultado2) {
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.resultado = resultado2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Runnable r = actionPerformedRunnable();
		Thread t = new Thread(r);
		t.start();
	}

	private Runnable actionPerformedRunnable() {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				resultado.setText("...aguarde!");
				long valor1 =  Long.parseLong(primeiro.getText());
				long valor2 =  Long.parseLong(segundo.getText());
				BigInteger calculo = new BigInteger("0");
				for (int i = 0; i < valor1; i++) {
					for (int j = 0; j < valor2; j++) {
						calculo = calculo.add(new BigInteger("1"));
						
					}
					
				}
				String texto = valor1 + " x " + valor2 + " = " + calculo.toString();
				resultado.setText(resultado.getText() + "\n" + texto);
			}
		};
		return r;
	}

}
