package projeto.excecoes.usuario;

public class UsuarioNaoExisteException extends RuntimeException{

	public UsuarioNaoExisteException() {
		super("Usu�rio inexistente");
	}
	
	public UsuarioNaoExisteException(String msg) {
		super(msg);
	}
}
