package principal;

import java.util.Scanner;

public class Menu

{
	public int escolha = 0;
	String cpf;
	String senha;

	Scanner read = new Scanner(System.in);

	/// MENU PRINCIPAL: ///
	
	public void ChamaMenu()

	{
		System.out.println("------------------------------------------------------------------");
		System.out.println("--------------------- Sistema Bancário JK  -----------------------");
		System.out.println("------------------------------------------------------------------\n");

		System.out.print("Digite seu CPF: ");
		cpf = read.next();

		System.out.print("Digite sua senha: ");
		senha = read.next();
		
		validaCadastro();
	}

	public void validaCadastro() 
	
	{

		if ((cpf.equals("cliente") && senha.equals("cliente"))) {

			menuCliente();

		} else if ((cpf.equals("gerente") && senha.equals("gerente"))) {

			menuGerente();

		} else if ((cpf.equals("diretor") && senha.equals("diretor"))) {

			menuDiretor();

		} else if ((cpf.equals("presidente") && senha.equals("presidente"))) {

			menuPresidente();
		}

		else {

			System.out.println("CPF ou senha não cadastrados!");
			System.out.println("Tente novamente!");
			
			ChamaMenu();

		}

	}

	// MENUS PESSOAS: //
	
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
				
				System.out.println("Sistema finalizado.");
				break;

			default:
				
				System.out.println("Opção inválida! \n");
				menuCliente();
				read.next();
				

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
				// relatorioGerente();
				break;

			case 4:
				System.out.println("Sistema finalizado.");
				break;

			default:
				
				System.out.println("Opção inválida! \n ");
				menuGerente();
				read.next();
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
			// relatorioGerente();
			break;

		case 4:
			// relatorioDiretor();

		case 5:
			System.out.println("Sistema finalizado.");
			break;

		default:
					
			System.out.println("Opção inválida! \n");	
			menuDiretor();
			read.next();
			
		}
		while (escolha != 5)
			;

	}

	public void menuPresidente() {

		System.out.println("\n ");
		System.out.println("Escolha uma opção: \n");
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
			// relatorioGerente();
			break;

		case 4:
			// relatorioDiretor();
			break;
		case 5:
			// relatorioPresidente();
			break;

		case 6:
			System.out.println("Programa finalizado. \n");
			break;

		default:
			
			System.out.println("Opção inválida!");
			menuPresidente();
			//System.out.print("Digite qualquer tecla para continuar.");
			read.next();
			//break;

		}
		while (escolha != 6)
			;

	}

	//////////////////////
}
