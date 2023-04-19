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

	public void sacar() {

	}

	public void tranferir() {

	}

	public void depositar() {

	}

	@Override
	public String toString() {
		return "ContaPoupanca [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

}
