package pessoa;

public class Presidente extends Diretor {

	public Presidente(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
		this.tipo = Cargo.PRESIDENTE;
	}

	@Override
	public String toString() {
		return ", nome: " + nome + ", cpf: " + cpf + ", tipo: " + tipo;
	}

}
