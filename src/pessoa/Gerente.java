package pessoa;

public class Gerente extends Funcionario {

	public Gerente(String nome, String cpf, Integer senha, String email, Integer telefone, String endereco,
			String cargo) {
		super(nome, cpf, senha, email, telefone, endereco, cargo);

	}

	private int gestaoAgencia;

	public int getGestaoAgencia() {
		return gestaoAgencia;
	}

	public void setGestaoAgencia(int gestao) {
		this.gestaoAgencia = gestao;
	}

}
