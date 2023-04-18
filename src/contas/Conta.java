package contas;

import interfaces.Aplicacao;

public abstract class Conta implements Aplicacao {
	private double saldo;
	private int agencia;
	private String cpfDoTitular;
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public String getCpfDoTitular() {
		return cpfDoTitular;
	}
	public void setCpfDoTitular(String cpfDoTitular) {
		this.cpfDoTitular = cpfDoTitular;
	} 
	public void sacar() {
	}
	public void depositar() {
	}
	public void transferir() {
	}
}
