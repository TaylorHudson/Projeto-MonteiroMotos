package projeto.excecoes.usuario;

public class UsuarioJaExisteException extends RuntimeException{

	public UsuarioJaExisteException() {
		super("Este usuário já existe");
	}
	
	public UsuarioJaExisteException(String msg) {
		super(msg);
	}
}
