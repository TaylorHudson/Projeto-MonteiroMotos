package projeto.excecoes.usuario;

public class UsuarioJaExisteException extends RuntimeException{

	public UsuarioJaExisteException() {
		super("Este usu�rio j� existe");
	}
	
	public UsuarioJaExisteException(String msg) {
		super(msg);
	}
}
