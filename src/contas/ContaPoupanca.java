package contas;

public class ContaPoupanca extends Conta {

	private double saldo;

	public ContaPoupanca(String nome, String cpf, Integer senha, String email, Integer telefone, String endereco) {
		super(nome, cpf, senha, email, telefone, endereco);
		
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

		this.saldo += valor;
		System.out.println("Depósito realizado com sucesso!");

	}


}
