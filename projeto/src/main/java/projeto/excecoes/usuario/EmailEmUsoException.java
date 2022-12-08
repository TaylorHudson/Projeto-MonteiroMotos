package projeto.excecoes.usuario;

public class EmailEmUsoException extends Exception {

	public EmailEmUsoException() {
		super("Email já cadastrado");
	}
}
