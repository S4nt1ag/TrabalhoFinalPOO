package principal;

import pessoa.Diretor;
import pessoa.Gerente;
import pessoa.Presidente;

public class SistemaBancario

{

	public static void main(String[] args)

	{

		// Menu mn = new Menu();

		// mn.ChamaMenu();

		Presidente presidente = new Presidente("Gabriel", "11154378900", 234555);

		Gerente gerente = new Gerente("Santiago", "11154378901", 234533);

		Diretor diretor = new Diretor("Neves", "11154378902", 234534);

		
		System.out.println(presidente.toString());
		System.out.println(gerente.toString());
		System.out.println(diretor.toString());
		
	}

}
