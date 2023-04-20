package interfaces;

import contas.Conta;

public interface Aplicacao {

	public boolean sacar (double valor);
	public void transferir(double valor, Conta contaDestino);
	public boolean depositar(double valor);
	public void relatorio();
	
}
	 
	 
	 
