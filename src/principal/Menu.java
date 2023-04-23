package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import contas.Agencias;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import pessoa.Cargo;
import pessoa.Cliente;
import pessoa.Diretor;
import pessoa.Gerente;
import pessoa.Pessoa;
import pessoa.Presidente;

public class Menu /* implements Comparable<Pessoa> */ {

	/*
	 * public int compareTo(Pessoa p) { return ((Pessoa)
	 * p).getNome().compareTo(p.getNome()); }
	 */

	ArrayList<Conta> listaCliente = new ArrayList<Conta>();

	List<Conta> a1 = new ArrayList<Conta>();
	List<Conta> a2 = new ArrayList<Conta>();
	List<Conta> a3 = new ArrayList<Conta>();

	public char escolha = ' ';
	String cpf;
	String senha;
	double totalCap = 0.0;

	Scanner read = new Scanner(System.in);

	// MENUS DE PESSOAS //

	// ------------------------------------------//

	// CASO 1: CLIENTE //
	public void menuCliente(Conta cliente) {

		int escolha1 = 0;
		while (escolha1 != 3) {
			System.out.println("\n-------Área do Cliente------");
			System.out.println("Escolha uma opção: ");
			System.out.println("1 - Movimentações na Conta.");
			System.out.println("2 - Relatórios.");
			System.out.println("3 - Sair.");
			escolha1 = read.nextInt();

			switch (escolha1) {

			case 1:
				movimentacoesCliente(cliente);
				break;

			case 2:
				relatoriosCliente(cliente);
				break;

			case 3:
				System.out.println("Sistema finalizado.");
				escolha1 = 3;
				atualizacaoConta();
				break;

			default:
				System.out.println("Opção inválida! \n");
				// menuCliente(cliente);
				break;
			}
		}
	}

	// 1: MOVIMENTAÇÕES NA CONTA CLIENTE//
	public void movimentacoesCliente(Conta cliente) {
		do {
			System.out.println("\nMovimentações da conta");
			System.out.println("Escolha uma opção: ");
			System.out.println("a. Saque.");
			System.out.println("b. Depósito.");
			System.out.println("c. Transferência.");
			System.out.println("d. Extrato da conta.");
			System.out.println("e. Voltar ao menu anterior.");
			escolha = read.next().charAt(0);

			switch (escolha) {

			case 'a':

				System.out.println("Digite o valor que deseja sacar: ");
				double valorSaque = read.nextDouble();
				cliente.sacar(valorSaque);
				break;

			case 'b':

				System.out.println("Digite o valor que deseja depositar: ");
				double valorDeposito = read.nextDouble();
				cliente.depositar(valorDeposito);
				break;

			case 'c':
				System.out.println("Digite o valor que deseja transferir");
				double valorTransferencia = read.nextDouble();
				System.out.println("Para quem deseja transferir?");
				break;

			case 'd':
				System.out.println("Extrato da conta");
				cliente.extrato();
				break;

			case 'e':
				atualizacaoConta();
				break;


			default:
				System.out.println("Opção inválida!");
				movimentacoesCliente(cliente);
			}
		} while (escolha != 'e');
	}

	// 2: RELATÓRIOS CLIENTE //
	public void relatoriosCliente(Conta cliente) {
		do {
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

				} finally {
					menuCliente(cliente);
				}

				break;

			case 'c':
				try {
					System.out.println("Relatório de Rendimento da poupança");
					((ContaPoupanca) cliente).geraRelatorioRendimento();
				} catch (ClassCastException e) {
					System.out.println("essa conta não é poupança");
				} finally {
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
		} while (escolha != 'f');

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
				atualizacaoConta();
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
			atualizacaoConta();
			break;

		default:
			System.out.println("Opção inválida! \n");
			movimentacoesGerente(gerente);

		}
		while (escolha != 'f')
			;
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
			} finally {
				menuGerente(gerente);
			}

			break;

		case 'c':
			try {
				System.out.println("Relatório de Rendimento da poupança");
				((ContaPoupanca) gerente).geraRelatorioRendimento();
			} catch (ClassCastException e) {
				System.out.println("essa conta não é poupança");

			} finally {
				menuGerente(gerente);
			}
			break;

		case 'd':
			if (gerente.getAgencia() == Agencias.A1) {
				for (Conta p : a1) {
					System.out.println(p);
				}

			} else if (gerente.getAgencia() == Agencias.A2) {
				for (Conta p : a2) {
					System.out.println(p);
				}

			} else {
				for (Conta p : a3) {
					System.out.println(p);
				}
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
		while (escolha != 'f')
			;
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
			atualizacaoConta();
			break;

		default:
			System.out.println("Opção inválida!\n");
			menuDiretor(diretor);
		}
		while (escolha != 3)
			;

	}

	// 1: MOVIMENTAÇÕES NA CONTA DIRETOR//
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
			atualizacaoConta();
			break;

		default:
			System.out.println("Opção inválida! \n");
			movimentacoesDiretor(diretor);

		}
		while (escolha != 'f')
			;

	}

	// 2: RELATÓRIOS DIRETOR//
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

			} finally {
				menuDiretor(diretor);
			}

			break;

		case 'c':
			try {
				System.out.println("Relatório de Rendimento da poupança");
				((ContaPoupanca) diretor).geraRelatorioRendimento();
			} catch (ClassCastException e) {
				System.out.println("essa conta não é poupança");
			} finally {
				menuDiretor(diretor);
			}
			break;

		case 'd':

			Collections.sort(listaCliente, new Comparator<Conta>() {

				@Override
				public int compare(Conta o1, Conta o2) {
					String nome1 = o1.getTitular().getNome();
					String nome2 = o2.getTitular().getNome();
					return nome1.compareTo(nome2);
				}

			});

			for (Conta p : listaCliente) {

				System.out.println(p);
			}

			menuDiretor(diretor);
			break;

		case 'e':
			menuDiretor(diretor);
			break;

		case 'f':
			System.out.println("Programa finalizado.");
			atualizacaoConta();
			break;

		default:
			System.out.println("Opção inválida! \n");
			relatoriosDiretor(diretor);
		}
		while (escolha != 'f')
			;
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
			relatoriosPresidente(presidente);
			break;

		case '3':
			System.out.println("Sistema encerrado");
			atualizacaoConta();
			break;

		}
		while (escolha != '3')
			;
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
			System.out.println("Escolha o destinatario: ");
			String destinatario = read.next();
			for (int i = 0; i < listaCliente.size(); i++) {
				String cpfList = listaCliente.get(i).getTitular().getCpf();
				if (destinatario.equals(cpfList)) {
					Conta destinatario2 = listaCliente.get(i);
					presidente.transferir(valorTransferencia, destinatario2);
					menuPresidente(presidente);
					break;
					
				}
			}

		case 'd':
			presidente.extrato();
			menuPresidente(presidente);
			break;

		case 'e':
			menuPresidente(presidente);
			break;
		case 'f':
			System.out.println("Programa finalizado !");
			atualizacaoConta();
			break;

		default:

			System.out.println("Opção inválida!");
			menuPresidente(presidente);

		}
		while (escolha != 'f')
			;

	}

	// 2: MOVIMENTAÇÕES NA CONTA PRESIDENTE//
	public void relatoriosPresidente(Conta presidente) {

		System.out.println("\nRelatórios");
		System.out.println("Escolha uma opção: ");
		System.out.println("a. Saldo.");
		System.out.println("b. Relatório de tributação da conta corrente.");
		System.out.println("c. Relatório de Rendimento da poupança.");
		System.out.println("d. Relatório capital total Banco JK.");
		System.out.println("e. Relatório Clientes.");
		System.out.println("f. Voltar ao menu anterior.");
		System.out.println("g. Sair.");
		escolha = read.next().charAt(0);

		switch (escolha) {

		case 'a':

			System.out.println("Saldo atual:");
			System.out.println(presidente.getSaldo());
			menuPresidente(presidente);
			break;

		case 'b':
			try {
				System.out.println("Relatório de Rendimento Conta Corrente");
				((ContaCorrente) presidente).OlharRelatorio();
			} catch (ClassCastException e) {
				System.out.println("essa conta não é corrente");
				menuPresidente(presidente);
			}

			break;

		case 'c':
			try {
				System.out.println("Relatório de Rendimento da poupança");
				((ContaPoupanca) presidente).geraRelatorioRendimento();
			} catch (ClassCastException e) {
				System.out.println("essa conta não é poupança");

			} finally {
				menuPresidente(presidente);
			}
			break;

		case 'd':
			System.out.printf("O valor total de capital do banco JK é: %.2f%n", totalCap);
			menuPresidente(presidente);
			break;

		case 'e':
			for (Conta p : listaCliente) {

				System.out.println(p);
			}
			menuPresidente(presidente);
			break;
		case 'f':
			menuPresidente(presidente);
			break;

		case 'g':
			System.out.println("Programa finalizado.");
			atualizacaoConta();
			break;

		default:
			System.out.println("Opção inválida! \n");
			relatoriosPresidente(presidente);
		}
		while (escolha != 'g')
			;
	}

	// ------------------------------------------//

	/// MENU PRINCIPAL: ///

	public void ChamaMenu()

	{
		System.out.println("------------------------------------------------------------------");
		System.out.println("--------------------- Sistema Bancário JK  -----------------------");
		System.out.println("------------------------------------------------------------------\n");

		String path = "C:\\TrabalhoFinalPOO\\pessoas\\Pessoas.txt\\";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			line = br.readLine();
			while (line != null) {
				String[] vect = line.split(",");
				String nome = vect[0];
				String cpf = vect[1];
				Integer senha = Integer.parseInt(vect[2]);
				Integer numero = Integer.parseInt(vect[3]);
				Double saldo = Double.parseDouble(vect[4]);
				String cargo = vect[5];
				String tipoConta = vect[6];
				String agencia = vect[7];
				Agencias agenciaEnum;
				Pessoa pessoa = null;
				Conta conta = null;

				if (agencia.equals("A1")) {
					agenciaEnum = Agencias.A1;
				} else if (agencia.equals("A2")) {
					agenciaEnum = Agencias.A2;
				} else {
					agenciaEnum = Agencias.A3;
				}
				switch (cargo) {
				case "CLIENTE":
					pessoa = new Cliente(nome, cpf, senha);
					break;

				case "GERENTE":
					pessoa = new Gerente(nome, cpf, senha);
					break;

				case "DIRETOR":
					pessoa = new Diretor(nome, cpf, senha);
					break;

				case "PRESIDENTE":
					pessoa = new Presidente(nome, cpf, senha);
					break;

				default:
					break;
				}
				switch (tipoConta) {
				case "CONTA_CORRENTE":
					conta = new ContaCorrente(numero, pessoa, saldo, agenciaEnum);
					break;
				case "CONTA_POUPANCA":
					conta = new ContaPoupanca(numero, pessoa, saldo, agenciaEnum);
					break;
				default:
					break;
				}
				listaCliente.add(conta);
				switch (agenciaEnum) {
				case A1:
					a1.add(conta);
					break;
				case A2:
					a2.add(conta);
					break;
				case A3:
					a3.add(conta);
					break;

				default:
					break;
				}

				line = br.readLine();
			}
			Scanner scanner = new Scanner(System.in);
			System.out.println("Digite seu CPF: ");
			String input_cpf = scanner.nextLine();

			System.out.println("Digite sua senha: ");
			int input_senha = scanner.nextInt();
			for (Conta p : listaCliente) {
				System.out.println(p);
			}
			for (int i = 0; i < listaCliente.size(); i++) {
				String cpfLista = listaCliente.get(i).getTitular().getCpf();
				int senhaLista = listaCliente.get(i).getTitular().getSenha();
				Cargo cargoLista = listaCliente.get(i).getTitular().getTipo();

				if (cpfLista.equals(input_cpf) && senhaLista == input_senha) {
					System.out.println("Seja Bem vindo(a): " + cargoLista);
					switch (cargoLista) {
					case CLIENTE:
						menuCliente(listaCliente.get(i));
						break;
					case GERENTE:
						menuGerente(listaCliente.get(i));
						break;
					case DIRETOR:
						menuDiretor(listaCliente.get(i));
					case PRESIDENTE:
						menuPresidente(listaCliente.get(i));
					}

					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Error: linha invalida" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void atualizacaoConta() {

		String path = "C:\\TrabalhoFinalPOO\\pessoas\\Pessoas.txt\\";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.newLine();
			for (int i = 0; i < listaCliente.size(); i++) {
				String nomeLista = listaCliente.get(i).getTitular().getNome();
				String cpfLista = listaCliente.get(i).getTitular().getCpf();
				int senhaLista = listaCliente.get(i).getTitular().getSenha();
				int numeroLista = listaCliente.get(i).getNumero();
				double saldoLista = listaCliente.get(i).getSaldo();
				Cargo cargoLista = listaCliente.get(i).getTitular().getTipo();
				String contaLista = listaCliente.get(i).getTipo().name();
				String agenciaLista = listaCliente.get(i).getAgencia().name();

				bw.write(nomeLista + "," + cpfLista + "," + senhaLista + "," + numeroLista + "," + saldoLista + ","
						+ cargoLista + "," + contaLista + "," + agenciaLista);
				bw.newLine();
			}

		} catch (IOException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

}
