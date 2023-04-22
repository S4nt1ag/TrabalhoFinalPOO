package contas;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pessoa.Pessoa;

public class ContaCorrente extends Conta {

	public static final double TAXA_SAQUE = 0.10;
	public static final double TAXA_DEPOSITO = 0.10;
	public static final double TAXA_TRANSFERENCIA = 0.20;

	private double totalGasto;

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	Date date = new Date();

	List<String> contaC = new ArrayList<String>();

	public ContaCorrente(int numero, Pessoa titular, double saldo, TipoConta tipo, Agencias agencia) {
		super(numero, titular, saldo, tipo, agencia);

	}

	/* 1. MOVIMENTAÇÕES NA CONTA */

	/* a. SAQUE */
	public boolean sacar(double valor) {

		if (valor + TAXA_SAQUE <= this.saldo) {
			this.saldo -= valor + TAXA_SAQUE;
			this.totalGasto = valor + TAXA_SAQUE;
			System.out.println("Saque realizado com sucesso!");
			System.out.println("Data: " + sdf.format(date));
			contaC.add(sdf.format(date) + " Saque " + valor);
			return true;

		} else if (valor + TAXA_SAQUE > this.saldo) {

			System.out.println("Saldo insuficiente.");

		} else {
			System.out.println("Valor inválido para saque.");
		}

		return false;

	}

	/* b. DEPÓSITO */
	public boolean depositar(double valor) {

		if (valor <= 0) {
			System.out.println("Valor inválido para depósito.");
			return false;
		} else {
			this.saldo += valor - TAXA_DEPOSITO;
			this.totalGasto += TAXA_DEPOSITO;
			System.out.println("Depósito realizado com sucesso!");
			System.out.println("Data: " + sdf.format(date));
			contaC.add(sdf.format(date) + " Depósito " + valor);
			return true;
		}
	}

	/* c. TRANSFERÊNCIA */
	public boolean transferir(double valor, Conta destino) {

		if (valor <= 0) {
			System.out.println("Valor inválido para transferência.");

		} else if (valor > this.saldo) {
			System.out.println("Saldo insuficiente para realizar a transferência.");

		} else {
			double valorTransferencia = valor;
			this.saldo -= (valorTransferencia + TAXA_TRANSFERENCIA);
			destino.depositar(valor);
			this.totalGasto += valor;
			System.out.println("Transferência realizada com sucesso!");
			System.out.println("Data: " + sdf.format(date));
			contaC.add(sdf.format(date) + " Tranferencia " + valor);
			return true;
		}
		return false;
	}

	public double getTotalGastos() {
		return totalGasto;
	}

	/* d. EXTRATO */
	public void extrato() {

		System.out.println("Extrato atual de conta corrente");
		System.out.println("Agência: " + "1" + "     Conta: " + getNumero());
		System.out.println("Cliente: " + ((Pessoa) (titular)).getNome());

		for (String i : contaC) {
			System.out.println(i);
		}

	}

	/* RELATÓRIO */
	@Override
	public void relatorio() {

		try {

			FileWriter arq = new FileWriter(".//relatorios//relatorioContaCorrente" + sdf.format(date) + ".txt");
			PrintWriter gravarArq = new PrintWriter(arq);

			gravarArq.println("----------- RELATÓRIO DE TRIBUTAÇÃO DE CONTA CORRENTE -----------\n");
			gravarArq.printf("            Saldo: R$ %.2f%n", this.saldo);
			gravarArq.printf("            Total gasto em operações: R$ %.2f%n", this.totalGasto);
			gravarArq.println("\n----------- TAXAS DE TRANSAÇÃO -----------------------------------\n");
			gravarArq.println("            Taxa de saque: R$ " + ContaCorrente.TAXA_SAQUE);
			gravarArq.println("            Taxa de depósito: R$ " + ContaCorrente.TAXA_DEPOSITO);
			gravarArq.println("            Taxa de transferência: R$ " + ContaCorrente.TAXA_TRANSFERENCIA);

			arq.close();

			System.out.println("Relatório em .txt gerado com sucesso!");

		} catch (IOException e) {
			System.out.println(" " + e.getMessage());
		}
	}

	public void OlharRelatorio() {
		System.out.println("----------- RELATÓRIO DE TRIBUTAÇÃO DE CONTA CORRENTE -----------\n");
		System.out.printf("            Saldo: R$ %.2f%n", this.saldo);
		System.out.printf("            Total gasto em operações: R$ %.2f%n", this.totalGasto);
		System.out.println("\n----------- TAXAS DE TRANSAÇÃO -----------------------------------\n");
		System.out.println("            Taxa de saque: R$ " + ContaCorrente.TAXA_SAQUE);
		System.out.println("            Taxa de depósito: R$ " + ContaCorrente.TAXA_DEPOSITO);
		System.out.println("            Taxa de transferência: R$ " + ContaCorrente.TAXA_TRANSFERENCIA);
	}

	@Override
	public String toString() {
		return "ContaCorrente [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

}
