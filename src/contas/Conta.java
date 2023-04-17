package contas;

import pessoa.Cliente;

public class Conta extends Cliente {

	public Conta(String nome, String cpf, Integer senha, String email, Integer telefone, String endereco) {
		super(nome, cpf, senha, email, telefone, endereco);
		/
	}

	private double saldo;
	private double deposito;
	private double saque;

	public boolean verificaDeposito() {
		if (this.deposito > 0) {
			this.saldo += this.deposito;
			return true;
		} else {
			return false;
		}

	}

	public boolean verificaSaque() {
		if (this.saque <= this.saldo) {
			this.saldo -= this.saque;
			return true;
		} else {
			return false;
		}
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getDeposito() {
		return deposito;
	}

	public void setDeposito(Double deposito) {
		this.deposito = deposito;

	}

	public double getSaque() {
		return saque;
	}

	public void setSaque(double saque) {
		this.saque = saque;
	}

}
