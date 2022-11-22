package projeto.repositorio;

import java.util.ArrayList;

import projeto.modelo.Corrida;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.servico.ServicoCorrida;
import projeto.servico.ServicoPassageiro;

public class CentralDeInformacoes {

	private ArrayList<Passageiro> passageiros = new ArrayList<Passageiro>();
	private ArrayList<Corrida> corridas = new ArrayList<Corrida>();
	private ArrayList<Mototaxista> mototaxistas = new ArrayList<Mototaxista>();
	private Usuario administrador;

	private ServicoPassageiro servicoPassageiro = new ServicoPassageiro(this);
	private ServicoCorrida servicoCorrida = new ServicoCorrida(this, servicoPassageiro);

	public boolean adicionarPassageiro(Passageiro passageiro) {
		return servicoPassageiro.adicionarPassageiro(passageiro);
	}

	public Passageiro recuperarPassageiroPeloEmail(String email) {
		return servicoPassageiro.recuperarPassageiroPeloEmail(email);
	}

	public boolean validarPassageiro(String email, String senha) {
		return servicoPassageiro.validarPassageiro(email, senha);
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
		return servicoCorrida.recuperarCorridasDeUmPassageiro(email).size();
	}

	public ArrayList<Passageiro> getPassageiros() {
		return passageiros;
	}

	public ArrayList<Corrida> getCorridas() {
		return corridas;
	}

	public void setAdministrador(Usuario administrador) {
		this.administrador = administrador;
	}

	public Usuario getAdministrador() {
		return administrador;
	}

	public ArrayList<Mototaxista> getMototaxistas() {
		return mototaxistas;
	}

}
