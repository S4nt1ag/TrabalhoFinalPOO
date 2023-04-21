package principal;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import contas.TipoConta;
import pessoa.Cargo;
import pessoa.Cliente;
import pessoa.Diretor;
import pessoa.Gerente;
import pessoa.Pessoa;
import pessoa.Presidente;

public class SistemaBancario

{

	public static void main(String[] args)

	{

		Pessoa pessoa1 = new Diretor("Isabel", "789456123", 4640, Cargo.DIRETOR, 2);
		Conta conta1 = new ContaCorrente(22, pessoa1, 2000.00, TipoConta.CONTA_CORRENTE);
		System.out.println(conta1.toString());

		Pessoa pessoa2 = new Presidente("Santiago", "123456789", 1234, Cargo.PRESIDENTE, 2);
		Conta conta2 = new ContaPoupanca(23, pessoa2, 3000.00, TipoConta.CONTA_POUPANCA);
		System.out.println(conta2.toString());

		conta1.sacar(200.00);
		conta1.transferir(100.00, conta2);
		conta1.depositar(200.00);
		System.out.println();
		
		System.out.println();
		conta2.sacar(200.00);
		conta2.depositar(200.00);
		conta2.transferir(100.00, conta1);
		System.out.println();
		conta1.extrato();
		System.out.println();
		conta2.extrato();
		
		System.out.println();
		System.out.println(conta1.getSaldo());
		System.out.println(conta2.getSaldo());

	}

}
