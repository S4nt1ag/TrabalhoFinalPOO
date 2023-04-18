package contas;

import pessoa.Cliente;

public class Conta extends Cliente {

	public Conta(String nome, String cpf, Integer senha, String email, Integer telefone, String endereco) {
		super(nome, cpf, senha, email, telefone, endereco);
	}

}
