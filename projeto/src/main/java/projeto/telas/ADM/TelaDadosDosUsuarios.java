package projeto.telas.ADM;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto.telas.ADM.ouvintes.OuvinteTelaDadosDosUsuarios;
import projeto.telas.mototaxista.ouvintes.OuvinteBotoesTelaListarCorridas;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;

public class TelaDadosDosUsuarios extends JFrame {

	OuvinteTelaDadosDosUsuarios ouvinte = new OuvinteTelaDadosDosUsuarios(this);

	private JTable tabelaUsuarios;
	private JLabel lblSeta;

	private JLabel background;
	private JButton btnDetalhes;
	private JMenuItem itemPassageiro;
	private JMenuItem itemMotoTaxista;

	public TelaDadosDosUsuarios() {
		configurarTela();
		configImagemFundo();
		confiBotoes();
		configMenu();
		configTabela();
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
		btnDetalhes = FabricaJButton.criarJButton("Detalhes", 600, 620, 200, 40, new Color(28, 28, 20), Color.white,
				28);
		background.add(btnDetalhes);
		btnDetalhes.addMouseListener(ouvinte);
	}

	private void configMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuOpcoes = new JMenu("Tipo do Usuario");
		itemPassageiro = new JMenuItem("Passageiro");
		itemMotoTaxista = new JMenuItem("Moto-Taxista");

		OuvinteTelaDadosDosUsuarios ouvinte = new OuvinteTelaDadosDosUsuarios(this);
		itemPassageiro.addMouseListener(ouvinte);
		itemMotoTaxista.addMouseListener(ouvinte);

		menuBar.add(menuOpcoes);
		menuOpcoes.add(itemPassageiro);
		menuOpcoes.add(itemMotoTaxista);
		setJMenuBar(menuBar);
	}
	private void configTabela() {

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "E-MAil", "Nome Completo", "Perfil Do Usuario" });
		tabelaUsuarios = new JTable(modelo);
		tabelaUsuarios.setFont(new Font("Arial", 1, 15));

		lblSeta = FabricaJLabel.criarJLabel(40, 20, 50, 50, Imagens.SETA);
		lblSeta.addMouseListener(ouvinte);

		JScrollPane scrol = new JScrollPane(tabelaUsuarios);
		scrol.getViewport().setBackground(new Color(124, 68, 2));
		scrol.setBounds(2, 200, 885, 400);

		background.add(scrol);
		background.add(lblSeta);
	}

	public static void main(String[] args) {
		new TelaDadosDosUsuarios();
	}
}
