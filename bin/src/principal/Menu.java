package principal;

import java.util.Scanner;

public class Menu

{
	
	
	public void ChamaMenu ()
	
	{
		
	int cpf;
	int senha;
	
	System.out.println("--------------------------------------------------------------");
	System.out.println("--------------------- Sistema Bancário JK  -------------------");
	System.out.println("--------------------------------------------------------------\n");
	Scanner read = new Scanner (System.in);
	
	System.out.println("Digite seu CPF: \n");
	cpf = read.nextInt();
	
	System.out.println("Entre com sua senha: ");
	senha = read.nextInt();
	
	}	
}
