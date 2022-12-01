package projeto.excecoes.usuario;

public class CadastroDeCorridaInvalidoException extends Exception {

	public CadastroDeCorridaInvalidoException() {
		super("Os campos devem estar preenchidos");
	}
}
