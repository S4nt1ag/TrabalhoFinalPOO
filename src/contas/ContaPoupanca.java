package contas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import pessoa.Pessoa;

public class ContaPoupanca extends Conta {

	Scanner read = new Scanner(System.in);
	public final double TAXA_RENDIMENTO = 0.1;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();

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

	public boolean sacar(double valor) {

		if (valor <= 0) {
			System.out.println("Valor inválido para saque.");

		} else if (valor > this.saldo) {
			System.out.println("Saldo insuficiente.");

		} else {
			this.saldo -= valor;
			System.out.println("Saque realizado com sucesso.");
			System.out.println("Data: " + sdf.format(date));
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
			System.out.println("Data: " + sdf.format(date));
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
			System.out.println("Data: " + sdf.format(date));
		}
	}

	public void extrato() {
		
		System.out.println("Extrato atual de conta poupança");
		System.out.println("Agência: " +"1" +"     conta: " + getNumero());
		System.out.println("Cliente: " + ((Pessoa)(titular)).getNome());	
		
		}
	
	@Override
	public void relatorio() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "ContaPoupanca [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

}
