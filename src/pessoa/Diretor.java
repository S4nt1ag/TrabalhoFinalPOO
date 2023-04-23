package pessoa;

public class Diretor extends Gerente {

	public Diretor(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
		this.tipo = Cargo.DIRETOR;
	}

	@Override
	public String toString() {
		return ", nome: " + nome + ", cpf: " + cpf + ", tipo: " + tipo;
	}

}
