package projeto.excecoes.usuario;

public class UsuarioNaoExisteException extends RuntimeException{

	public UsuarioNaoExisteException() {
		super("Usuário inexistente");
	}
	
	public UsuarioNaoExisteException(String msg) {
		super(msg);
	}
}
