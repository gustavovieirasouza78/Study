package study.thred.basic;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Executa {

	public Executa() {

	}

	public static void main(String[] args) {
		JFrame janela = new JFrame("Multiplicação Demorada");
		JPanel painel = new JPanel();
		
		JTextField primeiro = new JTextField(10);
		JTextField segundo = new JTextField(10);
		
		JButton botaoCalcular = new JButton(" = ");		
		
		//JLabel resultado = new JLabel("          =         ");
		JTextArea resultado = new JTextArea();
		
		botaoCalcular.addActionListener(new Multiplicar(primeiro, segundo, resultado));
		
		painel.add(primeiro);
		painel.add(new JLabel(" x  "));
		painel.add(segundo);
		painel.add(botaoCalcular);
		painel.add(resultado);
		
		janela.add(painel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);
		
		
	}
}
