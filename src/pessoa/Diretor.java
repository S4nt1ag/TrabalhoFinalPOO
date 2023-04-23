package pessoa;

public class Diretor extends Gerente {

	public Diretor(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
		this.tipo = Cargo.DIRETOR;
	}

	@Override
	public String toString() {
		return "Diretor [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}

}
