package projeto.excecoes.usuario;

public class CamposDiferentesException extends RuntimeException{

	public CamposDiferentesException() {
		super("As senhas não coincidem");
	}
	
	public CamposDiferentesException(String msg) {
		super(msg);
	}
}
