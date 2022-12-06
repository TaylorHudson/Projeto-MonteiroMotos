package utilidades.fabricas;

import javax.swing.JCheckBox;
import java.awt.Color;

public abstract class FabricaJCheckBox {

  public static JCheckBox criarJCheckBox(int x, int y, int largura, int altura, String texto,Color corDeFundo,Color corDaLetra) {
    JCheckBox check = new JCheckBox(texto);
    check.setBounds(x, y, largura, altura);
    check.setBorder(null);
    check.setBackground(corDeFundo);
    check.setForeground(corDaLetra);
    return check;
  }
  
  public static JCheckBox criarJCheckBox(int x, int y, int largura, int altura, String texto,Color corDaLetra) {
	    JCheckBox check = new JCheckBox(texto);
	    check.setBounds(x, y, largura, altura);
	    check.setBorder(null);
	    check.setForeground(corDaLetra);
	    return check;
	  }
}
