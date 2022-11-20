package utilidades.fabricas;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public abstract class FabricaJFormatted {

  public static JFormattedTextField criarJFormatted(int x, int y, int largura, int altura, MaskFormatter mascara) {
    try {
      JFormattedTextField formatted = new JFormattedTextField(mascara);
      formatted.setBounds(x, y, largura, altura);
      formatted.setFont(new Font("Arial", 1, 20));
      return formatted;
    } catch (Exception e) {
      return null;
    }
  }

}
