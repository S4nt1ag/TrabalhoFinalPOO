package contas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pessoa.Pessoa;

public class ContaCorrente extends Conta {

	public static final double TAXA_SAQUE = 0.10;
	public static final double TAXA_DEPOSITO = 0.10;
	public static final double TAXA_TRANSFERENCIA = 0.20;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();

	List<String> contaC = new ArrayList<String>();

	public ContaCorrente(int numero, Pessoa titular, double saldo, TipoConta tipo) {
		super(numero, titular, saldo, tipo);
	}

	/* 1. MOVIMENTAÇÕES NA CONTA */

	/* a. SAQUE */
	public boolean sacar(double valor) {

		if (valor + TAXA_SAQUE <= this.saldo) {
			this.saldo -= valor + TAXA_SAQUE;
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
			this.saldo -= valorTransferencia;
			destino.depositar(valor); //alterar nome depois 
			System.out.println("Transferência realizada com sucesso!");
			System.out.println("Data: " + sdf.format(date));
			contaC.add(sdf.format(date) + " Tranferencia " + valor);
			return true;
		}
		return false;
	}

	/* d. EXTRATO */
	public void extrato() {

		System.out.println("Extrato atual de conta corrente");
		System.out.println("Agência: " + "1" + "     conta: " + getNumero());
		System.out.println("Cliente: " + ((Pessoa) (titular)).getNome());
		for (String i : contaC) {
			System.out.println(i);
		}

	}

	/* RELATÓRIO */
	@Override
	public void relatorio() {
		System.out.println("Relatório: ");

	}

	@Override
	public String toString() {
		return "ContaCorrente [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

}
