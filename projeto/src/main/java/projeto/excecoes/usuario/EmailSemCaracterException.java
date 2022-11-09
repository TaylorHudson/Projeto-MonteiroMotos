package projeto.excecoes.usuario;

public class EmailSemCaracterException extends RuntimeException{

	public EmailSemCaracterException() {
		super("O campo email não pode ser vazio");
	}
	
	public EmailSemCaracterException(String msg) {
		super(msg);
	}
}
