package projeto.telas.mototaxista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoBranco;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.mototaxista.ouvintes.OuvinteBotoesTelaListarCorridas;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;

import java.awt.Font;
import java.awt.Color;

public class TelaListarCorridas extends TelaPadrao {

	private JTable tabelaCorridas;
	private JButton btnOrdenar;
	private JButton btnReivindicarCorrida;
	private JButton btnSeta;
	private ImagemDeFundo background;

	public TelaListarCorridas() {
		super("Tela de listagem de corridas");
		setVisible(true);
	}

	@Override
	public void configurarComponentes() {
		configImagemFundo();
		configTabela();
		configSeta();
	}
	
	private void configImagemFundo() {
		background = super.configImagemDeFundo("home.jpg");
		add(background);
	}
	
	private void configSeta() {
		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		btnSeta.addMouseListener(new OuvinteBotaoFundoBranco());
		btnSeta.addActionListener(new OuvinteBotoesTelaListarCorridas(this));
		background.add(btnSeta);
	}

	private void configTabela() {
		OuvinteBotoesTelaListarCorridas ouvinte = new OuvinteBotoesTelaListarCorridas(this);
		OuvinteBotaoFundoBranco ouvinteBtn = new OuvinteBotaoFundoBranco();
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "EMAIL DO PASSAGEIRO", "STATUS", "DATA", "HORA" });
		tabelaCorridas = new JTable(modelo);
		tabelaCorridas.setFont(new Font("Arial", 1, 15));

		JScrollPane scrol = new JScrollPane(tabelaCorridas);
		scrol.getViewport().setBackground(new Color(124, 68, 2));
		scrol.setBounds(2, 240, 885, 400);

		btnOrdenar = FabricaJButton.criarJButton("Ordenar", 660, 180, 180, 50, new Color(28, 28, 20), Color.WHITE, 28);
		btnOrdenar.addActionListener(ouvinte);
		btnOrdenar.addMouseListener(ouvinteBtn);

		btnReivindicarCorrida = FabricaJButton.criarJButton("Reivindicar Corrida", 50, 670, 280, 50,
				new Color(28, 28, 20), Color.WHITE, 28);
		btnReivindicarCorrida.addActionListener(ouvinte);
		btnReivindicarCorrida.addMouseListener(ouvinteBtn);

		background.add(scrol);
		background.add(btnOrdenar);
		background.add(btnReivindicarCorrida);
	}

	public static void main(String[] args) {
		new TelaListarCorridas();
	}

	public JTable getTabelaCorridas() {
		return tabelaCorridas;
	}

	public JButton getBtnOrdenar() {
		return btnOrdenar;
	}

	public JButton getBtnReivindicarCorrida() {
		return btnReivindicarCorrida;
	}

	public JButton getBtnSeta() {
		return btnSeta;
	}

}
