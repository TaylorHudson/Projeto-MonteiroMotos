package utilidades.fabricas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import utilidades.Imagens;

public abstract class FabricaJLabel {

	public static JLabel criarJLabel(String texto, int x, int y,int largura, int altura,
			Color corFundo, Color corLetra, int tamanhoLetra) {
		
		JLabel lbl = new JLabel(texto);
	    lbl.setBounds(x ,y, largura, altura);
	    lbl.setForeground(corLetra);
	    lbl.setBackground(corFundo);
	    lbl.setFont(new Font("Arial", 1, tamanhoLetra));

	    return lbl;
	}
	
	public static JLabel criarJLabel(String texto, int x, int y,int largura, int altura,
			Color corLetra, int tamanhoLetra) {
		
		JLabel lbl = new JLabel(texto);
	    lbl.setBounds(x ,y, largura, altura);
	    lbl.setForeground(corLetra);
	    lbl.setFont(new Font("Arial", 1, tamanhoLetra));

	    return lbl;
	}
	
	public static JLabel criarJLabel(int x, int y,int largura, int altura,
		Color corBorda, int larguraBorda) {
		
		JLabel lbl = new JLabel();
	    lbl.setBounds(x, y, largura, altura);
	    lbl.setLayout(null);
	    lbl.setBorder(BorderFactory.createLineBorder(corBorda, larguraBorda));
	    
	    return lbl;
	}
	
	public static JLabel criarJLabel(int x, int y,int largura, int altura,ImageIcon imagem) {
			JLabel bg = new JLabel();
			bg.setBounds(x, y, largura, altura);
			bg.setLayout(null);
			bg.setIcon(Imagens.BACKGROUND);
		    
			return bg;
		}
	
	
}
