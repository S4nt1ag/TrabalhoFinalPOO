package contas;

import java.util.Scanner;

import pessoa.Pessoa;

public class ContaPoupanca extends Conta {

	Scanner read = new Scanner(System.in);
	public final double TAXA_RENDIMENTO = 0.1;

	public ContaPoupanca(int numero, Pessoa titular, double saldo, TipoConta tipo) {
		super(numero, titular, saldo, tipo);
	}

	public double geraRelatorioRendimento() {

		int diasInvestidos;
		double rendimento = 0;
		double valorAplicado;

		System.out.println("Qual capital será investido");
		valorAplicado = read.nextDouble();

		System.out.println("Informe a quantidade de dias que o capital ficará aplicado: ");
		diasInvestidos = read.nextInt();

		rendimento = (valorAplicado * 0.022) + diasInvestidos;
		return rendimento;

	}

	//aqui	
	public boolean sacar(double valor) {

		if (valor <= 0) {
			System.out.println("Valor inválido para saque.");

		} else if (valor > this.saldo) {
			System.out.println("Saldo insuficiente.");

		} else {
			this.saldo -= valor;
			System.out.println("Saque realizado com sucesso.");
			return true;
		}
		return false;
	}

	public boolean depositar(double valor) {

		if (valor <= 0) {
			System.out.println("Valor inválido para depósito.");
			return false;
		} else {
			this.saldo += valor;
			System.out.println("Depósito realizado com sucesso!");
			return true;
		}
	
	}
	
	public void transferir(double valor, Conta destino) {
	    
		if (valor <= 0) {
	        System.out.println("Valor inválido para transferência.");
	        
	    } else if (valor > this.saldo) {
	        System.out.println("Saldo insuficiente para realizar a transferência.");
	        
	    } else {
	        double valorTransferencia = valor;
	        this.saldo -= valorTransferencia;
	        destino.depositar(valor);
	        System.out.println("Transferência realizada com sucesso!");
	    }
	}


	@Override
	public String toString() {
		return "ContaPoupanca [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

	@Override
	public void relatorio() {
		// TODO Auto-generated method stub
		
	}

	public boolean sacar() {
		// TODO Auto-generated method stub
		return false;
	}

}
