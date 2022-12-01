package projeto.excecoes.usuario;

public class ValidacaoException extends Exception{
  
  public ValidacaoException() {
    super("Dados de cadastro inválido\n\nA senha deve conter pelo menos seis caracteres e um caracter especial");
  }

  public ValidacaoException(String msg) {
    super(msg);
  }
}
