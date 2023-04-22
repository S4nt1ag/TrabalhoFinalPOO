package principal;

import java.util.Scanner;
import contas.Conta;
import contas.ContaPoupanca;
import contas.ContaCorrente;

public class Menu {
	
	public char escolha = ' ';
	String cpf;
	String senha;

	Scanner read = new Scanner(System.in);

	           // MENUS DE PESSOAS //
	
	// ------------------------------------------//
	
	// CASO 1: CLIENTE //
	public void menuCliente(Conta cliente) {

       do {

			System.out.println("\n-------Área do Cliente------");
			System.out.println("Escolha uma opção: ");
			System.out.println("1 - Movimentações na Conta.");
			System.out.println("2 - Relatórios.");
			System.out.println("3 - Sair.");
			escolha = read.next().charAt(0);

			switch (escolha) {

			case '1':
				movimentacoesCliente(cliente);				
				break;
				
			case '2':				
				relatoriosCliente(cliente);
				break;
				
			case '3':
				System.out.println("Sistema finalizado.");
				break;

			default:
				System.out.println("Opção inválida! \n");
				menuCliente(cliente);		
			}

	      } while (escolha != 3);
	}
	
	// 1: MOVIMENTAÇÕES NA CONTA CLIENTE//  
    public void movimentacoesCliente(Conta cliente) {
		
		System.out.println("\nMovimentações da conta");
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

			System.out.println("Digite o valor que deseja sacar: ");
			double valorSaque = read.nextDouble();
			cliente.sacar(valorSaque);
			menuCliente(cliente);
			break;

		case 'b':

			System.out.println("Digite o valor que deseja depositar: ");
			double valorDeposito = read.nextDouble();
			cliente.depositar(valorDeposito);
			menuCliente(cliente);

			break;

		case 'c':
			System.out.println("Digite o valor que deseja transferir");
			double valorTransferencia = read.nextDouble();
			System.out.println("Para quem deseja transferir?");
			//Conta nome = read.nextLine();
			//cliente.transferir(valorTransferencia, nome);
			break;

		case 'd':
			System.out.println("Extrato da conta");
			cliente.extrato();
			break;

		case 'e':
			menuCliente(cliente);
			break;

		case 'f':
			System.out.println("Programa finalizado.");
			break;
		
		default:
			System.out.println("Opção inválida!");
			movimentacoesCliente(cliente);
		} 
	
	}
	
	// 2: RELATÓRIOS CLIENTE //
	public void relatoriosCliente(Conta cliente) {
		
		System.out.println("\nRelatórios");
		System.out.println("Escolha uma opção: ");
		System.out.println("a. Saldo.");
		System.out.println("b. Relatório de tributação da conta corrente.");
		System.out.println("c. Relatório de Rendimento da poupança.");
		System.out.println("d. Relatório de Seguro.");
		System.out.println("e. Voltar ao menu anterior.");
		System.out.println("f. Sair.");
		escolha = read.next().charAt(0);
		
		switch (escolha) {

		case 'a':

			System.out.println("Saldo atual:");
			System.out.println(cliente.getSaldo());
			break;

		case 'b':
			System.out.println("Relatório de tributação da conta corrente");
			//cliente.relatorio();			
			break;

		case 'c':
			System.out.println("Relatório de Rendimento da poupança");
			((ContaPoupanca) cliente).geraRelatorioRendimento();
			//cliente.relatorio();	
			break;

		case 'd':
			System.out.println("Relatório de Seguro não disponível.");
			break;

		case 'e':
			menuCliente(cliente);
			break;

		case 'f':
			System.out.println("Programa finalizado.");
			break;
		
		default:		
			System.out.println("Opção inválida!");
			relatoriosCliente(cliente);
		}

						
	}
	
	// ------------------------------------------//
	
	// CASO 2: GERENTE //
	public void menuGerente(Conta gerente){

		do {

			System.out.println("\n------- Menu Gerente -------\n");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Sair");
			escolha = read.next().charAt(0);
		 
		    switch (escolha) {
			
			    case '1':
				   movimentacoesGerente(gerente);
				   break;
				
			    case '2' :
				
				    relatoriosGerente(gerente);
				    break;
				    
			    case '3' :
					
			    	System.out.println("Programafinalizado. \n");
				    break;    
				
			    default:
				    System.out.println("Opção inválida!\n");
					menuGerente(gerente);				    
	        } 
		
    	 } while (escolha != 3);
		
}		

	// 1: MOVIMENTAÇÕES NA CONTA GERENTE//		
	public void movimentacoesGerente(Conta gerente) {
		
		
		System.out.println("\nMovimentações da conta");
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

			System.out.println("Digite o valor que deseja sacar: ");
			double valorSaque = read.nextDouble();
			gerente.sacar(valorSaque);
			menuGerente(gerente);
			break;

		case 'b':

			System.out.println("Digite o valor que deseja depositar: ");
			double valorDeposito = read.nextDouble();
			gerente.depositar(valorDeposito);
			menuGerente(gerente);

			break;

		case 'c':
			System.out.println("Digite o valor que deseja transferir");
			double valorTransferencia = read.nextDouble();
			System.out.println("Para quem deseja transferir?");
			//Conta nome = read.nextLine();
			//gerente.transferir(valorTransferencia, nome);
			break;

		case 'd':
			System.out.println("Extrato da conta");
			gerente.extrato();
			break;

		case 'e':
			menuGerente(gerente);
			break;

		case 'f':
			System.out.println("Programa finalizado.");
			break;
			
		default:
			System.out.println("Opção inválida! \n");
			movimentacoesGerente(gerente);
		
		} 		
		
	}
		
	// 2:RELATÓRIOS GERENTE //		
	public void relatoriosGerente(Conta gerente) {
	
		System.out.println("\nRelatórios");
		System.out.println("Escolha uma opção: ");
		System.out.println("a. Saldo.");
		System.out.println("b. Relatório de tributação da conta corrente.");
		System.out.println("c. Relatório de Rendimento da poupança.");
		System.out.println("d. Relatório do número de Agências.");
		System.out.println("e. Voltar ao menu anterior.");
		System.out.println("f. Sair.");
		escolha = read.next().charAt(0);
		
		switch (escolha) {

		case 'a':

			System.out.println("Saldo atual:");
			System.out.println(gerente.getSaldo());
			break;

		case 'b':
			System.out.println("Relatório de tributação da conta corrente");
			//gerente.relatorio();			
			break;

		case 'c':
			System.out.println("Relatório de Rendimento da poupança");
			((ContaPoupanca) gerente).geraRelatorioRendimento();
			//gerente.relatorio();	
			break;

		case 'd':
			System.out.println("Relatório de Contas não disponível.\n");
			menuGerente(gerente);
			break;

		case 'e':
			menuGerente(gerente);
			break;

		case 'f':
			System.out.println("Programa finalizado.");
			break;
		
		default:
			System.out.println("Opção inválida! \n");
			relatoriosGerente(gerente);		
		} 
		
	}
		
	// ------------------------------------------//	
		
	// CASO 3: DIRETOR //
	public void menuDiretor(Conta diretor) {

		System.out.println("\nAcesso Diretor ");
		System.out.println("Escolha uma opção: ");
		System.out.println("1 - Movimentações na Conta");
		System.out.println("2 - Relatórios");
		System.out.println("3 - Relátorio Gerente");
		System.out.println("4 - Relatório Diretor");
		System.out.println("5 - Sair");
		escolha = read.next().charAt(0);

									
	}		
               

	// ------------------------------------------//	
		
	// CASO 4: PRESIDENTE //
	public void menuPresidente(Conta presidente) {

		System.out.println("\n Acesso Presidente Banco JK");
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
					presidente.sacar(valor);
					menuPresidente(presidente);
					
					break;
					
				case 'b':
					
					System.out.println("Digite o valor do deposito");
					double valorDeposito=read.nextDouble();
					presidente.depositar(valorDeposito);
					menuPresidente(presidente);
					
					break;
					
				case 'c':
					System.out.println("Digite o valor que deseja transferir");
					double valorTransferencia=read.nextDouble();
					presidente.transferir(100.00, presidente);
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
			menuPresidente(presidente);
			// System.out.print("Digite qualquer tecla para continuar.");
			read.next();
			// break;

		}
		while (escolha != 6)
			;

	}

	
	// ------------------------------------------//

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

				
				Conta cliente = null;
				menuCliente(cliente);
			
			
			} else if ((cpf.equals("gerente") && senha.equals("gerente"))) {

				Conta gerente = null;
				menuGerente(gerente);

			} else if ((cpf.equals("diretor") && senha.equals("diretor"))) {

				Conta diretor = null;
				menuDiretor(diretor);

			} else if ((cpf.equals("presidente") && senha.equals("presidente"))) {

				Conta presidente = null;
				menuPresidente(presidente);
			}

			else {

				System.out.println("CPF ou senha inválidos!");
				System.out.println("Tente novamente!");

				ChamaMenu();

			}

		}


}
