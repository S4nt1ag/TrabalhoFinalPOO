package contas;

import java.text.SimpleDateFormat;
import java.util.Date;

import pessoa.Pessoa;

public class ContaCorrente extends Conta {

	public static final double TAXA_SAQUE = 0.10;
	public static final double TAXA_DEPOSITO = 0.10;
	public static final double TAXA_TRANSFERENCIA = 0.20;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date =  new Date();
    
	public ContaCorrente(int numero, Pessoa titular, double saldo, TipoConta tipo) {
		super(numero, titular, saldo, tipo);
	}

	/*1. MOVIMENTAÇÕES NA CONTA*/
	
	/*a. SAQUE*/	
    public boolean sacar(double valor) {

		if (valor + TAXA_SAQUE <= this.saldo) {
			this.saldo -= valor+ TAXA_SAQUE;
			System.out.println("Saque realizado com sucesso!");
			System.out.println("Data: " + sdf.format(date));
			return true;
			
		} else if (valor + TAXA_SAQUE > this.saldo) {
			System.out.println("Saldo insuficiente.");

		} else {
			System.out.println("Valor inválido para saque.");
		}

		return false;

	}
	
    /*b. DEPÓSITO*/
	public boolean depositar(double valor) {

		if (valor <= 0) {
			System.out.println("Valor inválido para depósito.");
			return false;
		} else {
			this.saldo += valor-TAXA_DEPOSITO;
			System.out.println("Depósito realizado com sucesso!");
			System.out.println("Data: " + sdf.format(date));
			return true;
		}
	
	}

	/*c. TRANSFERÊNCIA*/
	public void transferir(Conta contaDestino, double valor) {

        if(this.saldo + TAXA_TRANSFERENCIA <= valor) {
            System.out.println("Seu saldo é insuficiente!");
        }
        else {
            this.saldo -= valor + TAXA_TRANSFERENCIA;
            contaDestino.saldo += valor;

            System.out.println("Transferência realizada com sucesso!");
            System.out.println("Data: " + sdf.format(date));
        }
    }

	/*d. EXTRATO*/
	public void extrato() {
		
		System.out.println("Extrato atual de conta corrente");
		System.out.println("Agência: " +"1" +"     conta: " + getNumero());
		System.out.println("Cliente: " + ((Pessoa)(titular)).getNome());
		
		}
	
	/*RELATÓRIO*/
	@Override
	public void relatorio() {
		System.out.println("Relatório: ");

	}

	@Override
	public String toString() {
		return "ContaCorrente [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

	
	
}
