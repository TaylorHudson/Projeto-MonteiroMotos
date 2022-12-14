package projeto.telas.mototaxista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoBranco;
import projeto.TelaPadrao;
import projeto.excecoes.usuario.DataInvalidaException;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.excecoes.usuario.VerificacaoDeCorridaException;
import projeto.modelo.Corrida;
import projeto.modelo.Mototaxista;
import projeto.modelo.enuns.AndamentoDaCorrida;
import projeto.repositorio.CentralDeInformacoes;
import projeto.servico.ServicoData;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJCheckBox;
import utilidades.fabricas.FabricaJFormatted;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;
import utilidades.persistencia.Persistencia;

public class TelaReivindicarCorrida extends TelaPadrao {

	private JTextField txtDestino;
	private JTextField txtEncontro;
	private JTextField txtEmailPassageiro;
	private JFormattedTextField txtData;
	private JFormattedTextField txtHora;
	private JTextField txtComplemento;
	private JCheckBox cbConcluido;
	private JButton btnSeta;
	private ImagemDeFundo background;
	private JButton btnConcluir;
	private Corrida corrida;

	public TelaReivindicarCorrida(Corrida corrida) {
		super("Reivindicar corrida");
		this.corrida = corrida;
		txtDestino.setText(corrida.getLocalDeDestino());
		txtEncontro.setText(corrida.getPontoDeEncontro());
		try {
			txtData.setText(ServicoData.retornarString(corrida.getData()));
		} catch (DataInvalidaException e) {
		}
		txtEmailPassageiro.setText(corrida.getPassageiro().getEmail());
		txtHora.setText(corrida.getHora());
		txtComplemento.setText(corrida.getComplemento());
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configLabel();
		configTextField();
		configBotao();
	}

	public void ocultarCampos() {
		cbConcluido.setVisible(false);
		btnConcluir.setVisible(false);
	}

	private void configTextField() {
		txtDestino = FabricaJText.criarJTextField(50, 85, 300, 50, Color.WHITE, Color.BLACK, 20);
		txtEncontro = FabricaJText.criarJTextField(50, 285, 300, 50, Color.WHITE, Color.BLACK, 20);
		txtEmailPassageiro = FabricaJText.criarJTextField(50, 485, 300, 50, Color.WHITE, Color.BLACK, 20);

		try {
			txtData = FabricaJFormatted.criarJFormatted(550, 85, 300, 50, new MaskFormatter("##/##/####"));
			txtHora = FabricaJFormatted.criarJFormatted(550, 285, 300, 50, new MaskFormatter("##:##"));
		} catch (ParseException e) {
		}
		txtComplemento = FabricaJText.criarJTextField(550, 480, 300, 50, Color.WHITE, Color.BLACK, 20);

		txtDestino.setEditable(false);
		txtComplemento.setEditable(false);
		txtData.setEditable(false);
		txtEncontro.setEditable(false);
		txtEmailPassageiro.setEditable(false);
		txtHora.setEditable(false);

		background.add(txtDestino);
		background.add(txtEncontro);
		background.add(txtEmailPassageiro);
		background.add(txtData);
		background.add(txtHora);
		background.add(txtComplemento);
	}

	private void configImagemFundo() {
		background = super.configImagemDeFundo("background_2.jpg");
		add(background);
	}

	private void configBotao() {
		btnConcluir = FabricaJButton.criarJButton("Concluir", 300, 635, 250, 55, Color.BLACK, Color.WHITE, 30);
		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 5, 5, 50, 50);

		OuvinteBotaoFundoBranco ouvinteBotao = new OuvinteBotaoFundoBranco();

		btnSeta.addActionListener(new OuvinteTelaReivindicarCorrida(this));
		btnSeta.addMouseListener(ouvinteBotao);

		btnConcluir.addMouseListener(ouvinteBotao);
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persistencia p = new Persistencia();
				CentralDeInformacoes central = p.recuperarCentral("central");

				boolean selecionado = cbConcluido.isSelected();
				if (selecionado) {
					try {
						Corrida c = central.recuperarCorridaPeloId(corrida.getId());
						c.setAndamento(AndamentoDaCorrida.FINALIZADA);
						Mototaxista m = central.recuperarMototaxistaPeloEmail(TelaPadrao.mototaxistaLogado.getEmail());
						m.setCorridaReivindicada(null);
						p.salvarCentral(central, "central");
					} catch (UsuarioNaoExisteException | VerificacaoDeCorridaException e1) {
					}
				}
				dispose();
				new TelaListarCorridasMototaxi();
			}
		});

		background.add(btnConcluir);
		background.add(btnSeta);
	}

	private void configLabel() {
		JLabel lblDestino = FabricaJLabel.criarJLabel("Local de Destino", 50, 50, 200, 25, Color.WHITE, 25);
		JLabel lblEncontro = FabricaJLabel.criarJLabel("Ponto de Encontro", 50, 250, 230, 25, Color.WHITE, 25);
		JLabel lblEmailPassageiro = FabricaJLabel.criarJLabel("E-mail do Passageiro", 50, 450, 250, 25, Color.WHITE,
				25);
		JLabel lblData = FabricaJLabel.criarJLabel("Data", 550, 50, 250, 25, Color.WHITE, 25);
		JLabel lblHora = FabricaJLabel.criarJLabel("Hora", 550, 250, 250, 25, Color.WHITE, 25);
		JLabel lblComplemento = FabricaJLabel.criarJLabel("Complemento", 550, 450, 250, 25, Color.WHITE, 25);
		cbConcluido = FabricaJCheckBox.criarJCheckBox(700, 700, 150, 40, "Concluida", Color.BLACK, Color.WHITE);
		cbConcluido.setFont(new Font("Arial", Font.BOLD, 25));

		background.add(lblDestino);
		background.add(lblEncontro);
		background.add(lblEmailPassageiro);
		background.add(lblData);
		background.add(lblHora);
		background.add(cbConcluido);
		background.add(lblComplemento);
	}

	public class OuvinteTelaReivindicarCorrida implements ActionListener {

		private TelaReivindicarCorrida tela;

		public OuvinteTelaReivindicarCorrida(TelaReivindicarCorrida tela) {
			this.tela = tela;
		}

		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			if (btn == btnSeta) {
				tela.dispose();
				new TelaListarCorridasMototaxi();
			}
		}

	}

}
