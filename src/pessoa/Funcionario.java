package pessoa;

import java.util.HashMap;

public abstract class Funcionario extends Pessoa {

	private HashMap<String, Funcionario> listaFuncionarios = new HashMap<String, Funcionario>();

	public Funcionario(String nome, String cpf, int senha, Cargo tipo) {
		super(nome, cpf, senha, tipo);
	}

	public void addNovaConta() {
	}

}