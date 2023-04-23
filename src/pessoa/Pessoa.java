package pessoa;

public abstract class Pessoa {
	protected String nome;
	protected String cpf;
	protected int senha;
	protected Cargo tipo;

	public Pessoa(String nome, String cpf, int senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.tipo = null;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public Cargo getTipo() {
		return tipo;
	}

	public void setTipo(Cargo tipo) {
		this.tipo = tipo;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getSenha() {
		return this.senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return ", nome: " + nome + ", cpf: " + cpf;
	}
}
