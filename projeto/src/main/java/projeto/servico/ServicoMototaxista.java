package projeto.servico;

import java.time.LocalDate;
import java.util.ArrayList;

import projeto.TelaPadrao;
import projeto.excecoes.usuario.DataInvalidaException;
import projeto.excecoes.usuario.EmailEmUsoException;
import projeto.excecoes.usuario.SemCreditoReivindicacaoException;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.excecoes.usuario.ValidacaoException;
import projeto.modelo.Corrida;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.repositorio.CentralDeInformacoes;
import utilidades.fabricas.FabricaJOptionPane;
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
			throws ValidacaoException, DataInvalidaException, EmailEmUsoException {

		LocalDate data = ServicoData.retornarData(dataNascimento);
		Validador.validarEmail(email);
		Validador.validarNome(nome);
		Validador.idadeValida(data);

		Mototaxista novoMototaxi = new Mototaxista(mototaxiLogado.getEmail());
		novoMototaxi.setSenha(mototaxiLogado.getSenha());

		String dataEmString = ServicoData.retornarString(mototaxiLogado.getDataNascimento());

		boolean valido = true;
		if (email.equals(mototaxiLogado.getEmail()) && nome.equals(mototaxiLogado.getNome())
				&& dataNascimento.equals(dataEmString)) {
			throw new ValidacaoException("Altere um dos campos");
		} else {
			novoMototaxi.setEmail(email);
			novoMototaxi.setNome(nome);
			novoMototaxi.setDataNascimento(data);

			if (novoMototaxi.equals(central.getAdministrador())) {
				valido = false;
				throw new EmailEmUsoException();
			}

			for (Mototaxista mototaxista : central.getMototaxistas()) {
				if (!mototaxiLogado.equals(mototaxista)) {
					if (mototaxista.equals(novoMototaxi) && mototaxista.isEstaAtivo()) {
						valido = false;
						throw new EmailEmUsoException();
					}
				}
			}

			for (Passageiro passageiro : central.getPassageiros()) {
				if (passageiro.equals(novoMototaxi) && passageiro.isEstaAtivo()) {
					valido = false;
					throw new EmailEmUsoException();
				}
			}

			if (valido) {
				TelaPadrao.mototaxistaLogado = novoMototaxi;
				try {
					Mototaxista m = central.recuperarMototaxistaPeloEmail(mototaxiLogado.getEmail());
					m.setEmail(novoMototaxi.getEmail());
					m.setNome(novoMototaxi.getNome());
					m.setDataNascimento(novoMototaxi.getDataNascimento());
				} catch (UsuarioNaoExisteException e) {}
				return novoMototaxi;
			} else {
				return mototaxiLogado;
			}
		}
	}

	public void reivindicarCorrida(Mototaxista mototaxista, Corrida corrida) throws SemCreditoReivindicacaoException {
		int qtdCreditos = mototaxista.getCreditosReivindicacao();
		if (qtdCreditos == 0) {
			throw new SemCreditoReivindicacaoException();
		}
		
	}
}
