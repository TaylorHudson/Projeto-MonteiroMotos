package projeto.repositorio;

import java.util.ArrayList;

import projeto.modelo.Corrida;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.servico.ServicoCorrida;
import projeto.servico.ServicoPassageiro;

public class CentralDeInformacoes {

	private ArrayList<Passageiro> passageiros;
	private ArrayList<Corrida> corridas;
	private ArrayList<Usuario> usuarios;

	private ServicoPassageiro servicoPassageiro = new ServicoPassageiro(this);
	private ServicoCorrida servicoCorrida = new ServicoCorrida(this, servicoPassageiro);

	public boolean adicionarPassageiro(Passageiro passageiro) {
		return servicoPassageiro.adicionarPassageiro(passageiro);
	}

	public Passageiro recuperarPassageiroPeloEmail(String email) {
		return servicoPassageiro.recuperarPassageiroPeloEmail(email);
	}

	public boolean adicionarCorrida(Corrida corrida) {
		return servicoCorrida.adicionarCorrida(corrida);
	}

	public Corrida recuperarCorridaPeloId(long id) {
		return servicoCorrida.recuperarCorridaPeloId(id);
	}

	public ArrayList<Corrida> recuperarCorridasDeUmPassageiro(String email) {
		return servicoCorrida.recuperarCorridasDeUmPassageiro(email);
	}

	public int recuperarNumeroCorridasDeUmPassageiro(String email) {
	    return servicoCorrida.recuperarNumeroCorridasDeUmPassageiro(email);
	  }

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
