package utilidades.imagens;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Imagens {

  private static Icon importarImagem(String caminho) {
	  ImageIcon icone = new ImageIcon(caminho);
	  return icone;
  }
 
  public static final ImageIcon BACKGROUND = (ImageIcon) Imagens.importarImagem("img/background.jpg");
  public static final ImageIcon BACKGROUND_2 = (ImageIcon) Imagens.importarImagem("img/background_2.jpg");
  public static final ImageIcon MOTOTAXISTA	 = (ImageIcon) Imagens.importarImagem("img/mototaxista.jpg");
  public static final ImageIcon BACKGROUNDHOME = (ImageIcon) Imagens.importarImagem("img/home.jpg");
  public static final ImageIcon SETA = (ImageIcon) Imagens.importarImagem("img/left-arrow.png");
}
 