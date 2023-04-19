package pessoa;

public class Presidente extends Diretor {

	public Presidente(String nome, String cpf, int senha, Cargo tipo, int numeroAgencia) {
		super(nome, cpf, senha, tipo, numeroAgencia);
	}

	@Override
	public String toString() {
		return "Presidente [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}

}
