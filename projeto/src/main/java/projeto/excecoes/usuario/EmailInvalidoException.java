package projeto.excecoes.usuario;

public class EmailInvalidoException extends RuntimeException{

	public EmailInvalidoException() {
		super("E-mail inv�lido");
	}
	
	public EmailInvalidoException(String msg) {
		super(msg);
	}
}
