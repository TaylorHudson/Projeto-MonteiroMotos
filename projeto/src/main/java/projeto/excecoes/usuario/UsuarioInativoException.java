package projeto.excecoes.usuario;

public class UsuarioInativoException extends Exception{

	public UsuarioInativoException() {
		super("Este usuário não está ativo");
	}
	
	public UsuarioInativoException(String msg) {
		super(msg);
	}
}
