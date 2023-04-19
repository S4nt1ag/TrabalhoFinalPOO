package contas;
//pamonha
import pessoa.Pessoa;

public class ContaCorrente extends Conta {

	public static final double TAXA_SAQUE = 0.10;
	public static final double TAXA_DEPOSITO = 0.10;
	public static final double TAXA_TRANSFERENCIA = 0.20;

	public ContaCorrente(int numero, Pessoa titular, double saldo, TipoConta tipo) {
		super(numero, titular, saldo, tipo);
	}

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
		
		if (valor <= 0) {
			System.out.println("Valor inválido para depósito.");
			
		} else {
			this.saldo += valor;
			System.out.println("Depósito realizado com sucesso!");
		}
	}

	public void tranferir() {

	}

	

	@Override
	public String toString() {
		return "ContaCorrente [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

	@Override
	public void relatorio() {
		// TODO Auto-generated method stub
		
	}

}
