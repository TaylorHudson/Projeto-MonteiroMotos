package projeto.servico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import projeto.excecoes.usuario.DataInvalidaException;

public abstract class ServicoData {

  public static LocalDate retornarData(String data) throws DataInvalidaException {
    if (!dataValida(data)) {
      throw new DataInvalidaException();
    }
    try {
      String[] dataSeparada = data.split("/");
      int dia = Integer.parseInt(dataSeparada[0]);
      int mes = Integer.parseInt(dataSeparada[1]);
      int ano = Integer.parseInt(dataSeparada[2]);
      return LocalDate.of(ano, mes, dia);
    } catch (Exception e) {
      throw new DataInvalidaException();
    }
  }

  public static String retornarString(LocalDate data) throws DataInvalidaException{
    try {
      DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      return data.format(formatador);
    } catch (Exception e) {
      throw new DataInvalidaException();
    }  
  }

  public static boolean dataValida(String data) throws DataInvalidaException {
    String dateFormat = "d/M/uuuu";
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat)
                                                                    .withResolverStyle(ResolverStyle.STRICT);
    try {
      LocalDate.parse(data, dateTimeFormatter);
      return true;
    } catch (DateTimeParseException e) {
      throw new DataInvalidaException("Passe uma data válida");
    }
  }
  
}
