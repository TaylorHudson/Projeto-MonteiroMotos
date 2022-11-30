package projeto;

import javax.swing.JFrame;

public abstract class TelaPadrao extends JFrame {

	private ImagemDeFundo imagemDeFundo;
	
	public TelaPadrao(String titulo, ImagemDeFundo imagem) {
		configTela(titulo);
		configImagemDeFundo(imagem);
		configurarComponentes();
	}
	
	public abstract void configurarComponentes();
	
	private void configTela(String titulo) {
		setSize(900, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(titulo);
	}
	
	private void configImagemDeFundo(ImagemDeFundo imagem) {
		imagemDeFundo = imagem;
		imagemDeFundo.setBounds(0, 0, 900, 800);
		add(imagemDeFundo);
	}
	
}
