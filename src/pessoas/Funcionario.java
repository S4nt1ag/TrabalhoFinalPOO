package pessoas;

public abstract class Funcionario extends Pessoa

{
	private String cargo;
	

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
    
}
