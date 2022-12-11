package projeto.telas.mototaxista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoBranco;
import projeto.TelaPadrao;
import projeto.excecoes.usuario.DataInvalidaException;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.modelo.Corrida;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.modelo.enuns.AndamentoDaCorrida;
import projeto.modelo.enuns.StatusDaCorrida;
import projeto.repositorio.CentralDeInformacoes;
import projeto.servico.ServicoData;
import projeto.servico.ServicoMototaxista;
import projeto.telas.mototaxista.ouvintes.OuvinteBotoesTelaListarCorridas;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;
import utilidades.persistencia.Persistencia;

public class TelaListarCorridasMototaxi extends TelaPadrao {

	private JTable tabelaCorridas;
	private JButton btnOrdenar;
	private JButton btnReivindicarCorrida;
	private JButton btnSeta;
	private ImagemDeFundo background;
	private DefaultTableModel modelo;
	private JScrollPane scrol;
	private CentralDeInformacoes central;
	private Persistencia persistencia = new Persistencia();
	private JTextField txtFiltro;
	private JButton btnDetalhes;

	public TelaListarCorridasMototaxi() {
		super("Tela de listagem de corridas");
		central = persistencia.recuperarCentral("central");
		setVisible(true);
	}

	@Override
	public void configurarComponentes() {
		configImagemFundo();
		configTabela();
		popularTabela();
		configSeta();
	}

	private void popularTabela() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		ServicoMototaxista servico = new ServicoMototaxista(central);
		ArrayList<Corrida> corridasPermitidas = new ArrayList<Corrida>();

		for (Corrida c : central.getCorridas()) {
				try {
					Passageiro passageiro = central.recuperarPassageiroPeloEmail(c.getPassageiro().getEmail());
					boolean bloqueado = servico.estaBloqueado(passageiro);
					if(!bloqueado) corridasPermitidas.add(c);
				} catch (UsuarioNaoExisteException e) {}
		}
		
		for(Corrida c: corridasPermitidas) {
			if (c.getAndamento() != AndamentoDaCorrida.FINALIZADA) addLinha(modelo, c);
		}

		scrol.repaint();
	}

	public void addLinha(DefaultTableModel modelo, Corrida corrida) {
		Object[] linha = new Object[4];
		linha[0] = corrida.getPassageiro().getEmail();
		linha[1] = (corrida.getStatus() == StatusDaCorrida.PARAAGORA) ? "Para Agora" : "Para Depois";
		try {
			linha[2] = ServicoData.retornarString(corrida.getData());
		} catch (DataInvalidaException e) {
		}
		linha[3] = corrida.getId();

		modelo.addRow(linha);
	}

	private class OuvinteFiltro implements KeyListener {

		public void keyTyped(KeyEvent e) {
			String filtro = txtFiltro.getText();
			char var = e.getKeyChar();
			if (Character.isAlphabetic(var) || Character.isDigit(var)) {
				filtro += var;
			} else if (Character.isWhitespace(var)) {
				e.consume();
				return;
			}
			System.out.println(filtro);

			modelo.setRowCount(0);
			for (Corrida c : central.getCorridas()) {
				if (c.getPassageiro().getEmail().contains(filtro))
					addLinha(modelo, c);
			}
			scrol.repaint();
		}

		public void keyPressed(KeyEvent e) {

		}

		public void keyReleased(KeyEvent e) {

		}

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

		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "EMAIL DO PASSAGEIRO", "STATUS", "DATA", "ID" });
		tabelaCorridas = new JTable(modelo);
		tabelaCorridas.setFont(new Font("Arial", 1, 15));

		scrol = new JScrollPane(tabelaCorridas);
		scrol.getViewport().setBackground(new Color(124, 68, 2));
		scrol.setBounds(2, 240, 885, 400);

		btnOrdenar = FabricaJButton.criarJButton("Ordenar", 660, 180, 180, 50, new Color(28, 28, 20), Color.WHITE, 28);
		btnOrdenar.addActionListener(ouvinte);
		btnOrdenar.addMouseListener(ouvinteBtn);

		btnReivindicarCorrida = FabricaJButton.criarJButton("Reivindicar Corrida", 50, 670, 280, 50,
				new Color(28, 28, 20), Color.WHITE, 28);
		btnReivindicarCorrida.addActionListener(ouvinte);
		btnReivindicarCorrida.addMouseListener(ouvinteBtn);

		btnDetalhes = FabricaJButton.criarJButton("Detalhes", 550, 670, 280, 50, new Color(28, 28, 20), Color.WHITE,
				28);
		btnDetalhes.addActionListener(ouvinte);
		btnDetalhes.addMouseListener(ouvinteBtn);

		txtFiltro = FabricaJText.criarJTextField(50, 185, 350, 47, Color.BLACK, Color.WHITE, 23);
		txtFiltro.addKeyListener(new OuvinteFiltro());

		background.add(scrol);
		background.add(btnOrdenar);
		background.add(btnReivindicarCorrida);
		background.add(txtFiltro);
		background.add(btnDetalhes);
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

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public JScrollPane getScrol() {
		return scrol;
	}

	public JTextField getTxtFiltro() {
		return txtFiltro;
	}

	public JButton getBtnDetalhes() {
		return btnDetalhes;
	}
}
