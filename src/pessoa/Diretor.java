package pessoa;

public class Diretor extends Gerente {

	public Diretor(String nome, String cpf, int senha, Cargo tipo, int numeroAgencia) {
		super(nome, cpf, senha, tipo, numeroAgencia);
	}

	public Diretor(String nome, String cpf, int senha, Cargo tipo) {
		super(nome, cpf, senha, tipo);
	}

}
