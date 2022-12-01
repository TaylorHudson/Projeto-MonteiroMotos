package projeto.excecoes.usuario;

public class UsuarioNaoExisteException extends Exception{

	public UsuarioNaoExisteException() {
		super("Usu�rio inexistente");
	}
	
	public UsuarioNaoExisteException(String msg) {
		super(msg);
	}
}
