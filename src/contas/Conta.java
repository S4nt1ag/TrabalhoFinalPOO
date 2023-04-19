package contas;

import interfaces.Aplicacao;
import pessoa.Pessoa;

public abstract class Conta implements Aplicacao {

	protected int numero;
	protected Pessoa titular;
	protected double saldo;
	protected TipoConta tipo;

	public Conta(int numero, Pessoa titular, double saldo, TipoConta tipo) {
		super();
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.tipo = tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Pessoa getTitular() {
		return titular;
	}

	public void setTitular(Pessoa titular) {
		this.titular = titular;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public void sacar() {
	}

	public void depositar() {
	}

	public void transferir() {
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

}
