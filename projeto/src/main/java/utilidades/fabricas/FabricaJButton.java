package utilidades.fabricas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public abstract class FabricaJButton {

	public static JButton criarJButton(String texto, int x, int y, 
			int largura, int altura, Color corFundo, Color corLetra, int tamanhoLetra) {
		
		JButton btn = new JButton(texto);
	    btn.setBounds(x, y, largura, altura);
	    btn.setFont(new Font("Arial", 1, tamanhoLetra));
	    btn.setBackground(corFundo);
	    btn.setForeground(corLetra);
	    btn.setFocusable(false);
	    btn.setBorder(null);
	    btn.setOpaque(true);
		
	    return btn;
	}
}
