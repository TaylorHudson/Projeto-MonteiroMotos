package projeto.excecoes.usuario;

public class SenhaInvalidaException extends RuntimeException{

	public SenhaInvalidaException() {
		super("A senha deve conter ao menos seis caracteres");
	}
	
	public SenhaInvalidaException(String msg) {
		super(msg);
	}
}
