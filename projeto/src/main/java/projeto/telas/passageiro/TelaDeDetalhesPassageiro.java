package projeto.telas.passageiro;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
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

	public TelaDeDetalhesPassageiro() {
		super("Detalhes do passageiro");
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

		JTextField txtNomeDoPassageiro = FabricaJText.criarJTextField(20, 100, 340, 40, Color.white, Color.black, 16);

		JLabel lblPontoDeEncontro = FabricaJLabel.criarJLabel("Ponto de encontro", 20, 140, 460, 40, Color.white, 22);

		JTextField txtPontoDeEncontro = FabricaJText.criarJTextField(20, 180, 340, 40, Color.white, Color.black, 16);

		JLabel lblLocalDeDestino = FabricaJLabel.criarJLabel("Local de destino", 20, 230, 460, 40, Color.white, 22);

		JTextField txtLocalDeDestino = FabricaJText.criarJTextField(20, 270, 340, 40, Color.white, Color.black, 16);

		JLabel lblDataNascimento = FabricaJLabel.criarJLabel("Data de Nascimento", 20, 315, 360, 40, Color.white, 25);
		try {
			txtData = FabricaJFormatted.criarJFormatted(20, 350, 340, 40, new MaskFormatter("##/##/####"));
		} catch (Exception e) {
		}
		JLabel lblHora = FabricaJLabel.criarJLabel("Hora", 20, 410, 460, 40, Color.white, 22);
		try {
			txtHora = FabricaJFormatted.criarJFormatted(20, 450, 60, 30, new MaskFormatter("##:##"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// adicionando os argumentos do menu2

		JLabel lblEmailDoMotoTaxi = FabricaJLabel.criarJLabel("E-Mail do Moto Taxi", 20, 60, 460, 40, Color.white, 22);

		JTextField txtEmailDoMotoTaxi = FabricaJText.criarJTextField(20, 100, 340, 40, Color.white, Color.black, 16);

		JLabel lblAvaliacao = FabricaJLabel.criarJLabel("Avaliacao", 20, 140, 460, 40, Color.white, 22);

		JTextField txtAvaliacao = FabricaJText.criarJTextField(20, 180, 340, 40, Color.white, Color.black, 16);

		JLabel lblComentario = FabricaJLabel.criarJLabel("Comentario ", 20, 230, 460, 40, Color.white, 22);

		JTextArea txtComentario = FabricaJTextArea.criarJTextArea(20, 270, 340, 200, Color.white, Color.black);

		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		btnSeta.addMouseListener(new OuvinteBotaoFundoPreto());
		btnSeta.addActionListener(ouvinte);

		btnBloquearMototaxi = FabricaJButton.criarJButton("Bloquear Mototaxi", 650, 640, 180, 50, new Color(28, 28, 20),
				new Color(179, 177, 177), 20);
		btnBloquearMototaxi.addMouseListener(new OuvinteBotaoFundoPreto());
		btnBloquearMototaxi.addActionListener(ouvinte);

		background.add(menu);
		background.add(btnSeta);
		background.add(btnBloquearMototaxi);

		menu.add(lblNomeDoPassaeiro);
		menu.add(txtNomeDoPassageiro);

		menu.add(lblPontoDeEncontro);
		menu.add(txtPontoDeEncontro);

		menu.add(lblLocalDeDestino);
		menu.add(txtLocalDeDestino);

		menu.add(lblDataNascimento);
		menu.add(txtData);
		menu.add(lblHora);
		menu.add(txtHora);

		background.add(menu2);

		menu2.add(lblEmailDoMotoTaxi);
		menu2.add(txtEmailDoMotoTaxi);

		menu2.add(lblAvaliacao);
		menu2.add(txtAvaliacao);

		menu2.add(lblComentario);
		menu2.add(txtComentario);

	}

	public static void main(String[] args) {
		new TelaDeDetalhesPassageiro();
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
