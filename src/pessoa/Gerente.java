package pessoa;

public class Gerente extends Funcionario {

	private int numeroAgencia;

	public Gerente(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
	}
	

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}


	@Override
	public String toString() {
		return "Gerente [getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getSenha()=" + getSenha() + "]";
	}
	
	

}
