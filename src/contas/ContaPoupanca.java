package contas;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import pessoa.Pessoa;

public class ContaPoupanca extends Conta {

	Scanner read = new Scanner(System.in);
	
	int diasInvestidos;
	double rendimento = 0;
	double valorAplicado ;
	double taxaSelic = 13.75/100;
	public double TAXA_RENDIMENTO; 
	double tr=0.32/100;
	double montante;

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	Date date = new Date();
	List<String> contaP = new ArrayList<String>();

	

	public ContaPoupanca(int numero, Pessoa titular, double saldo, TipoConta tipo, Agencias agencia) {
		super(numero, titular, saldo, tipo, agencia);
	}

	public double geraRelatorioRendimento() {

		
		System.out.println("Digite o valor que deseja aplicar: ");
		valorAplicado= read.nextDouble();

		System.out.println("Informe a quantidade de dias que o capital ficará aplicado: ");
		diasInvestidos = read.nextInt();

		if (taxaSelic>8.5/100) {                  // CASO SELIC > 8.5//
			TAXA_RENDIMENTO = ((0.5/100)+tr)/30; // TAXA EQUIVALENTE EM DIAS // 
		} 
		
		else if (taxaSelic<= 8.5/100) {                          // CASO SELIC <= 8.5//
			TAXA_RENDIMENTO = (0.7*taxaSelic)/(12*30) +(tr/30); // TAXA EQUIVALENTE EM DIAS // 
		}
		
		// CÁLCULO MONTANTE E RENDIMENTO //
		montante = valorAplicado*(Math.pow((1+TAXA_RENDIMENTO),diasInvestidos));
		rendimento = montante - valorAplicado;
		
		return rendimento;

	}

	public boolean sacar(double valor) {

		if (valor <= 0) {
			System.out.println("Valor inválido para saque.");

		} else if (valor > this.saldo) {
			System.out.println("Saldo insuficiente.");

		} else {
			this.saldo -= valor;
			System.out.println("Saque realizado com sucesso.");
			System.out.println("Data: " + sdf.format(date));
			contaP.add(sdf.format(date) + " Saque " + valor);
			return true;
		}
		return false;
	}

	public boolean depositar(double valor) {

		if (valor <= 0) {
			System.out.println("Valor inválido para depósito.");
			return false;
		} else {
			this.saldo += valor;
			System.out.println("Depósito realizado com sucesso!");
			System.out.println("Data: " + sdf.format(date));
			contaP.add(sdf.format(date) + " Depósito " + valor);
			return true;
		}

	}

	public boolean transferir(double valor, Conta destino) {

		if (valor <= 0) {
			System.out.println("Valor inválido para transferência.");

		} else if (valor > this.saldo) {
			System.out.println("Saldo insuficiente para realizar a transferência.");

		} else {
			double valorTransferencia = valor;
			this.saldo -= valorTransferencia;
			destino.depositar(valor);
			System.out.println("Transferência realizada com sucesso!");
			System.out.println("Data: " + sdf.format(date));
			contaP.add(sdf.format(date) + " Tranferencia " + valor);
			return true;
		}
		return false;
	}

	public void extrato() {

		System.out.println("Extrato atual de conta poupanca");
		System.out.println("Agência: " + "1" + "     conta: " + getNumero());
		System.out.println("Cliente: " + ((Pessoa) (titular)).getNome());
		for (String i : contaP) {
			System.out.println(i);
		}
	}

	@Override
	public void relatorio() {
		
		try {
			
	        FileWriter arq = new FileWriter(".//relatorios//relatorioContaPoupanca" + sdf.format(date) + ".txt");
	        PrintWriter gravarArq = new PrintWriter(arq);
	        
	        gravarArq.println("----------- RELATÓRIO POUPANÇA -----------\n");
	        gravarArq.printf("             Saldo: R$ %.2f%n", this.saldo);
	        gravarArq.println();
	        gravarArq.println("----------- SIMULADOR DE RENDIMENTOS POUPANÇA -----------\n");
	        gravarArq.printf("             Valor Aplicado : R$ %.2f%n", valorAplicado);
	        gravarArq.printf("             Quantidade de dias: %d%n", diasInvestidos);
	        gravarArq.printf("             Montante ao final do período : R$ %.2f%n", montante);
	        gravarArq.printf("             Rendimento: R$ %.2f%n", rendimento);
	        	        
	        arq.close();
	        System.out.println("Relatório gerado!");
	        
	    } catch (IOException e) {
	        System.out.println(" " + e.getMessage());
	    }

	}

	@Override
	public String toString() {
		return "ContaPoupanca [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

}
