package projeto.servico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public abstract class ServicoData {

  public static LocalDate retornarData(String data) {
    if (!dataValida(data)) {
      return null;
    }
    try {
      String[] dataSeparada = data.split("/");
      int dia = Integer.parseInt(dataSeparada[0]);
      int mes = Integer.parseInt(dataSeparada[1]);
      int ano = Integer.parseInt(dataSeparada[2]);
      return LocalDate.of(ano, mes, dia);
    } catch (Exception e) {
      return null;
    }
  }

  public static String retornarString(LocalDate data) {
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return data.format(formatador);
  }

  public static boolean dataValida(String data) {
    String dateFormat = "d/M/uuuu";
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat)
                                                                    .withResolverStyle(ResolverStyle.STRICT);
    try {
      LocalDate.parse(data, dateTimeFormatter);
      return true;
    } catch (DateTimeParseException e) {
      return false;
    }
  }
  
}
