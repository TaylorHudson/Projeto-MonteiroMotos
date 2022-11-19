package projeto.telas.passageiro;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;

public class TelaListarCorridas extends JFrame {

	private JLabel background;
	private JMenuItem itemSair;
	private JMenuItem itemDeletar;
	private JMenuItem itemEditar;

	public TelaListarCorridas() {
		configImagemFundo();
		ConfigTela();
		configButton();
		setVisible(true);
	}

	public void ConfigTela() {
		setSize(900, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(background);
		setTitle("Listar Corridas");
	}

	public static void main(String[] args) {
		new TelaListarCorridas();
	}

	private void configImagemFundo() {
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUNDHOME);
		add(background);
	}

	private void configButton() {
		JButton btnOrdenar = FabricaJButton.criarJButton("Ordenar", 620, 180, 180, 50, new Color(28, 28, 20),
				new Color(179, 177, 177), 28);
		btnOrdenar.addMouseListener(null);
		JButton btnDetalhes = FabricaJButton.criarJButton("Detalhes", 50, 650, 180, 50, new Color(28, 28, 20),
				new Color(179, 177, 177), 28);
		btnDetalhes.addMouseListener(null);

		background.add(btnDetalhes);
		background.add(btnOrdenar);
	}

	public JMenuItem getItemSair() {
		return itemSair;
	}

}
