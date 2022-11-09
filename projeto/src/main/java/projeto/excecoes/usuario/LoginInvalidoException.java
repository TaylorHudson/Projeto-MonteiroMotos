package projeto.excecoes.usuario;

public class LoginInvalidoException extends RuntimeException{

	public LoginInvalidoException() {
		super("O login deve conter ao menos seis caracteres");
	}
	
	public LoginInvalidoException(String msg) {
		super(msg);
	}
}
