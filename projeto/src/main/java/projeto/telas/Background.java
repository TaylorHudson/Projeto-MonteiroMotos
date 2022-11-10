package projeto.telas;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel{

	private Image imagem;
	
	public Background(String caminho) {
		this.imagem = new ImageIcon(getClass().getResource(caminho)).getImage();
	}
	
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		g.drawImage(imagem, 250, 30, 280, 280, this);
	}
	
}
