package projeto.excecoes.usuario;

public class VerificacaoDeCorridaException extends Exception {
	
	public VerificacaoDeCorridaException(String msg) {
		super(msg);
	}
	
	public VerificacaoDeCorridaException() {
		super("Corrida Invalida");
	}

	

}
