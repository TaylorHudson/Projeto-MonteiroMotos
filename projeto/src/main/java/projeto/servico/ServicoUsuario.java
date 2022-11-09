package projeto.servico;

import java.util.ArrayList;

import projeto.excecoes.usuario.UsuarioJaExisteException;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import utilidades.persistencia.Persistencia;

public class ServicoUsuario {
	private CentralDeInformacoes central;
	private ArrayList<Usuario> usuarios;

	public ServicoUsuario(CentralDeInformacoes central) {
		this.central = central;
		usuarios = this.central.getUsuarios();
	}

	public boolean adicionarUsuario(Usuario usuario) {
		if (usuarios.isEmpty()) {
			usuarios.add(usuario);
			new Persistencia().salvarCentral(central, "central");
			return true;
		}
		throw new UsuarioJaExisteException();
	}

	public Usuario recuperarUsuarioPeloEmail(String email) {
		for (Usuario u : usuarios) {
			if (u.getEmail().equals(email))
				return u;
		}
		return null;
	}

}
