package projeto.excecoes.usuario;

public class NomeInvalidoException extends RuntimeException{

	public NomeInvalidoException() {
		super("O nome n�o pode ser vazio ou deve ter ao menos seis caracteres");
	}
	
	public NomeInvalidoException(String msg) {
		super(msg);
	}
}
