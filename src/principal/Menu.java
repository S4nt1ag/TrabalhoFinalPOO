package principal;

import java.util.Scanner;

public class Menu

{

	public int escolha = 0;
	String cpf;
	String senha;

	Scanner read = new Scanner(System.in);

	public void ChamaMenu()

	{

		System.out.println("--------------------------------------------------------------");
		System.out.println("--------------------- Sistema Bancário JK  -------------------");
		System.out.println("--------------------------------------------------------------\n");

		System.out.print("Digite seu CPF: ");
		cpf = read.next();

		System.out.print("Entre com sua senha: ");
		senha = read.next();
		menuPrincipal();
	}

	public void menuPrincipal() {

		if ((cpf.equals("cliente") && senha.equals("cliente"))) {

			menuCliente();

		} else if ((cpf.equals("gerente") && senha.equals("gerente"))) {

			menuGerente();

		} else if ((cpf.equals("diretor") && senha.equals("diretor")))

		{

			menuDiretor();

		} else if ((cpf.equals("presidente") && senha.equals("presidente"))) {

			menuPresidente();
		}

		else {

			System.out.println(" Cpf ou senha não identificados ");
			System.out.println("Tente novamente ! ");
			ChamaMenu();

		}

	}

	public void menuCliente() {

		do {

			System.out.println("Escolha uma opção: ");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Sair");
			escolha = read.nextInt();

			switch (escolha) {
			case 1:

				// movimentacao();
				break;
			case 2:
				// relatorio();
				break;
			// outros casos

			case 3:
				break;

			default:
				System.out.println("Digite um número que seja válido ");
				System.out.print("Digite qualquer coisa para continuar");
				read.next();
				break;

			}

		} while (escolha != 3);

//movimentacao(){
		/*
		 * int escolha
		 * 
		 * switch (escolha) { case 1:
		 * 
		 * saque();
		 * 
		 * case 2: deposito();
		 * 
		 * 
		 * case 3: transfere();
		 * 
		 * case 4: geraExtrato();
		 * 
		 * break }
		 */

		// relatorio(){

		/*
		 * int escolha
		 * 
		 * switch (escolha) {
		 * 
		 * caso 1 :
		 * 
		 * geraSaldo();
		 * 
		 * caso 2:
		 * 
		 * geraRelatorioTributacao();
		 * 
		 * caso 3:
		 * 
		 * geraRelatorioRendimento();
		 * 
		 * caso 4:
		 * 
		 * desafio();
		 * 
		 * }
		 */

	}

	public void menuGerente() {

		do {

			System.out.println("Escolha uma opção: ");
			System.out.println("1 - Saldo");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Relatório Gerente");
			System.out.println("4 - Sair");
			escolha = read.nextInt();

			switch (escolha) {
			case 1:

				// geraSaldo();
				break;
			case 2:
				// relatorio(); (fazer super para adicionar o relatorio do número contas, na
				// mesma agência em que este gerente trabalha)

				break;
			// outros casos

			case 3:
			//	relatorioGerente();
				break;

			case 4:
				break;

			default:
				System.out.println("Digite um número que seja válido ");
				System.out.print("Digite qualquer coisa para continuar");
				read.next();
				break;

			}

		} while (escolha != 4);

	}

	public void menuDiretor() {

		System.out.println("Escolha uma opção: ");
		System.out.println("1 - Saldo");
		System.out.println("2 - Relatórios");
		System.out.println("3 - Relátorio Gerente");
		System.out.println("4 - Relatório Diretor");
		System.out.println("5 - Sair");
		escolha = read.nextInt();

		switch (escolha) {
		case 1:

			// geraSaldo();
			break;
		case 2:
			// relatorio();

			break;

		case 3:
			//relatorioGerente();
			break;

		case 4:
			//relatorioDiretor();

		case 5:
			break;

		default:
			System.out.println("Digite um número que seja válido ");
			System.out.print("Digite qualquer coisa para continuar");
			read.next();
			break;

		}
		while (escolha != 5)
			;

	}

	public void menuPresidente() {

		System.out.println("Escolha uma opção: ");
		System.out.println("1 - Saldo");
		System.out.println("2 - Relatórios");
		System.out.println("3 - Relátorio Gerente");
		System.out.println("4 - Relatório Diretor");
		System.out.println("5 - Relatório Presidente");
		System.out.println("6 - Sair");
		escolha = read.nextInt();

		switch (escolha) {
		case 1:

			// geraSaldo();
			break;
		case 2:
			// relatorio();

			break;

		case 3:
			//relatorioGerente();
			break;

		case 4:
			//relatorioDiretor();
			break;
		case 5:
			//relatorioPresidente();
			break;

		case 6:
			break;

		default:
			System.out.println("Digite um número que seja válido ");
			System.out.print("Digite qualquer coisa para continuar");
			read.next();
			break;

		}
		while (escolha != 6)
			;

	}

}
