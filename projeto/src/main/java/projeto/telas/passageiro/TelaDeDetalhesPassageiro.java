package projeto.telas.passageiro;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoBranco;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.modelo.Corrida;
import projeto.modelo.enuns.AndamentoDaCorrida;
import projeto.telas.passageiro.ouvintes.OuvinteTelaDeDetalhesDoPassageiro;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJFormatted;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.fabricas.FabricaJTextArea;
import utilidades.imagens.Imagens;

public class TelaDeDetalhesPassageiro extends TelaPadrao {
	private JButton btnSeta;
	private JButton btnBloquearMototaxi;
	private ImagemDeFundo background;
	private JTextField txtData;
	private JFormattedTextField txtHora;
	private Corrida corrida;
	private JTextField txtNomeDoPassageiro;
	private JTextField txtPontoDeEncontro;
	private JTextField txtLocalDeDestino;
	private JTextField txtEmailDoMotoTaxi;
	private JTextField txtAvaliacao;
	private JTextArea txtComentario;

	public TelaDeDetalhesPassageiro(Corrida corrida) {
		super("Detalhes do passageiro");
		this.corrida = corrida;
		txtNomeDoPassageiro.setText(corrida.getPassageiro().getNome());
		txtPontoDeEncontro.setText(corrida.getPontoDeEncontro());
		txtLocalDeDestino.setText(corrida.getLocalDeDestino());
		txtEmailDoMotoTaxi.setText(corrida.getEmailDoMototaxista());
		txtAvaliacao.setText("");
		txtComentario.setText("");
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configButton();

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

		JLabel lblEmailDoMotoTaxi = FabricaJLabel.criarJLabel("E-Mail do Moto Taxi", 20, 320, 460, 40, Color.white, 22);
		txtEmailDoMotoTaxi = FabricaJText.criarJTextField(20, 360, 340, 40, Color.white, Color.black, 16);
		txtEmailDoMotoTaxi.setVisible(false);
		lblEmailDoMotoTaxi.setVisible(false);

		JLabel lblAvaliacao = FabricaJLabel.criarJLabel("Avaliacao", 20, 60, 460, 40, Color.white, 22);
		lblAvaliacao.setVisible(false);
		txtAvaliacao = FabricaJText.criarJTextField(20, 100, 340, 40, Color.white, Color.black, 16);
		txtAvaliacao.setVisible(false);

		JLabel lblComentario = FabricaJLabel.criarJLabel("Comentario ", 20, 140, 460, 40, Color.white, 22);
		lblComentario.setVisible(false);
		txtComentario = FabricaJTextArea.criarJTextArea(20, 180, 340, 220, Color.white, Color.black);
		txtComentario.setVisible(false);
	
//		if (corrida.getAndamento().equals(AndamentoDaCorrida.FINALIZADA)) {
//			lblAvaliacao.setVisible(true);
//			txtAvaliacao.setVisible(true);
//			lblComentario.setVisible(true);
//			txtComentario.setVisible(true);
//		}

		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		btnSeta.addMouseListener(new OuvinteBotaoFundoBranco());
		btnSeta.addActionListener(ouvinte);

		btnBloquearMototaxi = FabricaJButton.criarJButton("Bloquear Mototaxi", 650, 640, 180, 50, new Color(28, 28, 20),
				new Color(179, 177, 177), 20);
		btnBloquearMototaxi.addMouseListener(new OuvinteBotaoFundoBranco());
		btnBloquearMototaxi.addActionListener(ouvinte);

		JButton btnSalvar = FabricaJButton.criarJButton("Salvar", 340, 640, 180, 50, new Color(28, 28, 20),
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

		menu.add(lblEmailDoMotoTaxi);
		menu.add(txtEmailDoMotoTaxi);

		menu2.add(lblAvaliacao);
		menu2.add(txtAvaliacao);

		menu2.add(lblComentario);
		menu2.add(txtComentario);

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
