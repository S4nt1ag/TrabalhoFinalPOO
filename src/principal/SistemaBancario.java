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
		Pessoa pessoa2 = new Presidente("Luiz", "987654321", 4321, Cargo.PRESIDENTE, 2);
		Conta conta2 = new ContaPoupanca(01, pessoa2, 60000.50, TipoConta.CONTA_POUPANCA);
		System.out.println(conta2.toString());

		Pessoa pessoa = new Cliente("Santiago", "123456789", 1234, Cargo.CLIENTE);
		Conta conta = new ContaCorrente(12, pessoa, 100.50, TipoConta.CONTA_CORRENTE);
		System.out.println(conta.toString());

		Pessoa pessoa3 = new Cliente("Alexandre", "123654789", 31415, Cargo.CLIENTE);
		Conta conta3 = new ContaPoupanca(13, pessoa3, 200.00, TipoConta.CONTA_POUPANCA);
		System.out.println(conta3.toString());

		Pessoa pessoa4 = new Diretor("Isabel", "789456123", 4640, Cargo.DIRETOR, 2);
		Conta conta4 = new ContaCorrente(22, pessoa4, 2000.55, TipoConta.CONTA_CORRENTE);
		System.out.println(conta4.toString());

		Pessoa pessoa5 = new Gerente("Maria", "879546213", 3333, Cargo.GERENTE, 2);
		Conta conta5 = new ContaPoupanca(17, pessoa5, 2000.25, TipoConta.CONTA_POUPANCA);
		System.out.println(conta5.toString());
	}

}
