package utilidades.imagens;

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
 
  public static final ImageIcon BACKGROUND = (ImageIcon) Imagens.importarImagem("/utilidades/imagens/background.jpg");
  public static final ImageIcon BACKGROUND_2 = (ImageIcon) Imagens.importarImagem("/utilidades/imagens/background_2.jpg");
  public static final ImageIcon MOTOTAXISTA	 = (ImageIcon) Imagens.importarImagem("/utilidades/imagens/mototaxista.jpg");
  public static final ImageIcon BACKGROUNDHOME = (ImageIcon) Imagens.importarImagem("/utilidades/imagens/Home.jpg");
}
 