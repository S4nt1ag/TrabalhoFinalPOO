package contas;

import java.io.IOException;

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

	public boolean sacar(double valor) {
		return false;
		
	}

	public boolean depositar(double valor) {
		return false;
	}

	public boolean transferir(double valor, Conta contaDestino) {
		return false;
		
		
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

	public void relatorio(Double valorSaque, Double valorDeposito, Double valorTransferenciaRemetente) {
	
	Double total;
	
	total = valorSaque * 0.10 + valorDeposito * 0.10 + valorTransferenciaRemetente* 0.20;
	
// Adicionalmente deverão ser informados os valores que o banco
	//cobra por cada operação bancária;
}

	public void extrato() {
		
	}

	public void relatorio() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
