package projeto.servico;

import java.util.ArrayList;

import projeto.TelaPadrao;
import projeto.excecoes.usuario.SemCreditoReivindicacaoException;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.excecoes.usuario.ValidacaoException;
import projeto.modelo.Corrida;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.repositorio.CentralDeInformacoes;
import utilidades.validacao.Validador;

public class ServicoMototaxista {

	private CentralDeInformacoes central;
	private ArrayList<Mototaxista> mototaxistas;

	public ServicoMototaxista(CentralDeInformacoes central) {
		this.central = central;
		mototaxistas = this.central.getMototaxistas();
	}

	public boolean adicionarMototaxista(Mototaxista mototaxista) throws ValidacaoException {
		boolean ok = true;
		for (Mototaxista m : mototaxistas) {
			if (mototaxista.equals(m) && m.isEstaAtivo())
				ok = false;
		}

		for (Passageiro p : central.getPassageiros()) {
			if (mototaxista.equals(p) && p.isEstaAtivo()) {
				ok = false;
			}
		}

		if (mototaxista.equals(central.getAdministrador()))
			ok = false;

		if (ok && Validador.idadeValida(mototaxista.getDataNascimento())) {
			mototaxistas.add(mototaxista);
			return true;
		}
		throw new ValidacaoException("Email já cadastrado");
	}

	public Mototaxista recuperarMototaxistaPeloEmail(String email) throws UsuarioNaoExisteException {
		for (Mototaxista m : mototaxistas) {
			if (m.getEmail().equals(email))
				return m;
		}
		throw new UsuarioNaoExisteException();
	}

	public boolean validarMototaxista(String email, String senha) throws ValidacaoException {
		Mototaxista usuario;
		try {
			usuario = central.recuperarMototaxistaPeloEmail(email);
			if (usuario.getSenha().equals(senha) && usuario.isEstaAtivo())
				return true;
		} catch (UsuarioNaoExisteException e) {
			throw new ValidacaoException("E-mail/Senha incorretos");
		}
		throw new ValidacaoException("E-mail/Senha incorretos");
	}

	public void deletar() {
		Mototaxista mototaxi = TelaPadrao.mototaxistaLogado;
		mototaxi.setEstaAtivo(false);
	}

	public boolean estaBloqueado(Passageiro passageiro) {
		Mototaxista mototaxista = TelaPadrao.mototaxistaLogado;
		for(Mototaxista m: passageiro.getMototaxistasBloqueados()) {
			if(m.equals(mototaxista)) return true;
		}
		return false;
	}
	
	public void reivindicarCorrida(Mototaxista mototaxista, Corrida corrida) throws SemCreditoReivindicacaoException {
		int qtdCreditos = mototaxista.getCreditosReivindicacao();
		if (qtdCreditos == 0) {
			throw new SemCreditoReivindicacaoException();
		}
		
	}
}
