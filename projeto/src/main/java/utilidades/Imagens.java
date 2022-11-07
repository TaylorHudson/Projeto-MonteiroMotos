package utilidades;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Imagens {

  private static Icon importarImagem(String caminho) {
    try {
      return new ImageIcon(Imagens.class.getResource(caminho));
    } catch (Exception e) {
      return null;
    }
  }
 
  public static final ImageIcon BACKGROUND  = (ImageIcon) Imagens.importarImagem("/utilidades/imagens/background.jpg");
}
