import java.nio.channels.Pipe.SinkChannel;

public class Conta implements Comparable<Conta> {
	private int agencia;
	private int numero;
	private double saldo;
	private double limite;
	private Cliente cliente;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

	public Conta(int numero) {
		setNumero(numero);
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public synchronized double getSaldo() {
		return saldo;
	}
	public synchronized void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public int compareTo(Conta conta){
		if(this.numero < conta.numero)
			return -1;
		if(this.numero > conta.numero)
			return 1;
		else
			return 0;
	}

	public synchronized void deposita(double d) {
		double saldo = getSaldo();
		saldo = saldo + d;
		setSaldo(saldo);
	}

	
}
