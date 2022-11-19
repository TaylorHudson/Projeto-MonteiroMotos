package projeto.telas.passageiro;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto.telas.passageiro.ouvintes.OuvinteTelaListarCorrida;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;

public class TelaListarCorridas extends JFrame {

	private JLabel background;
	private JTable tabelaCorridas;
	private JButton btnOrdenar;
	private JButton btnDetalhes;

	public TelaListarCorridas() {
		configImagemFundo();
		ConfigTela();
		configButton();
		configTabelaCorridas();
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

	private void configImagemFundo() {
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUNDHOME);
		add(background);
	}

	private void configButton() {
		OuvinteTelaListarCorrida ouvinte = new OuvinteTelaListarCorrida(this);

		btnOrdenar = FabricaJButton.criarJButton("Ordenar", 660, 180, 180, 50, new Color(28, 28, 20),
				new Color(179, 177, 177), 28);
		btnOrdenar.addActionListener(ouvinte);
		btnDetalhes = FabricaJButton.criarJButton("Detalhes", 50, 650, 180, 50, new Color(28, 28, 20),
				new Color(179, 177, 177), 28);
		btnDetalhes.addActionListener(ouvinte);

		background.add(btnDetalhes);
		background.add(btnOrdenar);
	}

	private void configTabelaCorridas() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "NOME", "STATUS", "DATA", "HORA" });
		tabelaCorridas = new JTable(modelo);
		tabelaCorridas.setFont(new Font("Arial", 1, 15));

		JScrollPane scrol = new JScrollPane(tabelaCorridas);
		scrol.getViewport().setBackground(new Color(124, 68, 2));
		scrol.setBounds(2, 240, 885, 400);

		background.add(scrol);
	}
	public JButton getBtnOrdenar() {
		return btnOrdenar;
	}
	public JButton getBtnDetalhes() {
		return btnDetalhes;
	}
	public static void main(String[] args) {
		new TelaListarCorridas();
	}
}
