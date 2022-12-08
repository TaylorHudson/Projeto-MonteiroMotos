package projeto.telas.usuario;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto.OuvinteBotaoFundoPreto;
import projeto.telas.usuario.ouvintes.OuvinteTelaDeEnvioDeCodigo;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaDeEnvioDeCodigo extends JFrame {
	OuvinteTelaDeEnvioDeCodigo ouvinte = new OuvinteTelaDeEnvioDeCodigo(this);

	private JLabel background;
	private JTextField txtEmail;
	private JButton btnSeta;

	public TelaDeEnvioDeCodigo() {

		setSize(900, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setTitle("Tela De Envio De Codigo");
		addComponentes();
		setVisible(true);
	}

	public void addComponentes() {

		background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUND);
		JLabel menu = FabricaJLabel.criarJLabel(175, 200, 500, 400, Color.BLACK, 3);
		menu.setBackground(Color.BLACK);
		
		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		btnSeta.addMouseListener(new OuvinteBotaoFundoPreto());
		btnSeta.addActionListener(ouvinte);
		

		JLabel lblEmail = FabricaJLabel.criarJLabel("Digite seu Email", 20, 100, 460, 40, Color.white, 25);
		txtEmail = FabricaJText.criarJTextField(20, 140, 460, 40, Color.white, Color.black, 16);
		JLabel lblMensagem = FabricaJLabel.criarJLabel(
				"iremos enviar o codigo de verificação para o seu endereço de Email", 20, 180, 460, 40, Color.white,
				13);

		JButton btnEnviarCodigo = FabricaJButton.criarJButton("Enviar Codigo", 160, 270, 180, 45, Color.white,
				Color.black, 25);
		btnEnviarCodigo.addActionListener(ouvinte);
		btnEnviarCodigo.addMouseListener(new OuvinteBotaoFundoPreto());

		
		menu.add(lblMensagem);
		menu.add(txtEmail);
		menu.add(lblEmail);
		menu.add(btnEnviarCodigo);
		background.add(btnSeta);
		background.add(menu);
		add(background);
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JButton getBtnSeta() {
		return btnSeta;
	}

	public static void main(String[] args) {
		new TelaDeEnvioDeCodigo();
	}
}