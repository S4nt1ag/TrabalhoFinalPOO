package interfaces;

import contas.Conta;

public interface Aplicacao {

	public boolean sacar ();
	public void transferir(double valor, Conta contaDestino);
	public boolean depositar();
	public void relatorio();
	
}
	 
	 
	 
