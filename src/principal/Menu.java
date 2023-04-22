package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import contas.Agencias;
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

public class Menu {
	ArrayList <Conta> listaCliente = new ArrayList<Conta>();
	List<Conta> a1 = new ArrayList<Conta>();
	List<Conta> a2 = new ArrayList<Conta>();
	List<Conta> a3 = new ArrayList<Conta>();
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
			// Conta nome = read.nextLine();
			// cliente.transferir(valorTransferencia, nome);
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
			try {
				System.out.println("Relatório de Rendimento Conta Corrente");
				((ContaCorrente) cliente).OlharRelatorio();
			} catch (ClassCastException e) {
				System.out.println("essa conta não é corrente");
				menuCliente(cliente);
			}

			break;

		case 'c':
			try {
				System.out.println("Relatório de Rendimento da poupança");
				((ContaPoupanca) cliente).geraRelatorioRendimento();
			} catch (ClassCastException e) {
				System.out.println("essa conta não é poupança");
				menuCliente(cliente);
			}
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
	public void menuGerente(Conta gerente) {

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

			case '2':

				relatoriosGerente(gerente);
				break;

			case '3':

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
			// Conta nome = read.nextLine();
			// gerente.transferir(valorTransferencia, nome);
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
			try {
				System.out.println("Relatório de Rendimento Conta Corrente");
				((ContaCorrente) gerente).OlharRelatorio();
			} catch (ClassCastException e) {
				System.out.println("essa conta não é corrente");
				menuGerente(gerente);
			}

			break;

		case 'c':
			try {
				System.out.println("Relatório de Rendimento da poupança");
				((ContaPoupanca) gerente).geraRelatorioRendimento();
			} catch (ClassCastException e) {
				System.out.println("essa conta não é poupança");
				menuGerente(gerente);
			}
			break;

		case 'd':
			if ((gerente).getNumeroAgencia() == 1) {
				
				
			}
			
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
		System.out.println("3 - Sair");
		escolha = read.next().charAt(0);

		switch (escolha) {

		case '1':
			movimentacoesDiretor(diretor);
			break;

		case '2':

			relatoriosDiretor(diretor);
			break;

		case '3':

			System.out.println("Programafinalizado. \n");
			break;

		default:
			System.out.println("Opção inválida!\n");
			menuDiretor(diretor);
		}
		while (escolha != 3)
			;

	}

	// 1: MOVIMENTAÇÕES NA CONTA Diretor//
	public void movimentacoesDiretor(Conta diretor) {

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
			diretor.sacar(valorSaque);
			menuDiretor(diretor);
			break;

		case 'b':

			System.out.println("Digite o valor que deseja depositar: ");
			double valorDeposito = read.nextDouble();
			diretor.depositar(valorDeposito);
			menuDiretor(diretor);

			break;

		case 'c':
			System.out.println("Digite o valor que deseja transferir");
			double valorTransferencia = read.nextDouble();
			System.out.println("Para quem deseja transferir?");
			// Conta nome = read.nextLine();
			// gerente.transferir(valorTransferencia, nome);
			break;

		case 'd':
			System.out.println("Extrato da conta");
			diretor.extrato();
			break;

		case 'e':
			menuDiretor(diretor);
			break;

		case 'f':
			System.out.println("Programa finalizado.");
			break;

		default:
			System.out.println("Opção inválida! \n");
			movimentacoesDiretor(diretor);

		}

	}

	public void relatoriosDiretor(Conta diretor) {

		System.out.println("\nRelatórios");
		System.out.println("Escolha uma opção: ");
		System.out.println("a. Saldo.");
		System.out.println("b. Relatório de tributação da conta corrente.");
		System.out.println("c. Relatório de Rendimento da poupança.");
		System.out.println("d. Relatório de Agências.");
		System.out.println("e. Voltar ao menu anterior.");
		System.out.println("f. Sair.");
		escolha = read.next().charAt(0);

		switch (escolha) {

		case 'a':

			System.out.println("Saldo atual:");
			System.out.println(diretor.getSaldo());
			break;

		case 'b':
			try {
				System.out.println("Relatório de Rendimento Conta Corrente");
				((ContaCorrente) diretor).OlharRelatorio();
			} catch (ClassCastException e) {
				System.out.println("essa conta não é corrente");
				menuDiretor(diretor);
			}

			break;

		case 'c':
			try {
				System.out.println("Relatório de Rendimento da poupança");
				((ContaPoupanca) diretor).geraRelatorioRendimento();
			} catch (ClassCastException e) {
				System.out.println("essa conta não é poupança");
				menuDiretor(diretor);
			}
			break;

		case 'd':
			System.out.println("Relatório de Contas não disponível.\n");
			menuDiretor(diretor);
			break;

		case 'e':
			menuDiretor(diretor);
			break;

		case 'f':
			System.out.println("Programa finalizado.");
			break;

		default:
			System.out.println("Opção inválida! \n");
			relatoriosDiretor(diretor);
		}

	}

	// ------------------------------------------//

	// CASO 4: PRESIDENTE //
	public void menuPresidente(Conta presidente) {

		System.out.println("\n Acesso Presidente Banco JK");
		System.out.println("Escolha uma opção: \n");
		System.out.println("1 - Movimentações na Conta");
		System.out.println("2 - Relatórios");
		System.out.println("3 - Sair");
		escolha = read.next().charAt(0);

		switch (escolha) {

		case '1':
			movimentacoesPresidente(presidente);
			break;

		case '2':

			break;

		case '3':
			break;

		}
	}

	// 1: MOVIMENTAÇÕES NA CONTA Presidente//
	public void movimentacoesPresidente(Conta presidente) {

		System.out.println("Movimentações na conta. ");
		System.out.println("Escolha uma opção: ");
		System.out.println("a. Saque.");
		System.out.println("b. Depósito.");
		System.out.println("c. Transferência.");
		System.out.println("d. Extrato da conta.");
		System.out.println("e. Retornar ao menu anterior.");
		System.out.println("f. Finalizar programa.");
		escolha = read.next().charAt(0);
		switch (escolha) {

		case 'a':

			System.out.println("Digite o valor do saque");
			double valor = read.nextDouble();
			presidente.sacar(valor);
			menuPresidente(presidente);

			break;

		case 'b':

			System.out.println("Digite o valor do deposito");
			double valorDeposito = read.nextDouble();
			presidente.depositar(valorDeposito);
			menuPresidente(presidente);

			break;

		case 'c':
			System.out.println("Digite o valor que deseja transferir");
			double valorTransferencia = read.nextDouble();
			presidente.transferir(100.00, presidente);
			break;

		case 'd':
			presidente.extrato();
			break;

		case 'e':
			menuPresidente(presidente);
			break;
		case 'f':
			System.out.println("Programa finalizado !");
			break;

		default:

			System.out.println("Opção inválida!");
			menuPresidente(presidente);

		}
		while (escolha != 'f')
			;

	}

	// ------------------------------------------//

	/// MENU PRINCIPAL: ///

	public void ChamaMenu()

	{
		System.out.println("------------------------------------------------------------------");
		System.out.println("--------------------- Sistema Bancário JK  -----------------------");
		System.out.println("------------------------------------------------------------------\n");

		Pessoa pessoa1 = new Diretor("Isabel", "789456123", 4640, Cargo.DIRETOR, 2);
		Conta conta1 = new ContaCorrente(22, pessoa1, 2000.00, TipoConta.CONTA_CORRENTE, Agencias.A1);
		a1.add(conta1);
		System.out.println(conta1.toString());

		Pessoa pessoa2 = new Presidente("Santiago", "123456789", 1234, Cargo.PRESIDENTE, 2);
		Conta conta2 = new ContaPoupanca(23, pessoa2, 3000.00, TipoConta.CONTA_POUPANCA, Agencias.A2);
		a2.add(conta2);
		System.out.println(conta2.toString());

		Pessoa pessoa3 = new Cliente("Isabel", "789456122", 4640, Cargo.CLIENTE);
		Conta conta3 = new ContaCorrente(25, pessoa3, 2000.00, TipoConta.CONTA_CORRENTE, Agencias.A3);
		a3.add(conta3);
		listaCliente.add(conta3);
		System.out.println(conta3.toString());

		Pessoa pessoa4 = new Gerente("Luiz", "147258369", 4640, Cargo.GERENTE, 2);
		Conta conta4 = new ContaCorrente(24, pessoa4, 1000.00, TipoConta.CONTA_CORRENTE,Agencias.A2);
		a2.add(conta4);
		System.out.println(conta4.toString());

		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite seu CPF: ");
		String cpf = scanner.nextLine();

		System.out.println("Digite sua senha: ");
		int senha = scanner.nextInt();

		if (pessoa1.getCpf().equals(cpf) && pessoa1.getSenha() == senha) {
			System.out.println("Seja Bem vindo(a): " + Cargo.DIRETOR);
			menuDiretor(conta1);
		} else if (pessoa2.getCpf().equals(cpf) && pessoa2.getSenha() == senha) {
			System.out.println("Seja Bem vindo(a): " + Cargo.PRESIDENTE);
			menuPresidente(conta2);
		} else if (pessoa3.getCpf().equals(cpf) && pessoa3.getSenha() == senha) {
			System.out.println("Seja Bem vindo(a): " + pessoa3.getNome());
			menuCliente(conta3);
		} else if (pessoa4.getCpf().equals(cpf) && pessoa4.getSenha() == senha) {
			System.out.println("Seja Bem vindo(a): " + Cargo.GERENTE);
			menuGerente(conta4);
		} else {
			System.out.println("CPF ou senha incorretos. Tente novamente.");
		}
	}

}
