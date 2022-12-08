package projeto.telas.passageiro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.modelo.Corrida;
import projeto.modelo.Passageiro;
import projeto.modelo.enuns.StatusDaCorrida;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.passageiro.ouvintes.OuvinteTelaListarCorrida;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;
import utilidades.persistencia.Persistencia;

public class TelaListarCorridas extends TelaPadrao {

	private ImagemDeFundo background;
	private JTable tabelaCorridas;
	private JButton btnOrdenar;
	private JButton btnDetalhes;
	private DefaultTableModel modelo;
	private JButton btnSeta;
	private JScrollPane scrol;
	private JTextField txtDados;
	private ArrayList<Corrida> corridasSendoExibidas;

	public TelaListarCorridas() {
		super("Listar Corridas");
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configButton();
		configTabelaCorridas();
		popularTabela();
	}

	private class OuvinteFiltro implements KeyListener {

		private TelaListarCorridas tela;
		private CentralDeInformacoes central;
		private Persistencia persistencia = new Persistencia();
		private ArrayList<Corrida> corridasSendoExibidas;

		public void keyTyped(KeyEvent e) {
			central = persistencia.recuperarCentral("central");
			corridasSendoExibidas = new ArrayList<Corrida>();

			String filtro = txtDados.getText();
			char var = e.getKeyChar();
			if (Character.isAlphabetic(var) || Character.isWhitespace(var)) {
				filtro += var;
			} else if (Character.isDigit(var)) {
				e.consume();
				return;
			}
			modelo.setRowCount(0);
			for (Corrida corrida : central.getCorridas()) {
				Passageiro passageiro = corrida.getPassageiro();
				if (corrida.getPontoDeEncontro().contains(filtro) && passageiro.equals(TelaPadrao.passageiroLogado)) {
					addLinha(modelo, corrida);

				}
			}
			scrol.repaint();
		}

		public void keyPressed(KeyEvent e) {

		}

		public void keyReleased(KeyEvent e) {

		}

	}

	private void addLinha(DefaultTableModel modelo, Corrida c) {

		Object[] linha = new Object[5];
		linha[0] = c.getPassageiro().getNome();
		linha[1] = c.getPontoDeEncontro();
		linha[2] = (c.getStatus() == StatusDaCorrida.PARAAGORA) ? "Para agora" : "Para depois";
		linha[3] = c.getData();
		linha[4] = c.getId();

		modelo.addRow(linha);
		scrol.repaint();

	}

	private void popularTabela() {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");

		for (Corrida c : central.getCorridas()) {
			if (c.getPassageiro().equals(TelaPadrao.passageiroLogado)) {
				addLinha(modelo, c);
			}
		}
	}

	private void configImagemFundo() {
		background = super.configImagemDeFundo("background_2.jpg");
		add(background);
	}

	private void configButton() {
		OuvinteTelaListarCorrida ouvinte = new OuvinteTelaListarCorrida(this);

		JLabel lblInfo = FabricaJLabel.criarJLabel("Pesquise", 30, 140, 460, 40, Color.white, 25);

		txtDados = FabricaJText.criarJTextField(20, 180, 460, 50, new Color(28, 28, 20), Color.white, 16);
		txtDados.addKeyListener(new OuvinteFiltro());
		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		btnSeta.addMouseListener(new OuvinteBotaoFundoPreto());
		btnSeta.addActionListener(ouvinte);

		btnDetalhes = FabricaJButton.criarJButton("Detalhes", 50, 650, 180, 50, new Color(28, 28, 20),
				new Color(179, 177, 177), 28);
		btnDetalhes.addMouseListener(new OuvinteBotaoFundoPreto());
		btnDetalhes.addActionListener(ouvinte);

		background.add(btnDetalhes);
		background.add(txtDados);
		background.add(lblInfo);
	}

	private void configTabelaCorridas() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "NOME", "PONTO DE ENCONTRO", "STATUS", "DATA", "ID" });
		tabelaCorridas = new JTable(modelo);
		tabelaCorridas.setFont(new Font("Arial", 1, 15));

		scrol = new JScrollPane(tabelaCorridas);
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

	public JTextField getTxtDados() {
		return txtDados;
	}

	public JTable getTabelaCorridas() {
		return tabelaCorridas;
	}

}
