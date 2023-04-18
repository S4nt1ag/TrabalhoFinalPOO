package pessoa;

public class Diretor extends Gerente {

	public Diretor(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
	}

	@Override
	public String toString() {
		return "Diretor [getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getSenha()=" + getSenha() + "]";
	}

	

	

}
