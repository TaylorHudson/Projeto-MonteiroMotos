package projeto.telas.passageiro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoBranco;
import projeto.TelaPadrao;
import projeto.modelo.Corrida;
import projeto.modelo.enuns.AndamentoDaCorrida;
import projeto.repositorio.CentralDeInformacoes;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJFormatted;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.fabricas.FabricaJText;
import utilidades.fabricas.FabricaJTextArea;
import utilidades.imagens.Imagens;
import utilidades.persistencia.Persistencia;

public class TelaDeDetalhesPassageiro extends TelaPadrao {

	private JButton btnSeta;
	private JButton btnBloquearMototaxi;
	private ImagemDeFundo background;
	private Corrida corrida;
	private JTextField txtNomeDoPassageiro;
	private JTextField txtPontoDeEncontro;
	private JTextField txtLocalDeDestino;
	private JTextField txtEmailDoMotoTaxi;
	private JFormattedTextField txtAvaliacao;
	private JTextArea txtComentario;
	private JLabel lblAvaliacao;
	private JLabel lblComentario;
	private JLabel lblEmailDoMotoTaxi;
	private JButton btnSalvar;

	public TelaDeDetalhesPassageiro(Corrida corrida) {
		super("Detalhes do passageiro");
		this.corrida = corrida;
		txtNomeDoPassageiro.setText(corrida.getPassageiro().getNome());
		txtPontoDeEncontro.setText(corrida.getPontoDeEncontro());
		txtLocalDeDestino.setText(corrida.getLocalDeDestino());
		txtEmailDoMotoTaxi.setText(corrida.getEmailDoMototaxista());

//		a avaliação esta começando de zero devido o valueOf, ajeitar para o ususario só poder avaliar apenas uma unica vez
		txtAvaliacao.setText(String.valueOf(corrida.getAvaliacao()));
		txtComentario.setText(corrida.getComentario());
		verificarCorridaFinalizada();
		setVisible(true);
	}

	public void verificarCorridaFinalizada() {
		if (corrida.getAndamento() == AndamentoDaCorrida.FINALIZADA) {
			txtEmailDoMotoTaxi.setText(corrida.getEmailDoMototaxista());
			lblAvaliacao.setVisible(true);
			txtAvaliacao.setVisible(true);
			lblComentario.setVisible(true);
			txtComentario.setVisible(true);
			lblEmailDoMotoTaxi.setVisible(true);
			txtEmailDoMotoTaxi.setVisible(true);
		}

	}

	public class OuvinteTelaDeDetalhesDoPassageiro implements ActionListener {

		private TelaDeDetalhesPassageiro tela;
		private Persistencia persistencia = new Persistencia();
		private CentralDeInformacoes central = persistencia.recuperarCentral("central");

		public OuvinteTelaDeDetalhesDoPassageiro(TelaDeDetalhesPassageiro tela) {
			this.tela = tela;

		}

		public void actionPerformed(ActionEvent e) {
			Corrida c = central.recuperarCorridaPeloId(corrida.getId());
			JButton item = (JButton) e.getSource();

			if (item == tela.getBtnSeta()) {
				if (corrida.getAndamento() == AndamentoDaCorrida.FINALIZADA) {
					if (tela.verificarSeAvaliou()) {
						tela.dispose();
						new TelaListarCorridas();
					}
				} else if (corrida.getAndamento() == AndamentoDaCorrida.ESPERA) {

					tela.dispose();
					new TelaListarCorridas();
				}

			} else if (item == tela.getBtnSalvar()) {

				if (corrida.getAndamento() == AndamentoDaCorrida.ESPERA) {

				} else if (corrida.getAndamento() == AndamentoDaCorrida.FINALIZADA) {
					if (tela.verificarSeAvaliou()) {
						if (!txtAvaliacao.getText().equals("")) {
							int avaliacao = Integer.parseInt(txtAvaliacao.getText());
							c.setAvaliacao(avaliacao);
							c.setComentario(txtComentario.getText());
							persistencia.salvarCentral(central, "central");
							tela.dispose();
							new TelaListarCorridas();
							tela.verificarSeAvaliou();
						} else {
							txtAvaliacao.setEditable(false);
							txtComentario.setEditable(false);
							FabricaJOptionPane.criarMsgAtencao("Você ja avaliou essa corrida");
						}
					}
				}
			}
		}
	}

	public void configurarComponentes() {
		configImagemFundo();
		configButton();

	}

	public boolean verificarSeAvaliou() {

		if (!txtAvaliacao.getText().isBlank()) {
			int avaliacaoN = Integer.parseInt(txtAvaliacao.getText());
			if (avaliacaoN >= 1 && avaliacaoN < 6) {
				if (avaliacaoN < 3)
					btnBloquearMototaxi.setVisible(true);
				return true;
			} else
				FabricaJOptionPane.criarMsgErro("A nota deve ser entre 1 e 5");

		} else
			FabricaJOptionPane.criarMsgErro("Você Deve passar uma Avaliação");
		return false;
	}

	private void configImagemFundo() {
		background = super.configImagemDeFundo("background_2.jpg");
		add(background);
	}

	private void configButton() {
		OuvinteTelaDeDetalhesDoPassageiro ouvinte = new OuvinteTelaDeDetalhesDoPassageiro(this);

		JLabel menu = FabricaJLabel.criarJLabel(10, 70, 400, 550, Color.BLACK, 4);
		menu.setBackground(Color.BLACK);

		JLabel menu2 = FabricaJLabel.criarJLabel(450, 70, 400, 550, Color.black, 4);
		menu2.setBackground(Color.BLACK);

		JLabel lblNomeDoPassaeiro = FabricaJLabel.criarJLabel("Nome do passageiro", 20, 60, 460, 40, Color.white, 22);

		txtNomeDoPassageiro = FabricaJText.criarJTextField(20, 100, 340, 40, Color.white, Color.black, 16);

		JLabel lblPontoDeEncontro = FabricaJLabel.criarJLabel("Ponto de encontro", 20, 140, 460, 40, Color.white, 22);

		txtPontoDeEncontro = FabricaJText.criarJTextField(20, 180, 340, 40, Color.white, Color.black, 16);

		JLabel lblLocalDeDestino = FabricaJLabel.criarJLabel("Local de destino", 20, 230, 460, 40, Color.white, 22);

		txtLocalDeDestino = FabricaJText.criarJTextField(20, 270, 340, 40, Color.white, Color.black, 16);

		JLabel lblDataNascimento = FabricaJLabel.criarJLabel("Data de Nascimento", 20, 315, 360, 40, Color.white, 25);

		// adicionando os argumentos do menu2

		lblEmailDoMotoTaxi = FabricaJLabel.criarJLabel("E-Mail do Moto Taxi", 20, 410, 460, 40, Color.white, 22);
		txtEmailDoMotoTaxi = FabricaJText.criarJTextField(20, 448, 340, 40, Color.white, Color.black, 16);
		txtEmailDoMotoTaxi.setVisible(false);
		lblEmailDoMotoTaxi.setVisible(false);

		lblAvaliacao = FabricaJLabel.criarJLabel("Avaliacao", 20, 60, 460, 40, Color.white, 22);
		lblAvaliacao.setVisible(false);
		try {
			txtAvaliacao = FabricaJFormatted.criarJFormatted(20, 100, 340, 40, new MaskFormatter("#"));
		} catch (ParseException e) {
		}

		txtAvaliacao.setVisible(false);

		lblComentario = FabricaJLabel.criarJLabel("Comentario ", 20, 140, 460, 40, Color.white, 22);
		lblComentario.setVisible(false);
		txtComentario = FabricaJTextArea.criarJTextArea(20, 180, 340, 220, Color.white, Color.black);
		txtComentario.setVisible(false);

		btnBloquearMototaxi = FabricaJButton.criarJButton("Bloquear Mototaxi", 650, 640, 180, 50, new Color(28, 28, 20),
				new Color(179, 177, 177), 20);
		btnBloquearMototaxi.addMouseListener(new OuvinteBotaoFundoBranco());
		btnBloquearMototaxi.addActionListener(ouvinte);
		btnBloquearMototaxi.setVisible(false);

		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		btnSeta.addMouseListener(new OuvinteBotaoFundoBranco());
		btnSeta.addActionListener(ouvinte);

		btnSalvar = FabricaJButton.criarJButton("Salvar", 340, 640, 180, 50, new Color(28, 28, 20),
				new Color(179, 177, 177), 20);
		btnSalvar.addMouseListener(new OuvinteBotaoFundoBranco());
		btnSalvar.addActionListener(ouvinte);

		background.add(menu);
		background.add(btnSeta);
		background.add(btnBloquearMototaxi);
		background.add(btnSalvar);

		menu.add(lblNomeDoPassaeiro);
		menu.add(txtNomeDoPassageiro);

		menu.add(lblPontoDeEncontro);
		menu.add(txtPontoDeEncontro);

		menu.add(lblLocalDeDestino);
		menu.add(txtLocalDeDestino);

		background.add(menu2);

		menu2.add(lblEmailDoMotoTaxi);
		menu2.add(txtEmailDoMotoTaxi);

		menu2.add(lblAvaliacao);
		menu2.add(txtAvaliacao);

		menu2.add(lblComentario);
		menu2.add(txtComentario);

	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public JButton getBtnSeta() {
		return btnSeta;
	}

	public void setBtnSeta(JButton btnSeta) {
		this.btnSeta = btnSeta;
	}

	public JButton getBtnBloquearMototaxi() {
		return btnBloquearMototaxi;
	}

	public void setBtnBloquearMototaxi(JButton btnBloquearMototaxi) {
		this.btnBloquearMototaxi = btnBloquearMototaxi;
	}

}
