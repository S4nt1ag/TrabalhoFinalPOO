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
import java.util.concurrent.TimeUnit;

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
import utilities.Clear;

public class Menu {

	ArrayList<Conta> listaCliente = new ArrayList<Conta>();

	Clear c = new Clear();
	List<Conta> a1 = new ArrayList<Conta>();
	List<Conta> a2 = new ArrayList<Conta>();
	List<Conta> a3 = new ArrayList<Conta>();

	public char escolha = ' ';
	String cpf;
	String senha;
	double totalCap = 0.0;

	Scanner read = new Scanner(System.in);

	// MENUS DE PESSOAS //

	// CASO 1: CLIENTE //
	public void menuCliente(Conta cliente) {

		while (escolha != '3') {
			c.cls();
			System.out.println(" ______                            _______ _       \r\n"
					+ "(____  \\                          (_______) |      \r\n"
					+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
					+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
					+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
					+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
					+ "                                                   ");
			System.out.println();
			System.out.println("\nSeja Bem vindo(a): " + cliente.getTitular().getNome());
			System.out.println("Escolha uma opção: ");
			System.out.println("1 - Movimentações na Conta.");
			System.out.println("2 - Relatórios.");
			System.out.println("3 - Sair.");
			c.clUp();
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
				try {
					((ContaCorrente) cliente).relatorio();
				} catch (ClassCastException e) {

				}
				try {
					((ContaPoupanca) cliente).relatorio();
				} catch (ClassCastException e) {

				}
				atualizacaoConta();
				escolha = '3';
				break;

			default:
				System.out.println("Opção inválida! \n");
				break;
			}
		}
	}

	// 1: MOVIMENTAÇÕES NA CONTA CLIENTE//
	public void movimentacoesCliente(Conta cliente) {

		do {
			c.cls();
			System.out.println(" ______                            _______ _       \r\n"
					+ "(____  \\                          (_______) |      \r\n"
					+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
					+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
					+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
					+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
					+ "                                                   ");
			System.out.println();
			System.out.println("\nMovimentações da conta");
			System.out.println("Escolha uma opção: ");
			System.out.println("a. Saque.");
			System.out.println("b. Depósito.");
			System.out.println("c. Transferência.");
			System.out.println("d. Extrato da conta.");
			System.out.println("e. Voltar ao menu anterior.");
			c.clUp();
			escolha = read.next().charAt(0);

			switch (escolha) {

			case 'a':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Digite o valor que deseja sacar: ");
				double valorSaque = read.nextDouble();
				cliente.sacar(valorSaque);
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'b':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Digite o valor que deseja depositar: ");
				double valorDeposito = read.nextDouble();
				cliente.depositar(valorDeposito);
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'c':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Digite o valor que deseja transferir");
				double valorTransferencia = read.nextDouble();
				System.out.println("Escolha o destinatário: ");
				String destinatario = read.next();
				for (int i = 0; i < listaCliente.size(); i++) {
					String cpfList = listaCliente.get(i).getTitular().getCpf();
					if (destinatario.equals(cpfList)) {
						Conta destinatario2 = listaCliente.get(i);
						cliente.transferir(valorTransferencia, destinatario2);
						
						
						try {
							((ContaCorrente) destinatario2).relatorio();
						} catch (ClassCastException e) {

						}
						try {
							((ContaPoupanca) destinatario2).relatorio();
						} catch (ClassCastException e) {
						}
						break;

					} else {
						System.out.println("Titular não encontrado!");
						movimentacoesCliente(cliente);
						break;
					}
					
				}
			
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'd':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Extrato da conta");
				cliente.extrato();
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'e':
				atualizacaoConta();
				break;

			default:
				System.out.println("Opção inválida!");
			}
		} while (escolha != 'e');
	}

	// 2: RELATÓRIOS CLIENTE //
	public void relatoriosCliente(Conta cliente) {
		do {
			c.cls();
			System.out.println(" ______                            _______ _       \r\n"
					+ "(____  \\                          (_______) |      \r\n"
					+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
					+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
					+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
					+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
					+ "                                                   ");
			System.out.println();
			System.out.println("\nRelatórios");
			System.out.println("Escolha uma opção: ");
			System.out.println("a. Saldo.");
			System.out.println("b. Relatório de tributação da conta corrente.");
			System.out.println("c. Relatório de Rendimento da poupança.");
			System.out.println("d. Relatório de Seguro.");
			System.out.println("e. Voltar ao menu anterior.");
			c.clUp();
			escolha = read.next().charAt(0);

			switch (escolha) {

			case 'a':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Saldo atual:");
				System.out.println(cliente.getSaldo());
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'b':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				try {
					System.out.println("Relatório de Rendimento Conta Corrente");
					((ContaCorrente) cliente).OlharRelatorio();
					c.clUp();
					System.out.println("digite 's' para continuar");
					read.next();
				} catch (ClassCastException e) {
					System.out.println("essa conta não é corrente");
					c.clUp();
					System.out.println("digite 's' para continuar");
					read.next();

				}

				break;

			case 'c':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				try {
					System.out.println("Relatório de Rendimento da poupança");
					((ContaPoupanca) cliente).geraRelatorioRendimento();
					c.clUp();
					System.out.println("digite 's' para continuar");
					read.next();
				} catch (ClassCastException e) {
					System.out.println("essa conta não é poupança");
					c.clUp();
					System.out.println("digite 's' para continuar");
					read.next();
				}
				break;

			case 'd':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Relatório de Seguro não disponível.");
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'e':
				System.out.println("Programa finalizado.");
				atualizacaoConta();
				break;

			default:
				System.out.println("Opção inválida!");
				relatoriosCliente(cliente);
			}
		} while (escolha != 'e');

	}

	// ------------------------------------------//

	// CASO 2: GERENTE //
	public void menuGerente(Conta gerente) {

		do {
			c.cls();
			System.out.println(" ______                            _______ _       \r\n"
					+ "(____  \\                          (_______) |      \r\n"
					+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
					+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
					+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
					+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
					+ "                                                   ");
			System.out.println("\nSeja Bem vindo(a): Gerente");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Sair");
			c.clUp();
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
				
				try {
					((ContaCorrente) gerente).relatorio();
				} catch (ClassCastException e) {

				}
				try {
					((ContaPoupanca) gerente).relatorio();
				} catch (ClassCastException e) {

				}
				atualizacaoConta();
				escolha = '3';
				break;

			default:
				System.out.println("Opção inválida!\n");
			}

		} while (escolha != '3');

	}

	// 1: MOVIMENTAÇÕES NA CONTA GERENTE//
	public void movimentacoesGerente(Conta gerente) {

		do {
			c.cls();
			System.out.println(" ______                            _______ _       \r\n"
					+ "(____  \\                          (_______) |      \r\n"
					+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
					+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
					+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
					+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
					+ "                                                   ");
			System.out.println("\nMovimentações da conta");
			System.out.println("Escolha uma opção: ");
			System.out.println("a. Saque.");
			System.out.println("b. Depósito.");
			System.out.println("c. Transferência.");
			System.out.println("d. Extrato da conta.");
			System.out.println("e. Voltar ao menu anterior.");
			c.clUp();
			escolha = read.next().charAt(0);

			switch (escolha) {

			case 'a':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Digite o valor que deseja sacar: ");
				double valorSaque = read.nextDouble();
				gerente.sacar(valorSaque);
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'b':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Digite o valor que deseja depositar: ");
				double valorDeposito = read.nextDouble();
				gerente.depositar(valorDeposito);
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'c':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Digite o valor que deseja transferir");
				double valorTransferencia = read.nextDouble();
				System.out.println("Escolha o destinatario: ");
				String destinatario = read.next();
				for (int i = 0; i < listaCliente.size(); i++) {
					String cpfList = listaCliente.get(i).getTitular().getCpf();
					if (destinatario.equals(cpfList)) {
						Conta destinatario2 = listaCliente.get(i);
						gerente.transferir(valorTransferencia, destinatario2);
						try {
							((ContaCorrente) destinatario2).relatorio();
						} catch (ClassCastException e) {

						}
						try {
							((ContaPoupanca) destinatario2).relatorio();
						} catch (ClassCastException e) {
						}
						break;
						
					}
				}
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'd':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Extrato da conta");
				gerente.extrato();
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'e':
				atualizacaoConta();
				break;

			default:
				System.out.println("Opção inválida! \n");

			}
		} while (escolha != 'e');
	}

	// 2:RELATÓRIOS GERENTE //
	public void relatoriosGerente(Conta gerente) {

		do {
			c.cls();
			System.out.println(" ______                            _______ _       \r\n"
					+ "(____  \\                          (_______) |      \r\n"
					+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
					+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
					+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
					+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
					+ "                                                   ");
			System.out.println();
			System.out.println("\nRelatórios");
			System.out.println("Escolha uma opção: ");
			System.out.println("a. Saldo.");
			System.out.println("b. Relatório de tributação da conta corrente.");
			System.out.println("c. Relatório de Rendimento da poupança.");
			System.out.println("d. Relatório do número de Agências.");
			System.out.println("e. Voltar ao menu anterior.");
			c.clUp();
			escolha = read.next().charAt(0);

			switch (escolha) {

			case 'a':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Saldo atual:");
				System.out.println(gerente.getSaldo());
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'b':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				try {
					System.out.println("Relatório de Rendimento Conta Corrente");
					((ContaCorrente) gerente).OlharRelatorio();
				} catch (ClassCastException e) {
					System.out.println("essa conta não é corrente");
				}
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'c':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				try {
					System.out.println("Relatório de Rendimento da poupança");
					((ContaPoupanca) gerente).geraRelatorioRendimento();
				} catch (ClassCastException e) {
					System.out.println("essa conta não é poupança");
				}
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'd':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
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
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();

				break;

			case 'e':
				atualizacaoConta();
				break;

			default:
				System.out.println("Opção inválida! \n");
			}
		} while (escolha != 'e');
	}

	// ------------------------------------------//

	// CASO 3: DIRETOR //
	public void menuDiretor(Conta diretor) {

		do {
			c.cls();
			System.out.println(" ______                            _______ _       \r\n"
					+ "(____  \\                          (_______) |      \r\n"
					+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
					+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
					+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
					+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
					+ "                                                   ");
			System.out.println();
			System.out.println("\nSeja Bem vindo(a): Diretor (a)");
			System.out.println("Escolha uma opção: ");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Sair");
			c.clUp();
			escolha = read.next().charAt(0);

			switch (escolha) {

			case '1':
				movimentacoesDiretor(diretor);
				break;

			case '2':

				relatoriosDiretor(diretor);
				break;

			case '3':
				System.out.println("Programa finalizado. \n");
				
				try {
					((ContaCorrente) diretor).relatorio();
				} catch (ClassCastException e) {

				}
				try {
					((ContaPoupanca) diretor).relatorio();
				} catch (ClassCastException e) {

				}
				atualizacaoConta();
				escolha = '3';
				break;

			default:
				System.out.println("Opção inválida!\n");
			}
		} while (escolha != '3');

	}

	// 1: MOVIMENTAÇÕES NA CONTA DIRETOR//
	public void movimentacoesDiretor(Conta diretor) {

		do {
			c.cls();
			System.out.println(" ______                            _______ _       \r\n"
					+ "(____  \\                          (_______) |      \r\n"
					+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
					+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
					+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
					+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
					+ "                                                   ");
			System.out.println();
			System.out.println("\nMovimentações da conta");
			System.out.println("Escolha uma opção: ");
			System.out.println("a. Saque.");
			System.out.println("b. Depósito.");
			System.out.println("c. Transferência.");
			System.out.println("d. Extrato da conta.");
			System.out.println("e. Voltar ao menu anterior.");
			c.clUp();
			escolha = read.next().charAt(0);

			switch (escolha) {

			case 'a':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Digite o valor que deseja sacar: ");
				double valorSaque = read.nextDouble();
				diretor.sacar(valorSaque);
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'b':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Digite o valor que deseja depositar: ");
				double valorDeposito = read.nextDouble();
				diretor.depositar(valorDeposito);
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'c':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Digite o valor que deseja transferir");
				double valorTransferencia = read.nextDouble();
				System.out.println("Escolha o destinatario: ");
				String destinatario = read.next();
				for (int i = 0; i < listaCliente.size(); i++) {
					String cpfList = listaCliente.get(i).getTitular().getCpf();
					if (destinatario.equals(cpfList)) {
						Conta destinatario2 = listaCliente.get(i);
						diretor.transferir(valorTransferencia, destinatario2);
						try {
							((ContaCorrente) destinatario2).relatorio();
						} catch (ClassCastException e) {

						}
						try {
							((ContaPoupanca) destinatario2).relatorio();
						} catch (ClassCastException e) {
						}
						break;

					}
				}
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'd':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Extrato da conta");
				diretor.extrato();
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'e':
				atualizacaoConta();
				break;

			default:
				System.out.println("Opção inválida! \n");

			}
		} while (escolha != 'e');

	}

	// 2: RELATÓRIOS DIRETOR//
	public void relatoriosDiretor(Conta diretor) {

		do {
			c.cls();
			System.out.println(" ______                            _______ _       \r\n"
					+ "(____  \\                          (_______) |      \r\n"
					+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
					+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
					+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
					+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
					+ "                                                   ");
			System.out.println();
			System.out.println("\nRelatórios");
			System.out.println("Escolha uma opção: ");
			System.out.println("a. Saldo.");
			System.out.println("b. Relatório de tributação da conta corrente.");
			System.out.println("c. Relatório de Rendimento da poupança.");
			System.out.println("d. Relatório de Agências.");
			System.out.println("e. Voltar ao menu anterior.");
			c.clUp();
			escolha = read.next().charAt(0);

			switch (escolha) {

			case 'a':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Saldo atual:");
				System.out.println(diretor.getSaldo());
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'b':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				try {
					System.out.println("Relatório de Rendimento Conta Corrente");
					((ContaCorrente) diretor).OlharRelatorio();
					c.clUp();
					System.out.println("digite 's' para continuar");
					read.next();
				} catch (ClassCastException e) {
					System.out.println("essa conta não é corrente");
					c.clUp();
					System.out.println("digite 's' para continuar");
					read.next();
				}

				break;

			case 'c':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				try {
					System.out.println("Relatório de Rendimento da poupança");
					((ContaPoupanca) diretor).geraRelatorioRendimento();
					c.clUp();
					System.out.println("digite 's' para continuar");
					read.next();
				} catch (ClassCastException e) {
					System.out.println("essa conta não é poupança");
					c.clUp();
					System.out.println("digite 's' para continuar");
					read.next();
				}
				break;

			case 'd':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
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
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'e':
				atualizacaoConta();
				break;

			default:
				System.out.println("Opção inválida! \n");
			}
		} while (escolha != 'e');
	}

	// ------------------------------------------//

	// CASO 4: PRESIDENTE //
	public void menuPresidente(Conta presidente) {

		do {
			c.cls();
			System.out.println(" ______                            _______ _       \r\n"
					+ "(____  \\                          (_______) |      \r\n"
					+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
					+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
					+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
					+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
					+ "                                                   ");
			System.out.println("\nSeja Bem vindo(a): Presidente");
			System.out.println("Escolha uma opção: \n");
			System.out.println("1 - Movimentações na Conta");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Sair");
			c.clUp();
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
				
				try {
					((ContaCorrente) presidente).relatorio();
				} catch (ClassCastException e) {

				}
				try {
					((ContaPoupanca) presidente).relatorio();
				} catch (ClassCastException e) {

				}
				atualizacaoConta();
				escolha = '3';
				break;

			}
		} while (escolha != '3');
	}

	// 1: MOVIMENTAÇÕES NA CONTA PRESIDENTE//
	public void movimentacoesPresidente(Conta presidente) {

		do {
			c.cls();
			System.out.println(" ______                            _______ _       \r\n"
					+ "(____  \\                          (_______) |      \r\n"
					+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
					+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
					+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
					+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
					+ "                                                   ");
			System.out.println("Movimentações na conta. ");
			System.out.println("Escolha uma opção: ");
			System.out.println("a. Saque.");
			System.out.println("b. Depósito.");
			System.out.println("c. Transferência.");
			System.out.println("d. Extrato da conta.");
			System.out.println("e. Retornar ao menu anterior.");
			c.clUp();
			escolha = read.next().charAt(0);
			switch (escolha) {

			case 'a':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Digite o valor do saque");
				double valor = read.nextDouble();
				presidente.sacar(valor);
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();

				break;

			case 'b':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Digite o valor do deposito");
				double valorDeposito = read.nextDouble();
				presidente.depositar(valorDeposito);
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'c':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Digite o valor que deseja transferir");
				double valorTransferencia = read.nextDouble();
				System.out.println("Escolha o destinatario: ");
				String destinatario = read.next();
				for (int i = 0; i < listaCliente.size(); i++) {
					String cpfList = listaCliente.get(i).getTitular().getCpf();
					if (destinatario.equals(cpfList)) {
						Conta destinatario2 = listaCliente.get(i);
						presidente.transferir(valorTransferencia, destinatario2);
						try {
							((ContaCorrente) destinatario2).relatorio();
						} catch (ClassCastException e) {

						}
						try {
							((ContaPoupanca) destinatario2).relatorio();
						} catch (ClassCastException e) {
						}
						break;

					}
				}
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'd':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				presidente.extrato();
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'e':
				atualizacaoConta();
				break;

			default:

				System.out.println("Opção inválida!");

			}
		} while (escolha != 'e');

	}

	// 2: MOVIMENTAÇÕES NA CONTA PRESIDENTE//
	public void relatoriosPresidente(Conta presidente) {

		do {
			c.cls();
			System.out.println(" ______                            _______ _       \r\n"
					+ "(____  \\                          (_______) |      \r\n"
					+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
					+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
					+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
					+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
					+ "                                                   ");
			System.out.println("\nRelatórios");
			System.out.println("Escolha uma opção: ");
			System.out.println("a. Saldo.");
			System.out.println("b. Relatório de tributação da conta corrente.");
			System.out.println("c. Relatório de Rendimento da poupança.");
			System.out.println("d. Relatório capital total Banco JK.");
			System.out.println("e. Relatório Clientes.");
			System.out.println("f. Voltar ao menu anterior.");
			c.clUp();
			escolha = read.next().charAt(0);

			switch (escolha) {

			case 'a':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.println("Saldo atual:");
				System.out.println(presidente.getSaldo());
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'b':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				try {
					System.out.println();
					System.out.println("Relatório de Rendimento Conta Corrente");
					((ContaCorrente) presidente).OlharRelatorio();
					c.clUp();
					System.out.println("digite 's' para continuar");
					read.next();
				} catch (ClassCastException e) {
					System.out.println("essa conta não é corrente");
					c.clUp();
					System.out.println("digite 's' para continuar");
					read.next();
				}

				break;

			case 'c':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				try {
					System.out.println();
					System.out.println("Relatório de Rendimento da poupança");
					((ContaPoupanca) presidente).geraRelatorioRendimento();
					c.clUp();
					System.out.println("digite 's' para continuar");
					read.next();
				} catch (ClassCastException e) {
					System.out.println("essa conta não é poupança");
					c.clUp();
					System.out.println("digite 's' para continuar");
					read.next();
				}
				break;

			case 'd':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				System.out.println();
				System.out.printf("O valor total de capital do banco JK é: %.2f%n", totalCap);
				c.clUp();
				System.out.println("digite 's' para continuar");
				read.next();
				break;

			case 'e':
				c.cls();
				System.out.println(" ______                            _______ _       \r\n"
						+ "(____  \\                          (_______) |      \r\n"
						+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
						+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
						+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
						+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
						+ "                                                   ");
				for (Conta p : listaCliente) {

					System.out.println(p);
				}
				System.out.println("digite 's' para continuar");
				read.next();
				break;
			case 'f':
				atualizacaoConta();
				break;

			default:
				System.out.println("Opção inválida! \n");
			}
		} while (escolha != 'f');
	}

	// ------------------------------------------//

	/// MENU PRINCIPAL: ///

	public void ChamaMenu()

	{
		System.out.println(" ______                            _______ _       \r\n"
				+ "(____  \\                          (_______) |      \r\n"
				+ " ____)  )_____ ____   ____ ___         _  | |  _   \r\n"
				+ "|  __  ((____ |  _ \\ / ___) _ \\    _  | | | |_/ )  \r\n"
				+ "| |__)  ) ___ | | | ( (__| |_| |  | |_| | |  _ (   \r\n"
				+ "|______/\\_____|_| |_|\\____)___/    \\___/  |_| \\_)  \r\n"
				+ "                                                   ");

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
				totalCap += conta.getSaldo();
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
			int encontrei = 1;
			do {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Digite seu CPF: ");
				String input_cpf = scanner.next();

				System.out.println("Digite sua senha: ");
				int input_senha = scanner.nextInt();

				for (int i = 0; i < listaCliente.size(); i++) {
					String cpfLista = listaCliente.get(i).getTitular().getCpf();
					int senhaLista = listaCliente.get(i).getTitular().getSenha();
					Cargo cargoLista = listaCliente.get(i).getTitular().getTipo();

					if (cpfLista.equals(input_cpf) && senhaLista == input_senha) {

						switch (cargoLista) {
						case CLIENTE:
							menuCliente(listaCliente.get(i));
							encontrei += 1;
							break;
						case GERENTE:
							menuGerente(listaCliente.get(i));
							encontrei += 1;
							break;
						case DIRETOR:
							menuDiretor(listaCliente.get(i));
							encontrei += 1;
							break;
						case PRESIDENTE:
							menuPresidente(listaCliente.get(i));
							encontrei += 1;
							break;
						}
						break;
					}
				}
				encontrei -= 1;
				System.out.println("Senha ou Cpf incorretos");
			} while (encontrei != 1);

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
