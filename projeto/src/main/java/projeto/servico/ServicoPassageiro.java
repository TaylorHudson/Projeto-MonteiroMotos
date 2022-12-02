package projeto.servico;

import java.util.ArrayList;

import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.excecoes.usuario.ValidacaoException;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import utilidades.validacao.Validador;

public class ServicoPassageiro {

	private CentralDeInformacoes central;
	private ArrayList<Passageiro> passageiros;

	public ServicoPassageiro(CentralDeInformacoes central) {
		this.central = central;
		passageiros = this.central.getPassageiros();
	}

	public boolean adicionarPassageiro(Passageiro passageiro) throws ValidacaoException {
		boolean ok = true;
		for (Passageiro p : passageiros) {
			if (passageiro.equals(p))
				ok = false;
		}

		if (ok && Validador.idadeValida(passageiro.getDataNascimento())) {
			passageiros.add(passageiro);
			return true;
		}
		return false;
	}

	public Passageiro recuperarPassageiroPeloEmail(String email) throws UsuarioNaoExisteException {
		for (Passageiro p : passageiros) {
			if (p.getEmail().equals(email))
				return p;
		}
		throw new UsuarioNaoExisteException();
	}

	public boolean validarPassageiro(String email, String senha) throws UsuarioNaoExisteException, ValidacaoException {
		Usuario usuario = central.recuperarPassageiroPeloEmail(email);
		if (usuario != null && usuario.getSenha().equals(senha))
			return true;
		throw new ValidacaoException("E-mail/Senha incorretos");
	}

	public CentralDeInformacoes getCentral() {
		return central;
	}

	public ArrayList<Passageiro> getPassageiros() {
		return passageiros;
	}

}
