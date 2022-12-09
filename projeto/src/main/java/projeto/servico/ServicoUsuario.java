package projeto.servico;

import java.time.LocalDate;

import projeto.TelaPadrao;
import projeto.excecoes.usuario.DataInvalidaException;
import projeto.excecoes.usuario.EmailEmUsoException;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.excecoes.usuario.ValidacaoException;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import utilidades.validacao.Validador;

public class ServicoUsuario {
	private CentralDeInformacoes central;

	public ServicoUsuario(CentralDeInformacoes central) {
		this.central = central;
	}

	public Usuario atualizarPerfil(Usuario usuario, String email, String nome, String dataNascimento)
			throws ValidacaoException, DataInvalidaException, EmailEmUsoException {

		LocalDate data = ServicoData.retornarData(dataNascimento);
		Validador.validarEmail(email);
		Validador.validarNome(nome);
		Validador.idadeValida(data);

		Usuario novoUsuario = new Usuario(usuario.getEmail());
		novoUsuario.setSenha(usuario.getSenha());

		String dataEmString = ServicoData.retornarString(usuario.getDataNascimento());

		boolean valido = true;
		if (email.equals(usuario.getEmail()) && nome.equals(usuario.getNome()) && dataNascimento.equals(dataEmString)) {
			throw new ValidacaoException("Altere um dos campos");
		} else {
			novoUsuario.setEmail(email);
			novoUsuario.setNome(nome);
			novoUsuario.setDataNascimento(data);
			Usuario adm = central.getAdministrador();
			if (!usuario.equals(adm) && novoUsuario.equals(adm)) {
				valido = false;
				throw new EmailEmUsoException();
			}

			for (Mototaxista mototaxista : central.getMototaxistas()) {
				if (!usuario.equals(mototaxista)) {
					if (mototaxista.equals(novoUsuario) && mototaxista.isEstaAtivo()) {
						valido = false;
						throw new EmailEmUsoException();
					}
				}
			}

			for (Passageiro passageiro : central.getPassageiros()) {
				if (!usuario.equals(passageiro)) {
					if (passageiro.equals(novoUsuario) && passageiro.isEstaAtivo()) {
						valido = false;
						throw new EmailEmUsoException();
					}
				}
			}

			if (valido) {
				try {
					if (usuario instanceof Mototaxista) {
						Mototaxista m = central.recuperarMototaxistaPeloEmail(usuario.getEmail());
						m.setEmail(novoUsuario.getEmail());
						m.setNome(novoUsuario.getNome());
						m.setDataNascimento(novoUsuario.getDataNascimento());
						TelaPadrao.mototaxistaLogado = m;
					} else if (usuario instanceof Passageiro) {
						Passageiro p = central.recuperarPassageiroPeloEmail(usuario.getEmail());
						p.setEmail(novoUsuario.getEmail());
						p.setNome(novoUsuario.getNome());
						p.setDataNascimento(novoUsuario.getDataNascimento());
						TelaPadrao.passageiroLogado = p;
					} else {
						adm.setEmail(novoUsuario.getEmail());
						adm.setNome(novoUsuario.getNome());
						adm.setDataNascimento(novoUsuario.getDataNascimento());
					}
				} catch (UsuarioNaoExisteException e) {
				}
				return novoUsuario;
			} else {
				return usuario;
			}
		}
	}

}
