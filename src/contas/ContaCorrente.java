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
	private double totalTaxa = 0.0;

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	Date date = new Date();

	List<String> contaC = new ArrayList<String>();

	public ContaCorrente(int numero, Pessoa titular, double saldo,Agencias agencia) {
		super(numero, titular, saldo, agencia);
		this.tipo = TipoConta.CONTA_CORRENTE;

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
	public boolean transferido(double valor) {
		
		if (valor <= 0) {
			return false;
		} else {
			this.saldo += valor;
			this.totalGasto += TAXA_DEPOSITO;
			contaC.add(sdf.format(date) + " Tranferido " + valor);
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
			destino.transferido(valor);
			this.totalGasto += valor;
			this.totalTaxa += TAXA_TRANSFERENCIA;
			System.out.println("Transferência realizada com sucesso!");
			System.out.println("Data: " + sdf.format(date));
			contaC.add(sdf.format(date) + " Transferência " + valor);
			return true;
		}
		return false;
	}

	public double getTotalGastos() {
		return totalGasto;
	}
	

	public double getTotalTaxa() {
		return totalTaxa;
	}


	/* d. EXTRATO */
	public void extrato() {

		System.out.println("Extrato atual de conta corrente");
		System.out.println("Agência: " + getAgencia() + "     Conta: " + getNumero());
		System.out.println("Cliente: " + ((Pessoa) (titular)).getNome());

		for (String i : contaC) {
			System.out.println(i);
		}

	}

	/* RELATÓRIO */
	@Override
	public void relatorio() {

		try {

			FileWriter arq = new FileWriter(".//relatorios//relatorioContaCorrente" + titular.getNome() + sdf.format(date) + ".txt");
			PrintWriter gravarArq = new PrintWriter(arq);

			gravarArq.println("----------- RELATÓRIO DE TRIBUTAÇÃO DE CONTA CORRENTE -----------\n");
			gravarArq.printf("            Saldo: R$ %.2f%n", this.saldo);
			gravarArq.printf("            Total gasto em operações: R$ %.2f%n", this.totalGasto);
			gravarArq.println("\n----------- TAXAS DE TRANSAÇÃO -----------------------------------\n");
			gravarArq.println("            Taxa de saque: R$ " + ContaCorrente.TAXA_SAQUE);
			gravarArq.println("            Taxa de depósito: R$ " + ContaCorrente.TAXA_DEPOSITO);
			gravarArq.println("            Taxa de transferência: R$ " + ContaCorrente.TAXA_TRANSFERENCIA);
			gravarArq.println();
			gravarArq.println("----------------Extrato atual de conta Corrente----------------------");
			gravarArq.println();
	        gravarArq.println("Agência: " + getAgencia() + "     conta: " + getNumero());
	        gravarArq.println("Cliente: " + ((Pessoa) (titular)).getNome());
	        for (String i : contaC) {
				gravarArq.println(i);
			}

			arq.close();


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
		return    "--------------------------------------------------------------------------------------------\n" 
				+ "numero: " + numero + titular + ", saldo: " + saldo + ", tipo: " + tipo;
	}

}
