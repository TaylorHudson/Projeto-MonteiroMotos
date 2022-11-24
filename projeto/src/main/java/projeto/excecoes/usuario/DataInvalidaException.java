package projeto.excecoes.usuario;

public class DataInvalidaException extends Exception{
  
  public DataInvalidaException(String msg) {
    super(msg);
  }

  public DataInvalidaException() {
    super("Data inválida");
  }
}
