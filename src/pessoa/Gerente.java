package pessoa;

public class Gerente extends Funcionario {


	public Gerente(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
		this.tipo = Cargo.GERENTE;
	}

	@Override
	public String toString() {
		return "Gerente [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}

}
