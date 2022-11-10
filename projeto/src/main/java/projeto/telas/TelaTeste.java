package projeto.telas;

import javax.swing.JFrame;

public class TelaTeste extends JFrame{

	public TelaTeste(Background bg) {
		setSize(800, 800);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(bg);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TelaTeste(new Background("/utilidades/imagens/background.jpg"));
	}
}
