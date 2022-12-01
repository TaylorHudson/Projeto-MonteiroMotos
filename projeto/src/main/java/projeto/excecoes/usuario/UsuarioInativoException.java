package projeto.excecoes.usuario;

public class UsuarioInativoException extends Exception{

	public UsuarioInativoException() {
		super("Este usu�rio n�o est� ativo");
	}
	
	public UsuarioInativoException(String msg) {
		super(msg);
	}
}
