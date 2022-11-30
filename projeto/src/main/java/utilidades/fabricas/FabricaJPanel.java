package utilidades.fabricas;

import java.awt.Color;

import javax.swing.JPanel;

import projeto.ImagemDeFundo;

public abstract class FabricaJPanel {

	public static JPanel criarJPanel(int x, int y, int largura, int altura,
			Color corFundo) {

		JPanel painel = new JPanel();
		painel.setOpaque(true);
		painel.setBounds(x, y, largura, altura);
		painel.setBackground(corFundo);

		return painel;
	}
	
}