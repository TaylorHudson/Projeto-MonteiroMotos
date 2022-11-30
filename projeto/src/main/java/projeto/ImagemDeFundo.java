package projeto;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagemDeFundo extends JPanel {

	private String caminho;
	
	public ImagemDeFundo(String caminho) {
		this.caminho = "img/" +caminho;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon imagem = new ImageIcon(caminho);
		Image img = imagem.getImage();
		g.drawImage(img, 0, 0, this);
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

}
