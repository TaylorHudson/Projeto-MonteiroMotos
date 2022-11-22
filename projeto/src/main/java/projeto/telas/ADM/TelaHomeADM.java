package projeto.telas.ADM;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import projeto.telas.ADM.ouvintes.OuviteTelaHomeADM;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;

public class TelaHomeADM  extends JFrame{
	private JMenuItem itemEditar;
	private JMenuItem itemListaDeCorridas;
	private JMenuItem itemDefinirValorDosCreditos;
	private JLabel background;
	private JButton btnDadosDosUsuarios;
	private JButton btnFinancas;
	
	public TelaHomeADM() {
		configurarTela();
		configImagemFundo();
		configMenu();
		confiBotoes();
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
		JMenu menuOpcoes = new JMenu("Opções");
		itemEditar = new JMenuItem("Editar Perfil");
		itemListaDeCorridas = new JMenuItem("Lista de Corridas");
		itemDefinirValorDosCreditos = new JMenuItem("Definir Valor dos Créditos");
		
		OuviteTelaHomeADM ouvinte = new OuviteTelaHomeADM(this);
		itemEditar.addActionListener(ouvinte);
		itemListaDeCorridas.addActionListener(ouvinte);
		itemDefinirValorDosCreditos.addActionListener(ouvinte);
		
		menuBar.add(menuOpcoes);
		menuOpcoes.add(itemEditar);
		menuOpcoes.add(itemListaDeCorridas);
		menuOpcoes.add(itemDefinirValorDosCreditos);
		setJMenuBar(menuBar);
	}
	private void configImagemFundo() {
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUNDHOME);
		add(background);
	}
	private void confiBotoes() {
		btnDadosDosUsuarios = FabricaJButton.criarJButton("Dados dos Usuarios", 150, 220, 300, 70,
				new Color(28, 28, 20), new Color(179, 177, 177), 28);
		btnFinancas = FabricaJButton.criarJButton("Finanças", 150, 490, 300, 70,
				new Color(28, 28, 20), new Color(179, 177, 177), 28);
		
		
		background.add(btnDadosDosUsuarios);
		background.add(btnFinancas);
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
	


