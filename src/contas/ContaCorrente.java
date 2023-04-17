package contas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaCorrente extends Conta{
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/aaaa HH:mm:ss");
	Date date = new Date();
	
	public ContaCorrente(String nome, String cpf, Integer senha, String email, Integer telefone, String endereco) {
		super(nome, cpf, senha, email, telefone, endereco);
		// TODO Auto-generated constructor stub
	}


	public void extratoBancario() {
		System.out.println("### Extrato da Conta Corrente ###");
		System.out.println();
		System.out.println("Titular: " + this.getNome());
		System.out.println("Saldo: " + this.getSaldo());
		System.out.println();
		System.out.println("Data: " + sdf.format(date));
	}

	public void infoPessoa() {
		System.out.println("### Informações cliente ###");
		System.out.println();
		System.out.println("Nome:		" + this.getNome());
		System.out.println("Cpf:		" + this.getCpf());
		System.out.println();
		System.out.println("Data: " + sdf.format(date));
	}

	public void deposito() {
		if (verificaDeposito() == true) {
			System.out.println("### Deposito concluido ###");
			System.out.println();
			System.out.println("Deposito valor: " + this.getDeposito());
			System.out.println();
			System.out.println("Data: " + sdf.format(date));
		} else {
			System.out.println("### impossivel depositar o valor ###");
		}
	}

	public void saque() {
		if (verificaSaque() == true) {
			System.out.println("### Saque concluído ###");
			System.out.println();
			System.out.println("Saque valor: " + this.getSaque());
			System.out.println();
			System.out.println("Data: " + sdf.format(date));
		} else {
			System.out.println("### impossível sacar esse valor ###");
		}
	
	}

}
