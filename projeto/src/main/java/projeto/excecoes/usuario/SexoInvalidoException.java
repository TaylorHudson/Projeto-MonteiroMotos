package projeto.excecoes.usuario;

public class SexoInvalidoException extends Exception {

	public SexoInvalidoException() {
		super("Selecione apenas um sexo");

	}
	public SexoInvalidoException(String msg) {
		super(msg);
	}
}
