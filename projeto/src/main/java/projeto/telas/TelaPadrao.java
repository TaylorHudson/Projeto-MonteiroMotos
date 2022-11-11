package projeto.telas;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class TelaPadrao extends JFrame {
	
	private JLabel background;

	public TelaPadrao(String titulo) {
		setSize(900, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(titulo);
		addComponentes();
		setVisible(true);
	}
	
	public abstract void addComponentes();
	
}
