package projeto.telas.mototaxista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;

public class TelaHomeMototaxista extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JMenu editar;
	private JMenu deletar;
	private JButton btnListarCorridas;
	private JButton btnComprarCreditos;
	private JLabel background;

	public TelaHomeMototaxista(){
		configImagemFundo();
		configurarTela();
		configMenu();
		configBotoes();
		setVisible(true);
	}
	
	private void configurarTela() {
		setSize(900, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Home");
	}
	
	private void configMenu() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 10, 100, 200);
		editar = new JMenu("Editar");
		deletar = new JMenu("Deletar");
		
		menuBar.add(editar);
		menuBar.add(deletar);
		setJMenuBar(menuBar);
	}
	
	private void configImagemFundo() {
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUNDHOME);
		add(background);
	}
	
	private void configBotoes() {
		btnListarCorridas = FabricaJButton.criarJButton("Listar Corridas", 150, 220, 560, 230,
				new Color(28, 28, 20), new Color(179, 177, 177), 28);
		
		btnComprarCreditos = FabricaJButton.criarJButton("Comprar Créditos", 150, 490, 560, 230,
				new Color(28, 28, 20), new Color(179, 177, 177), 28);
		
		background.add(btnListarCorridas);
		background.add(btnComprarCreditos);
	}
	
	public static void main(String[] args) {
		new TelaHomeMototaxista();
	}

	public JMenu getEditar() {
		return editar;
	}

	public JMenu getDeletar() {
		return deletar;
	}

	public JButton getBtnListarCorridas() {
		return btnListarCorridas;
	}

	public JButton getBtnComprarCreditos() {
		return btnComprarCreditos;
	}
	
}
