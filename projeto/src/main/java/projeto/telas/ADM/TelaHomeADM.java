package projeto.telas.ADM;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.ADM.ouvintes.OuvinteMenuTelaHomeADM;
import projeto.telas.ADM.ouvintes.OuvinteTelaHomeADM;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;

public class TelaHomeADM  extends TelaPadrao{
	private JMenuItem itemEditar;
	private JMenuItem itemListaDeCorridas;
	private JMenuItem itemDefinirValorDosCreditos;
	private JMenuItem itemSair;
	private ImagemDeFundo imagem;
	private JButton btnDadosDosUsuarios;
	private JButton btnFinancas;
	
	public TelaHomeADM() {
		super("Home ADM");
		setVisible(true);
	}
	public void configurarComponentes() {
		configImagemDeFundo();
		confiBotoes();
		configMenu();
	}
	public void configImagemDeFundo() {
		imagem = super.configImagemDeFundo("home.jpg");
		add(imagem);
	}
	
	
	
	private void configMenu() {
		OuvinteMenuTelaHomeADM ouvinte = new OuvinteMenuTelaHomeADM(this);
		OuvinteBotaoFundoPreto mouse = new OuvinteBotaoFundoPreto();
		JMenuBar menuBar = new JMenuBar();
		JMenu menuOpcoes = new JMenu("Opções");
		itemEditar = new JMenuItem("Editar Perfil");
		itemListaDeCorridas = new JMenuItem("Lista de Corridas");
		itemDefinirValorDosCreditos = new JMenuItem("Definir Valor dos Créditos");
		itemSair = new JMenuItem("Sair");
		
		itemEditar.addActionListener(ouvinte);
		itemListaDeCorridas.addActionListener(ouvinte);
		itemDefinirValorDosCreditos.addActionListener(ouvinte);
		itemSair.addActionListener(ouvinte);
		
		itemDefinirValorDosCreditos.addMouseListener(mouse);
		itemEditar.addMouseListener(mouse);
		itemListaDeCorridas.addMouseListener(mouse);
		itemSair.addMouseListener(mouse);
		
		menuBar.add(menuOpcoes);
		menuOpcoes.add(itemEditar);
		menuOpcoes.add(itemListaDeCorridas);
		menuOpcoes.add(itemDefinirValorDosCreditos);
		menuOpcoes.add(itemSair);
		setJMenuBar(menuBar);
	}
	
	private void confiBotoes() {
		OuvinteTelaHomeADM ouvinte = new OuvinteTelaHomeADM(this);
		OuvinteBotaoFundoPreto mouse = new OuvinteBotaoFundoPreto();
		btnDadosDosUsuarios = FabricaJButton.criarJButton("Dados dos Usuarios", 150, 220, 300, 70,
				Color.white, Color.black, 28);
		btnFinancas = FabricaJButton.criarJButton("Finanças", 150, 490, 300, 70,
				Color.white,Color.black, 28);
		
		btnDadosDosUsuarios.addActionListener(ouvinte);
		btnFinancas.addActionListener(ouvinte);
		
		btnDadosDosUsuarios.addMouseListener(mouse);
		btnFinancas.addMouseListener(mouse);
		
		
		imagem.add(btnDadosDosUsuarios);
		imagem.add(btnFinancas);
	}
	public static void main(String[] args) {
		new TelaHomeADM();
		
	}
	public JMenuItem getItemEditar() {
		return itemEditar;
	}
	public JMenuItem getItemListaDeCorridas() {
		return itemListaDeCorridas;
	}
	public JMenuItem getItemDefinirValorDosCreditos() {
		return itemDefinirValorDosCreditos;
	}
	public JButton getBtnDadosDosUsuarios() {
		return btnDadosDosUsuarios;
	}
	public JButton getBtnFinancas() {
		return btnFinancas;
	}
	

}
	


