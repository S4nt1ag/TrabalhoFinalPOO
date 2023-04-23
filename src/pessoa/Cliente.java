package pessoa;

public class Cliente extends Pessoa {

	

	public Cliente(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
		this.tipo = Cargo.CLIENTE;

	}

	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}

}
