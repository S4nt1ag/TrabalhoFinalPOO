package contas;

import pessoa.Pessoa;

public class ContaCorrente extends Conta {

	public static final double TAXA_SAQUE = 0.10;
	public static final double TAXA_DEPOSITO = 0.10;
	public static final double TAXA_TRANSFERENCIA = 0.20;

	public ContaCorrente(int numero, Pessoa titular, double saldo, TipoConta tipo) {
		super(numero, titular, saldo, tipo);
	}

	public void sacar() {

	}

	public void tranferir() {

	}

	public void depositar() {

	}

	@Override
	public String toString() {
		return "ContaCorrente [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

}
