package projeto.telas.passageiro;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.passageiro.ouvintes.OuvinteDoMenuDaTelaHomePassageiro;
import projeto.telas.passageiro.ouvintes.OuvinteTelaHomePassageiro;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;

public class TelaHomePassageiro extends TelaPadrao {
	
	private JMenuItem itemEditar;
	private JMenuItem itemDeletar;
	private JMenuItem itemSair;
	private JButton btnListarCorrida;
	private JButton btnCadastrarCorrida;

	private ImagemDeFundo background;

	public TelaHomePassageiro() {
		super("Home");
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configMenu();
		configButton();
	}
	private void configMenu() {
		OuvinteDoMenuDaTelaHomePassageiro ouvinte = new OuvinteDoMenuDaTelaHomePassageiro(this);

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
		background = super.configImagemDeFundo("home.jpg");
		add(background);
	}

	private void configButton() {
		OuvinteTelaHomePassageiro ouvinte = new OuvinteTelaHomePassageiro(this);
		

		
		btnListarCorrida = FabricaJButton.criarJButton("Listar Corrida", 270, 190, 380, 240, new Color(28, 28, 20),
				new Color(179, 177, 177), 28);
		btnListarCorrida.addMouseListener(new OuvinteBotaoFundoPreto());
		btnListarCorrida.addActionListener(ouvinte);

		btnCadastrarCorrida = FabricaJButton.criarJButton("Cadastrar Corrida", 270, 440, 380, 240,
				new Color(28, 28, 20), new Color(179, 177, 177), 28);
		btnCadastrarCorrida.addMouseListener(new OuvinteBotaoFundoPreto());
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
