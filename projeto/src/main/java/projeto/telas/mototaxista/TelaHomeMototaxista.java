package projeto.telas.mototaxista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import projeto.OuvinteBotaoPadrao;
import projeto.telas.mototaxista.ouvintes.OuvinteMenuTelaHome;
import projeto.telas.mototaxista.ouvintes.OuvinteTelaHomeMototaxista;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;

public class TelaHomeMototaxista extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JMenuItem itemEditar;
	private JMenuItem itemDeletar;
	private JMenuItem itemSair;
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
	
	private void configBotoes() {
		OuvinteTelaHomeMototaxista ouvinte = new OuvinteTelaHomeMototaxista(this);

		btnListarCorridas = FabricaJButton.criarJButton("Listar Corridas", 150, 220, 560, 230,
				new Color(28, 28, 20), new Color(179, 177, 177), 28);
		
		btnComprarCreditos = FabricaJButton.criarJButton("Comprar Créditos", 150, 490, 560, 230,
				new Color(28, 28, 20), new Color(179, 177, 177), 28);

		btnListarCorridas.addActionListener(ouvinte);
		btnComprarCreditos.addActionListener(ouvinte);
		
		background.add(btnListarCorridas);
		background.add(btnComprarCreditos);
	}
	
	private void configMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuOpcoes = new JMenu("Opções");
		itemEditar = new JMenuItem("Editar Perfil");
		itemDeletar = new JMenuItem("Deletar Perfil");
		itemSair = new JMenuItem("Sair");
		
		OuvinteMenuTelaHome ouvinteMenu = new OuvinteMenuTelaHome(this);
		OuvinteBotaoPadrao ouvinteBotaoPadrao = new OuvinteBotaoPadrao();

		itemEditar.addActionListener(ouvinteMenu);
		itemEditar.addMouseListener(ouvinteBotaoPadrao);
		itemDeletar.addActionListener(ouvinteMenu);
		itemDeletar.addMouseListener(ouvinteBotaoPadrao);
		itemSair.addActionListener(ouvinteMenu);
		itemSair.addMouseListener(ouvinteBotaoPadrao);
		
		menuBar.add(menuOpcoes);
		menuOpcoes.add(itemEditar);
		menuOpcoes.add(itemDeletar);
		menuOpcoes.add(itemSair);
		setJMenuBar(menuBar);
	}
	
	private void configImagemFundo() {
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUNDHOME);
		add(background);
	}
	
	public static void main(String[] args) {
		new TelaHomeMototaxista();
	}

	public JButton getBtnListarCorridas() {
		return btnListarCorridas;
	}

	public JButton getBtnComprarCreditos() {
		return btnComprarCreditos;
	}

	public JMenuItem getItemEditar() {
		return itemEditar;
	}

	public JMenuItem getItemDeletar() {
		return itemDeletar;
	}

	public JMenuItem getItemSair() {
		return itemSair;
	}

}
