package projeto.excecoes.usuario;

public class CodigoInvalidoException extends RuntimeException{

	public CodigoInvalidoException() {
		super("O c�digo passado � inv�lido");
	}
	
	public CodigoInvalidoException(String msg) {
		super(msg);
	}
}
