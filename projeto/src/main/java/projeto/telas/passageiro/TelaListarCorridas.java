package projeto.telas.passageiro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.passageiro.ouvintes.OuvinteTelaListarCorrida;
import utilidades.fabricas.FabricaJButton;
import utilidades.imagens.Imagens;

public class TelaListarCorridas extends TelaPadrao {

	private ImagemDeFundo background;
	private JTable tabelaCorridas;
	private JButton btnOrdenar;
	private JButton btnDetalhes;
	private DefaultTableModel modelo;
	private JButton btnSeta;

	public TelaListarCorridas() {
		super("Listar Corridas");
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configButton();
		configTabelaCorridas();

	}

	private void configImagemFundo() {
		background = super.configImagemDeFundo("background_2.jpg");
		add(background);
	}

	private void configButton() {
		OuvinteTelaListarCorrida ouvinte = new OuvinteTelaListarCorrida(this);

		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		btnSeta.addMouseListener(new OuvinteBotaoFundoPreto());
		btnSeta.addActionListener(ouvinte);

		btnOrdenar = FabricaJButton.criarJButton("Ordenar", 660, 180, 180, 50, new Color(28, 28, 20),
				new Color(179, 177, 177), 28);
		btnOrdenar.addActionListener(ouvinte);
		btnDetalhes = FabricaJButton.criarJButton("Detalhes", 50, 650, 180, 50, new Color(28, 28, 20),
				new Color(179, 177, 177), 28);
		btnDetalhes.addActionListener(ouvinte);

		background.add(btnDetalhes);
		background.add(btnOrdenar);
	}

	private class OuvinteFiltro implements KeyListener {

		public void keyTyped(KeyEvent e) {

		}

		public void keyPressed(KeyEvent e) {

		}

		public void keyReleased(KeyEvent e) {

		}

	}

	private void configTabelaCorridas() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "NOME", "PONTO DE ENCONTRO", "STATUS", "DATA",  });
		tabelaCorridas = new JTable(modelo);
		tabelaCorridas.setFont(new Font("Arial", 1, 15));

		JScrollPane scrol = new JScrollPane(tabelaCorridas);
		scrol.getViewport().setBackground(new Color(124, 68, 2));
		scrol.setBounds(2, 240, 885, 400);

		background.add(scrol);
		background.add(btnSeta);
	}

	public DefaultTableModel getModelo() {
		return modelo;
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

	public JButton getBtnSeta() {
		return btnSeta;
	}

}
