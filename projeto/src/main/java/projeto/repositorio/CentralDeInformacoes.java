package projeto.repositorio;

import java.util.ArrayList;

import projeto.modelo.Corrida;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;

public class CentralDeInformacoes {

	private ArrayList<Passageiro> passageiros;
	private ArrayList<Corrida> corridas;
	private ArrayList<Usuario> usuarios;
	
	public ArrayList<Passageiro> getPassageiros() {
		return passageiros;
	}
	public ArrayList<Corrida> getCorridas() {
		return corridas;
	}
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
}
