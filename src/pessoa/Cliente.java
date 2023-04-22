package pessoa;

import java.util.ArrayList;

import contas.Conta;

public class Cliente extends Pessoa {

	

	public Cliente(String nome, String cpf, int senha, Cargo tipo) {
		super(nome, cpf, senha, tipo);

	}

	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}

}
