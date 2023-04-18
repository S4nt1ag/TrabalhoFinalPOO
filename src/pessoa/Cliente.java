package pessoa;

import java.util.HashMap;

import contas.Conta;

public class Cliente extends Pessoa {

	public HashMap<String, Conta> listaCliente = new HashMap<String, Conta>();

	public HashMap<String, Conta> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(HashMap<String, Conta> listaCliente) {
		this.listaCliente = listaCliente;
	}

}
