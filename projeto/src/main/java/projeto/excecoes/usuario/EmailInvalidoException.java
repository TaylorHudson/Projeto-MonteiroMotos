package projeto.excecoes.usuario;

public class EmailInvalidoException extends RuntimeException{

	public EmailInvalidoException() {
		super("E-mail inválido");
	}
	
	public EmailInvalidoException(String msg) {
		super(msg);
	}
}
