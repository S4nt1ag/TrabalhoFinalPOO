package principal;

import java.util.Scanner;

import contas.Conta;

public class Menu

{
	public char escolha = ' ';
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

	public void menuCliente(Conta usuario) {

		do {

			System.out.println("Escolha uma opção: ");
			System.out.println("1 - Movimentações na Conta.");
			System.out.println("2 - Relatórios.");
			System.out.println("3 - Sair.");
			escolha = read.next().charAt(0);

			switch (escolha) {

			case '1':

				movimentacoes();
				
				break;
				
				System.out.println("Movimentações na conta ");
				System.out.println("Escolha uma opção: ");
				System.out.println("a. Saque.");
				System.out.println("b. Depósito.");
				System.out.println("c. Transferência.");
				System.out.println("d. Extrato da conta.");
				System.out.println("e. Voltar ao menu anterior.");
				System.out.println("f. Finalizar programa.");
				escolha = read.next().charAt(0);

				switch (escolha) {

				case 'a':

					System.out.println("Digite o valor do saque");
					double valorSaque = read.nextDouble();
					usuario.sacar(valorSaque);
					menuCliente(usuario);

					break;

				case 'b':

					System.out.println("Digite o valor do deposito");
					double valorDeposito = read.nextDouble();
					usuario.depositar(valorDeposito);
					menuCliente(usuario);

					break;

				case 'c':
					System.out.println("Digite o valor que deseja transferir");
					double valorTransferencia = read.nextDouble();
					usuario.transferir(valorTransferencia, conta2);
					break;

				case 'd':
					System.out.println("Extrato da conta");

					break;

				case 'e':
					System.out.println("Voltar ao menu anterior.");

					break;

				case 'f':
					System.out.println("Sair do programa.");

					break;
				}

				break;

			case '2':
				// relatorio();
				break;
			// outros casos

			case '3':

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

	public void movimentacoes() {
		
	}
	
	
	public void menuGerente(Conta usuario, Conta conta2) {

		do {

			System.out.println("Escolha uma opção: ");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Relatório Gerente");
			System.out.println("4 - Sair");
			escolha = read.next().charAt(0);
		switch (escolha) {
			
			case '1':
				
				System.out.println("Movimentações na conta ");
				System.out.println("Escolha uma opção: ");
				System.out.println("a. Saque");
				System.out.println("b. Depósito");
				System.out.println("c. Transferência");
				System.out.println("d. Extrato da conta");
				escolha = read.next().charAt(0);
		
		
		switch(escolha) {
				
				case 'a':
					
					System.out.println("Digite o valor do saque");
					double valor=read.nextDouble();
					usuario.sacar(valor);
					menuGerente(usuario);
					
					break;
					
				case 'b':
					
					System.out.println("Digite o valor do deposito");
					double valorDeposito=read.nextDouble();
					usuario.depositar(valor);
					menuGerente(usuario);
					
					break;
					
				case 'c':
					System.out.println("Digite o valor que deseja transferir");
					double valorTransferencia=read.nextDouble();
					usuario.transferir(100.00, conta2);
					break;
					
				case 'd':
					break;
					
				case 'e':
					break;
				}
				
				
				break;

	public void menuDiretor(Conta usuario, Conta conta2) {

		System.out.println("Escolha uma opção: ");
		System.out.println("1 - Movimentações na Conta");
		System.out.println("2 - Relatórios");
		System.out.println("3 - Relátorio Gerente");
		System.out.println("4 - Relatório Diretor");
		System.out.println("5 - Sair");
		escolha = read.next().charAt(0);

		switch (escolha) {
			
			case '1':
				
				System.out.println("Movimentações na conta ");
				System.out.println("Escolha uma opção: ");
				System.out.println("a. Saque");
				System.out.println("b. Depósito");
				System.out.println("c. Transferência");
				System.out.println("d. Extrato da conta");
				escolha = read.next().charAt(0);
	switch(escolha) {
				
				case 'a':
					
					System.out.println("Digite o valor do saque");
					double valor=read.nextDouble();
					usuario.sacar(valor);
					menuDiretor(usuario);
					
					break;
					
				case 'b':
					
					System.out.println("Digite o valor do deposito");
					double valorDeposito=read.nextDouble();
					usuario.depositar(valor);
					menuDiretor(usuario);
					
					break;
					
				case 'c':
					System.out.println("Digite o valor que deseja transferir");
					double valorTransferencia=read.nextDouble();
					usuario.transferir(100.00, conta2);
					break;
					
				case 'd':
					break;
					
				case 'e':
					break;
				}
				
				
				break;
		
		
	}

	public void menuPresidente(Conta usuario, Conta conta2) {

		System.out.println("\n ");
		System.out.println("Escolha uma opção: \n");
		System.out.println("1 - Movimentações na Conta");
		System.out.println("2 - Relatórios");
		System.out.println("3 - Relátorio Gerente");
		System.out.println("4 - Relatório Diretor");
		System.out.println("5 - Relatório Presidente");
		System.out.println("6 - Sair");
		escolha = read.next().charAt(0);

		switch (escolha) {
			
			case '1':
				
				System.out.println("Movimentações na conta ");
				System.out.println("Escolha uma opção: ");
				System.out.println("a. Saque");
				System.out.println("b. Depósito");
				System.out.println("c. Transferência");
				System.out.println("d. Extrato da conta");
				escolha = read.next().charAt(0);
	switch(escolha) {
				
				case 'a':
					
					System.out.println("Digite o valor do saque");
					double valor=read.nextDouble();
					usuario.sacar(valor);
					menuPresidente(usuario);
					
					break;
					
				case 'b':
					
					System.out.println("Digite o valor do deposito");
					double valorDeposito=read.nextDouble();
					usuario.depositar(valor);
					menuPresidente(usuario);
					
					break;
					
				case 'c':
					System.out.println("Digite o valor que deseja transferir");
					double valorTransferencia=read.nextDouble();
					usuario.transferir(100.00, conta2);
					break;
					
				case 'd':
					break;
					
				case 'e':
					break;
				}
				
				
				break;

		case 6:
			System.out.println("Programa finalizado. \n");
			break;

		default:

			System.out.println("Opção inválida!");
			menuPresidente();
			// System.out.print("Digite qualquer tecla para continuar.");
			read.next();
			// break;

		}
		while (escolha != 6)
			;

	}

}
