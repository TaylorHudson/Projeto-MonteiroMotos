package utilidades.imagens;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Imagens {

  private static Icon importarImagem(String caminho) {
	  ImageIcon icone = new ImageIcon(caminho);
	  return icone;
  }
 
  public static final ImageIcon BACKGROUND = (ImageIcon) Imagens.importarImagem("background.jpg");
  public static final ImageIcon BACKGROUND_2 = (ImageIcon) Imagens.importarImagem("background_2.jpg");
  public static final ImageIcon MOTOTAXISTA	 = (ImageIcon) Imagens.importarImagem("mototaxista.jpg");
  public static final ImageIcon BACKGROUNDHOME = (ImageIcon) Imagens.importarImagem("home.jpg");
  public static final ImageIcon SETA = (ImageIcon) Imagens.importarImagem("left-arrow.png");
}
 