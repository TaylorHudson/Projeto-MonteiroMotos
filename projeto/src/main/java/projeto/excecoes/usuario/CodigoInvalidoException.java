package projeto.excecoes.usuario;

public class CodigoInvalidoException extends RuntimeException{

	public CodigoInvalidoException() {
		super("O código passado é inválido");
	}
	
	public CodigoInvalidoException(String msg) {
		super(msg);
	}
}
