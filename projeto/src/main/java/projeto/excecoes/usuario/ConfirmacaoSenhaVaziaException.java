package projeto.excecoes.usuario;

public class ConfirmacaoSenhaVaziaException extends RuntimeException{

	public ConfirmacaoSenhaVaziaException() {
		super("Nenhum caracter identificado");
	}
	
	public ConfirmacaoSenhaVaziaException(String msg) {
		super(msg);
	}
}
