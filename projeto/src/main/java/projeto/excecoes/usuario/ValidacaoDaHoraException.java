package projeto.excecoes.usuario;

public class ValidacaoDaHoraException extends Exception {

	public ValidacaoDaHoraException() {
		super("Os campos da hora devem estar preenchido");
	}

}
