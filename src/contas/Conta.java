package contas;

public abstract class Conta 

{
	    private String cpfTitular;
	    private double saldo;
	    private String agencia;

	    public Conta(String cpfTitular, String agencia) 
	    
	    {
	        this.cpfTitular = cpfTitular;
	        this.agencia = agencia;
	        this.saldo = 0;
	    }

	    public String getCpfTitular() 
	    
	    {
	        return cpfTitular;
	    }

	    public double getSaldo() 
	    
	    {
	        return saldo;
	    }
	    
	    
	    public String getAgencia() {
	        return agencia;
	    }

	    public void depositar(double valor) 
	    
	    {
	        saldo += valor;
	    }

	    public abstract void sacar(double valor);
	    
	        
	        	
}
