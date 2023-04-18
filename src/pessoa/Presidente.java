package pessoa;

public class Presidente extends Diretor {

	public Presidente(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
		
	}

	@Override
	public String toString() {
		return "Presidente [getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getSenha()=" + getSenha() + "]";
	}

	

	

}
