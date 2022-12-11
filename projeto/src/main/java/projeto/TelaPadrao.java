package projeto;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;

public abstract class TelaPadrao extends JFrame {
	
	public static Mototaxista mototaxistaLogado; 
	public static Passageiro passageiroLogado;
	
	public TelaPadrao(String titulo) {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
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
