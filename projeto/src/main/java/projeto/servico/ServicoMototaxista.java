package projeto.servico;

import java.time.LocalDate;
import java.util.ArrayList;

import projeto.TelaPadrao;
import projeto.excecoes.usuario.DataInvalidaException;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.excecoes.usuario.ValidacaoException;
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

	public Mototaxista atualizarPerfil(Mototaxista mototaxiLogado, String email, String nome, String dataNascimento)
			throws ValidacaoException, DataInvalidaException {

		LocalDate data = ServicoData.retornarData(dataNascimento);
		Validador.validarEmail(email);
		Validador.validarNome(nome);
		Validador.idadeValida(data);

		Mototaxista mototaxiAntigo = mototaxiLogado;

		String dataEmString = ServicoData.retornarString(mototaxiLogado.getDataNascimento());

		boolean valido = true;
		if (email.equals(mototaxiAntigo.getEmail()) && nome.equals(mototaxiAntigo.getNome())
				&& dataNascimento.equals(dataEmString)) {
			throw new ValidacaoException("Altere um dos campos");
		} else {
			mototaxiLogado.setEmail(email);
			mototaxiLogado.setNome(nome);
			mototaxiLogado.setDataNascimento(data);

			if (mototaxiLogado.equals(central.getAdministrador()))
				valido = false;

			for (Mototaxista mototaxista : central.getMototaxistas()) {
				if (mototaxista.equals(mototaxiLogado))
					valido = false;
			}

			for (Passageiro passageiro : central.getPassageiros()) {
				if (passageiro.equals(mototaxiLogado))
					valido = false;
			}

			System.out.println(valido);
			if (valido) return mototaxiLogado;
			else return mototaxiAntigo;
		}
	}

}
