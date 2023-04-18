package contas;

public class ContaPoupanca extends Conta {

	private double saldo;
	public final double TAXA_RENDIMENTO = 0.1;
	
	public void sacar(double valor) {

		if (valor <= 0) {
			System.out.println("Valor inválido para saque.");

		} else if (valor > this.saldo) {
			System.out.println("Saldo insuficiente.");

		} else {
			this.saldo -= valor;
			System.out.println("Saque realizado com sucesso!");
		}
	}

	public void depositar(double valor) {

		this.saldo += valor;
		System.out.println("Depósito realizado com sucesso!");

	}

	public double geraRelatorioRendimento() {
		
		
		int diasInvestidos;
		double rendimento = 0;
		double valorAplicado;
		
		
		System.out.println("Qual capital será investido");
		valorAplicado = read.next();
		
		System.out.println("Informe a quantidade de dias que o capital ficará aplicado: ");
		diasInvestidos = read.next();
		
		
		
		
		rendimento = (valorAplicado * 0.022) + diasInvestidos;
				return rendimento;
				
			}
			
		}
		
	
	
