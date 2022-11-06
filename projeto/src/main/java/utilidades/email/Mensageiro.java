package utilidades.email;

import java.util.Random;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.MultiPartEmail;

import projeto.modelo.Usuario;

public class Mensageiro {

  public static int enviarEmailComCodigoDeVerificacao(Usuario usuario) {
    String remetente = "pooprojeto824@gmail.com";
    String senha = "rehjpckvmjwhvkpu";
    
    int min = 1234;
    int max = 9999;

    MultiPartEmail email = new MultiPartEmail();
    email.setHostName("smtp.gmail.com");
    email.setSmtpPort(465);
    email.setAuthenticator(new DefaultAuthenticator(remetente, senha));
    email.setSSLOnConnect(true);
    try {
      email.setFrom(remetente);
      email.setSubject("Código para mudança de senha.");
      int codigo = new Random().nextInt((max - min) + 1) + min;
      email.setMsg("Seu código: " + codigo);
      email.addTo(usuario.getEmail());
      email.send();
      
      return codigo;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }
  
}
