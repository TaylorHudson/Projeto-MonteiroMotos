package projeto.telas.ADM;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import projeto.telas.ADM.ouvintes.OuvinteTelaDadosDosUsuarios;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;

public class TelaDadosDosUsuarios extends JFrame {
	private JLabel background;
	private JButton btnDetalhes;
	private JMenuItem itemPassageiro;
	private JMenuItem itemMotoTaxista;
	
	public TelaDadosDosUsuarios() {
		configurarTela();
		configImagemFundo();
		confiBotoes();
		configMenu();
		setVisible(true);
	}
	private void configurarTela() {
		setSize(900, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Dados dos Usuarios");
	}
	
	private void configImagemFundo() {
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUNDHOME);
		add(background);
	}
	
	private void confiBotoes() {
		btnDetalhes = FabricaJButton.criarJButton("Detalhes", 600, 630, 200, 40,
				new Color(28, 28, 20), new Color(179, 177, 177), 28);
		background.add(btnDetalhes);
	}
	
	private void configMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuOpcoes = new JMenu("Tipo do Usuario");
		itemPassageiro = new JMenuItem("Passageiro");
		itemMotoTaxista = new JMenuItem("Moto-Taxista");
		
		OuvinteTelaDadosDosUsuarios ouvinte = new OuvinteTelaDadosDosUsuarios(this);
		itemPassageiro.addActionListener(ouvinte);
		itemMotoTaxista.addActionListener(ouvinte);
		
		menuBar.add(menuOpcoes);
		menuOpcoes.add(itemPassageiro);
		menuOpcoes.add(itemMotoTaxista);
		setJMenuBar(menuBar);
		
		
	}
	
	
	public static void main(String[] args) {
		new TelaDadosDosUsuarios();
	}
}


