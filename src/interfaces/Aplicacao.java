package interfaces;

import contas.Conta;

public interface Aplicacao {

	public boolean sacar (double valor);
	public boolean transferir(double valor, Conta contaDestino);
	public boolean depositar(double valor);
	public void relatorio();
	public void extrato();
	
}
	 
	 
	 
