package pessoa;

public class Funcionario extends Pessoa {

	private String cargo;

	public Funcionario(String nome, String cpf, Integer senha, String email, Integer telefone, String endereco, String cargo) {
		super(nome, cpf, senha, email, telefone, endereco);
		this.cargo = cargo;
	}
public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
