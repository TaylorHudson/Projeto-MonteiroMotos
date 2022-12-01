package projeto.excecoes.usuario;

public class StatusDaCorridaInvalidoException extends Exception {
	
	public StatusDaCorridaInvalidoException() {
		super("Selecione apenas uma opção");
		
	}
	
	public StatusDaCorridaInvalidoException(String msg) {
		super(msg);
		
	}

}
