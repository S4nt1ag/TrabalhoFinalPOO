package pessoa;

public abstract class Funcionario extends Pessoa {


	public Funcionario(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
		this.tipo = null;

	}


	@Override
	public String toString() {
		return ", nome: " + nome + ", cpf: " + cpf  + ", tipo: " + tipo;
	}

}