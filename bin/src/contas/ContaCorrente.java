package contas;

public class ContaCorrente 

{

	public class ContaCorrente extends Conta {
	private String tipo = "corrente";

	public ContaCorrente(String cpfTitular, String agencia)
	
	{
	   super(cpfTitular, agencia);
	}

	
	public void sacar(double valor) 
	
	{
		
	double saldo = getSaldo();
	     
	if (saldo >= valor) 
	
	{
	            saldo -= valor;
	            super.depositar(saldo);
	} 
	
	else 
	
	{
	  System.out.println("Saldo insuficiente!");
	}
	    
	
	}
	}
	

}
