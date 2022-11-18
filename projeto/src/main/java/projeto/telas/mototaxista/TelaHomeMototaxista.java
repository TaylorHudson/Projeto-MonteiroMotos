package projeto.telas.mototaxista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import utilidades.fabricas.FabricaJButton;
import utilidades.imagens.Imagens;

public class TelaHomeMototaxista extends JFrame{

	private JMenu editar;
	private JMenu deletar;
	private JButton btnListarCorridas;
	private JButton btnComprarCreditos;

	public TelaHomeMototaxista(){
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
	
	private void configBotoes() {
		btnListarCorridas = FabricaJButton.criarJButton("Listar Corridas",Imagens.MOTOTAXISTA, 150, 20, 560, 380);
		btnComprarCreditos = new JButton();
		
		add(btnListarCorridas);
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
