package projeto.telas.mototaxista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoBranco;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.mototaxista.ouvintes.OuvinteMenuTelaHome;
import projeto.telas.mototaxista.ouvintes.OuvinteTelaHomeMototaxista;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJPanel;

public class TelaHomeMototaxista extends TelaPadrao {

	private JMenuItem itemEditar;
	private JMenuItem itemDeletar;
	private JMenuItem itemSair;
	private JButton btnListarCorridas;
	private JButton btnComprarCreditos;
	private ImagemDeFundo background;

	public TelaHomeMototaxista() {
		super("Home");
		setVisible(true);
	}
	
	@Override
	public void configurarComponentes() {
		configImagemFundo();
		configMenu();
		configBotoes();
	}
	
	private void configImagemFundo() {
		background = super.configImagemDeFundo("home.jpg");
		add(background);
	}

	private void configBotoes() {
		OuvinteTelaHomeMototaxista ouvinte = new OuvinteTelaHomeMototaxista(this);
		OuvinteBotaoFundoBranco ouvinteBtn = new OuvinteBotaoFundoBranco();

		btnListarCorridas = FabricaJButton.criarJButton("Listar Corridas", 150, 220, 560, 230,
				new Color(28, 28, 20), Color.WHITE, 28);
		
		btnComprarCreditos = FabricaJButton.criarJButton("Comprar Creditos", 150, 490, 560, 230,
				new Color(28, 28, 20), Color.WHITE, 28);

		btnListarCorridas.addActionListener(ouvinte);
		btnListarCorridas.addMouseListener(ouvinteBtn);
		btnComprarCreditos.addActionListener(ouvinte);
		btnComprarCreditos.addMouseListener(ouvinteBtn);
		
		background.add(btnListarCorridas);
		background.add(btnComprarCreditos);
	}
	
	private void configMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuOpcoes = new JMenu("Opcoes");
		itemEditar = new JMenuItem("Editar Perfil");
		itemDeletar = new JMenuItem("Deletar Perfil");
		itemSair = new JMenuItem("Sair");
		
		OuvinteMenuTelaHome ouvinteMenu = new OuvinteMenuTelaHome(this);
		OuvinteBotaoFundoPreto ouvinteBotaoPadrao = new OuvinteBotaoFundoPreto();

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
