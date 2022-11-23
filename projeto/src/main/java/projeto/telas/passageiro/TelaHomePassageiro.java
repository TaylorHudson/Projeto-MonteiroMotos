package projeto.telas.passageiro;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import projeto.OuvinteBotaoPadrao;
import projeto.telas.passageiro.ouvintes.OuvinteTelaHomePassageiro;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;

public class TelaHomePassageiro extends JFrame {
	OuvinteTelaHomePassageiro ouvinte = new OuvinteTelaHomePassageiro(this);
	
	private JMenuItem itemEditar;
	private JMenuItem itemDeletar;
	private JMenuItem itemSair;
	private JButton btnListarCorrida;
	private JButton btnCadastrarCorrida;

	private JLabel background;

	public TelaHomePassageiro() {
		configImagemFundo();
		configMenu();
		configurarTela();
		configButton();
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
		
		JLabel menu = FabricaJLabel.criarJLabel(180, 160, 500, 450, Color.BLACK, 4);
		menu.setBackground(Color.BLACK);
	
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menuOpcoes = new JMenu("Opções");
		itemEditar = new JMenuItem("Editar Perfil");
		itemDeletar = new JMenuItem("Deletar Perfil");
		itemSair = new JMenuItem("Sair");

		itemDeletar.addActionListener(ouvinte);
		itemEditar.addActionListener(ouvinte);
		itemSair.addActionListener(ouvinte);


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
	private void configButton() {
		btnListarCorrida = FabricaJButton.criarJButton("Listar Corrida", 270, 190, 380, 240,
		new Color(28, 28, 20), new Color(179, 177, 177), 28);
		btnListarCorrida.addMouseListener(new OuvinteBotaoPadrao());
		btnListarCorrida.addActionListener(ouvinte);
		
		
		btnCadastrarCorrida = FabricaJButton.criarJButton("Cadastrar Corrida", 270, 440, 380, 240,
		new Color(28, 28, 20), new Color(179, 177, 177), 28);
		btnCadastrarCorrida.addMouseListener(new OuvinteBotaoPadrao());
		btnCadastrarCorrida.addActionListener(ouvinte);	

		background.add(btnCadastrarCorrida);
		background.add(btnListarCorrida);
	}
	public static void main(String[] args) {
		new TelaHomePassageiro();
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

	public JButton getBtnListarCorrida() {
		return btnListarCorrida;
	}

	public JButton getBtnCadastrarCorrida() {
		return btnCadastrarCorrida;
	}

}
