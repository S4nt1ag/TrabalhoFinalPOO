package contas;

import pessoa.Pessoa;
import testetrabalhocontas.Conta;

public class ContaCorrente extends Conta {

	public static final double TAXA_SAQUE = 0.10;
	public static final double TAXA_DEPOSITO = 0.10;
	public static final double TAXA_TRANSFERENCIA = 0.20;

	public ContaCorrente(int numero, Pessoa titular, double saldo, TipoConta tipo) {
		super(numero, titular, saldo, tipo);
	}

	public boolean sacar(double valor) {

		if (valor + TAXA_SAQUE <= this.saldo) {
			this.saldo -= valor+ TAXA_SAQUE;
			System.out.println("Saque realizado com sucesso!");
			return true;
			
		} else if (valor + TAXA_SAQUE > this.saldo) {
			System.out.println("Saldo insuficiente.");

		} else {
			System.out.println("Valor inválido para saque.");
		}

		return false;

	}
	
	

	public boolean depositar(double valor) {

		if (valor <= 0) {
			System.out.println("Valor inválido para depósito.");
			return false;
		} else {
			this.saldo += valor-TAXA_DEPOSITO;
			System.out.println("Depósito realizado com sucesso!");
			return true;
		}
	
	}

	public void transferir(Conta contaDestino, double valor) {

        if(this.saldo + TAXA_TRANSFERENCIA <= valor) {
            System.out.println("Seu saldo é insuficiente!");
        }
        else {
            this.saldo -= valor + TAXA_TRANSFERENCIA;
            contaDestino.saldo += valor;


            System.out.println("Seu saldo é de: " + this.saldo);
        }
    }

	@Override
	public String toString() {
		return "ContaCorrente [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

	@Override
	public void relatorio() {
		// TODO Auto-generated method stub

	}

	/*public boolean sacar() {
		// TODO Auto-generated method stub
		return false;
	}*/

	

}
