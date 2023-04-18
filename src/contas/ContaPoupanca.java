package contas;

import java.util.Scanner;

public class ContaPoupanca extends Conta {

	Scanner read = new Scanner(System.in);
	private double saldo;
	public final double TAXA_RENDIMENTO = 0.1;

	public void sacar(double valor) {

		if (valor <= 0) {
			System.out.println("Valor inválido para saque.");

		} else if (valor > this.saldo) {
			System.out.println("Saldo insuficiente.");

		} else {
			this.saldo -= valor;
			System.out.println("Saque realizado com sucesso!");
		}
	}

	public void depositar(double valor) {

		this.saldo += valor;
		System.out.println("Depósito realizado com sucesso!");

	}

	public double geraRelatorioRendimento() {

		int diasInvestidos;
		double rendimento = 0;
		double valorAplicado;

		System.out.println("Qual capital será investido");
		double valorAplicado1 = read.nextDouble();

		System.out.println("Informe a quantidade de dias que o capital ficará aplicado: ");
		int diasInvestidos1 = read.nextInt();

		rendimento = (valorAplicado1 * 0.022) + diasInvestidos1;
		return rendimento;

	}

}
