package projeto.repositorio;

import java.util.ArrayList;

import projeto.excecoes.usuario.DataInvalidaException;
import projeto.excecoes.usuario.EmailEmUsoException;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.excecoes.usuario.ValidacaoException;
import projeto.excecoes.usuario.VerificacaoDeCorridaException;
import projeto.modelo.Corrida;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.servico.ServicoCorrida;
import projeto.servico.ServicoMototaxista;
import projeto.servico.ServicoPassageiro;
import projeto.servico.ServicoUsuario;

public class CentralDeInformacoes {

	private ArrayList<Passageiro> passageiros = new ArrayList<Passageiro>();
	private ArrayList<Corrida> corridas = new ArrayList<Corrida>();
	private ArrayList<Mototaxista> mototaxistas = new ArrayList<Mototaxista>();
	private Usuario administrador;
	private double valorDoCredito;

	private ServicoPassageiro servicoPassageiro = new ServicoPassageiro(this);
	private ServicoCorrida servicoCorrida = new ServicoCorrida(this, servicoPassageiro);
	private ServicoMototaxista servicoMototaxista = new ServicoMototaxista(this);

	public boolean adicionarMototaxista(Mototaxista mototaxista) throws ValidacaoException {
		return servicoMototaxista.adicionarMototaxista(mototaxista);
	}

	public Mototaxista recuperarMototaxistaPeloEmail(String email) throws UsuarioNaoExisteException {
		return servicoMototaxista.recuperarMototaxistaPeloEmail(email);
	}
	
//	public Mototaxista atualizarPerfil(Mototaxista mototaxi,String email, String nome, String dataNascimento) throws ValidacaoException, DataInvalidaException, EmailEmUsoException {
//		return servicoMototaxista.atualizarPerfil(mototaxi,email, nome, dataNascimento);
//	}

	public Usuario atualizarPerfil(Usuario usuario, String email, String nome, String dataNascimento)
			throws ValidacaoException, DataInvalidaException, EmailEmUsoException {
		ServicoUsuario servicoUsuario = new ServicoUsuario(this);
		return servicoUsuario.atualizarPerfil(usuario, email, nome, dataNascimento);
	}
	
	public boolean adicionarPassageiro(Passageiro passageiro) throws ValidacaoException {
		return servicoPassageiro.adicionarPassageiro(passageiro);
	}

	public Passageiro recuperarPassageiroPeloEmail(String email) throws UsuarioNaoExisteException {
		return servicoPassageiro.recuperarPassageiroPeloEmail(email);
	}

	public boolean validarPassageiro(String email, String senha) throws UsuarioNaoExisteException, ValidacaoException {
		return servicoPassageiro.validarPassageiro(email, senha);
	}

	public boolean adicionarCorrida(Corrida corrida) throws VerificacaoDeCorridaException {
		return servicoCorrida.adicionarCorrida(corrida);
	}

	public Corrida recuperarCorridaPeloId(long id) {
		return servicoCorrida.recuperarCorridaPeloId(id);
	}

	public ArrayList<Corrida> recuperarCorridasDeUmPassageiro(String email) throws UsuarioNaoExisteException {
		return servicoCorrida.recuperarCorridasDeUmPassageiro(email);
	}

	public int recuperarNumeroCorridasDeUmPassageiro(String email) throws UsuarioNaoExisteException {
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

	public double getValorDoCredito() {
		return valorDoCredito;
	}

	public void setValorDoCredito(double valorDoCredito) {
		this.valorDoCredito = valorDoCredito;
	}

}
