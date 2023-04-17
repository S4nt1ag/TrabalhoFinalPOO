package principal;

import java.util.Scanner;

public class Menu

{

	
	
	public	int escolha;
	public void ChamaMenu()

	{

		int cpf;
		int senha;

		System.out.println("--------------------------------------------------------------");
		System.out.println("--------------------- Sistema Bancário JK  -------------------");
		System.out.println("--------------------------------------------------------------\n");
		Scanner read = new Scanner(System.in);

		System.out.println("Digite seu CPF: \n");
		cpf = read.nextInt();

		System.out.println("Entre com sua senha: ");
		senha = read.nextInt();

	

	/*
	 * public void menuPrincipal(){
	 * 
	 * if(cpf == Cliente) {
	 * 
	 * menuCliente();
	 * 
	 * 
	 * }else if(cpf == Gerente ) {
	 * 
	 * menuGerente(); }
	 * 
	 * }else if(cpf==Diretor)
	 * 
	 * {
	 * 
	 * menuDiretor();
	 * 
	 * }else if(cpf==Presidente) {
	 * 
	 * menuPresidente(); }
	 * 
	 * else {
	 * 
	 * System.out.println(" Cpf ou senha não identificados ");
	 * System.out.println("Tente novamente ! "); ChamaMenu();
	 * 
	 * } }
	 * 
	 * 
	 * 
	 * 
	 * menuCliente();{
	 * 
	 * 
	 * 
	 * 
	 int escolha;
	 */

do {
	
	System.out.println("Escolha uma opção: ");
	System.out.println("1 - Movimentações na Conta");
	System.out.println("2 - Relatórios");
	System.out.println("3 - Sair");
	escolha = read.nextInt();

switch (escolha) {
    case 1:
        
    	//movimentacao();
    break;
    case 2:
        //relatorio();
        break;
    // outros casos
    
    case 3:
    	break;
    
    default:
        System.out.println("Digite um número que seja válido ");
        System.out.print("Digite qualquer coisa para continuar");
        read.next();
        break;

}
        
}while(escolha!=3);


//movimentacao(){
/*
 * int escolha
 * 
 * switch (escolha) { case 1:
 * 
 * saque();
 * 
 * case 2: deposito();
 * 
 * 
 * case 3: transfere();
 * 
 * case 4: geraExtrato();
 * 
 * break }
 */
	
	//relatorio(){
		
	/*
	 * int escolha
	 * 
	 * switch (escolha) {
	 * 
	 * caso 1 :
	 * 
	 * geraSaldo();
	 * 
	 * caso 2:
	 * 
	 * geraRelatorioTributacao();
	 * 
	 * caso 3:
	 * 
	 * geraRelatorioRendimento();
	 * 
	 * caso 4:
	 * 
	 * desafio();
	 * 
	 * }
	 */
	
	
	}
}
		
		
	