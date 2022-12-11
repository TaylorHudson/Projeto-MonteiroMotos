package projeto;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;

/*
 * @author José Valdnei
 * 
 * Classe que todas as telas do sistemas herdam dela 
 * */
public abstract class TelaPadrao extends JFrame {
	/*
	 * Representa o Mototaxista logado no momento
	 * */
	public static Mototaxista mototaxistaLogado;
	/*
	 * Representa o Passageiro logado no momento
	 * */
	public static Passageiro passageiroLogado;
	
	/*
	 * Inicia as configurações padrões de todas as telas
	 * */
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
	/*
	 * Método obrigatório em todas as classes para configurar os componentes da tela 
	 * */
	public abstract void configurarComponentes();
	/*
	 * Método para configurar a imagem de fundo da tela 
	 * */
	public ImagemDeFundo configImagemDeFundo(String caminho) {
		ImagemDeFundo background = new ImagemDeFundo(caminho);
		background.setLayout(null);
		background.setBounds(0, 0, 900, 800);
		return background;
	}
	/*
	 * Método para configurar as dimensões e posições da tela
	 * */
	private void configTela(String titulo) {
		setSize(900, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(titulo);
	}
}
