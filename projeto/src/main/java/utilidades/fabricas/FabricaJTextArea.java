package utilidades.fabricas;

import java.awt.Color;

import javax.swing.JTextArea;

public abstract class FabricaJTextArea {

	public static JTextArea criarJTextArea(int x, int y, int largura, int altura, Color corDeFundo, Color corDaLetra) {
		JTextArea area = new JTextArea();
		area.setBounds(x, y, largura, altura);
		area.setBackground(corDeFundo);
		area.setForeground(corDaLetra);
		return area;
	}

}
