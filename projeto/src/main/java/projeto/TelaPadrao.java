package projeto;

import javax.swing.JFrame;

public abstract class TelaPadrao extends JFrame {
	
	public TelaPadrao(String titulo) {
		configTela(titulo);
		configurarComponentes();
	}
	
	public abstract void configurarComponentes();
	
	public ImagemDeFundo configImagemDeFundo(String caminho) {
		ImagemDeFundo background = new ImagemDeFundo(caminho);
		background.setLayout(null);
		background.setBounds(0, 0, 900, 800);
		return background;
	}
	
	private void configTela(String titulo) {
		setSize(900, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(titulo);
	}

}
