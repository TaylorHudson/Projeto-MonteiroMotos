package projeto.repositorio;

import java.util.ArrayList;

import projeto.TelaPadrao;
import projeto.excecoes.usuario.DataInvalidaException;
import projeto.excecoes.usuario.EmailEmUsoException;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.excecoes.usuario.ValidacaoException;
import projeto.excecoes.usuario.VerificacaoDeCorridaException;
import projeto.modelo.Corrida;
import projeto.modelo.CreditosDeRevindicacao;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.servico.ServicoCorrida;
import projeto.servico.ServicoMototaxista;
import projeto.servico.ServicoPassageiro;
import projeto.servico.ServicoUsuario;
import utilidades.validacao.Validador;

public class CentralDeInformacoes {

	private ArrayList<Passageiro> passageiros = new ArrayList<Passageiro>();
	private ArrayList<Corrida> corridas = new ArrayList<Corrida>();
	private ArrayList<Mototaxista> mototaxistas = new ArrayList<Mototaxista>();
	private ArrayList<CreditosDeRevindicacao> creditosDoSistema = new ArrayList<CreditosDeRevindicacao>();
	private Usuario administrador;
	private double valorDoCredito = 0;

	private ServicoPassageiro servicoPassageiro = new ServicoPassageiro(this);
	private ServicoCorrida servicoCorrida = new ServicoCorrida(this, servicoPassageiro);
	private ServicoMototaxista servicoMototaxista = new ServicoMototaxista(this);

	public boolean adicionarMototaxista(Mototaxista mototaxista) throws ValidacaoException {
		return servicoMototaxista.adicionarMototaxista(mototaxista);
	}

	public Mototaxista recuperarMototaxistaPeloEmail(String email) throws UsuarioNaoExisteException {
		return servicoMototaxista.recuperarMototaxistaPeloEmail(email);
	}
	
	public void adicionarReivindicacao(CreditosDeRevindicacao credito) {
		creditosDoSistema.add(credito);
	}
	
	public Usuario atualizarPerfil(Usuario usuario, String email, String nome, String dataNascimento,String senha)
			throws ValidacaoException, DataInvalidaException, EmailEmUsoException {
		ServicoUsuario servicoUsuario = new ServicoUsuario(this);
		return servicoUsuario.atualizarPerfil(usuario, email, nome, dataNascimento,senha);
	}
	
	public void atualizarSenha(String email, String senha) throws ValidacaoException {
		Validador.validarSenha(senha);
		for(Usuario u : getMototaxistas())
			if(u.getEmail().equals(email)) u.setSenha(senha);
		for(Usuario u : getPassageiros()) 
			if(u.getEmail().equals(email)) u.setSenha(senha);
		if(administrador.getEmail().equals(email)) administrador.setSenha(senha);
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
	
	public boolean verificarEmailExistente(String email) throws UsuarioNaoExisteException {
		boolean valido = false;
		for(Usuario u : getMototaxistas())
			if(u.getEmail().equals(email)) valido = true;
		for(Usuario u : getPassageiros()) 
			if(u.getEmail().equals(email)) valido = true;
		if(administrador.getEmail().equals(email)) valido = true;
		
		if(valido) return true;
		throw new UsuarioNaoExisteException();
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

	public ArrayList<CreditosDeRevindicacao> getCreditosDoSistema() {
		return creditosDoSistema;
	}
	
	

}
