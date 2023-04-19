package pessoa;

public class Diretor extends Gerente {

	public Diretor(String nome, String cpf, int senha, Cargo tipo, int numeroAgencia) {
		super(nome, cpf, senha, tipo, numeroAgencia);
	}

	@Override
	public String toString() {
		return "Diretor [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}

}
