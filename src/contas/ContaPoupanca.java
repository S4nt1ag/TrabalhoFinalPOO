package contas;

public class ContaPoupanca 
{
	
	
	private String tipo = "poupança";

    public ContaPoupanca(String cpfTitular, String agencia) 
    
    {
        super(cpfTitular, agencia);
    }

   
    public void sacar(double valor) 
    {
        double saldo = getSaldo();
        if (saldo >= valor) {
            saldo -= valor;
            super.depositar(saldo);
    } 
        
        else 
    
    {
            System.out.println("Saldo insuficiente");
        
    }
    
    }

}
