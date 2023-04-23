package pessoa;

public class Cliente extends Pessoa {

	

	public Cliente(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
		this.tipo = Cargo.CLIENTE;

	}

	
	@Override
	public String toString() {
		return ", nome: " + nome + ", cpf: " + cpf + ", tipo: " + tipo;
	}

}
