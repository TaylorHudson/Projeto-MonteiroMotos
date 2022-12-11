package projeto.telas.usuario;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.usuario.ouvintes.OuvinteTelaDeEnvioDeCodigo;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaDeEnvioDeCodigo extends TelaPadrao {
	OuvinteTelaDeEnvioDeCodigo ouvinte = new OuvinteTelaDeEnvioDeCodigo(this);

	private ImagemDeFundo background;
	private JTextField txtEmail;
	private JButton btnSeta;

	public TelaDeEnvioDeCodigo() {
		super("Tela De Envio De Codigo");
		addComponentes();
		setVisible(true);
	}
	
	public void configurarComponentes() {
		configBg();
	}
	
	public void configBg() {
		background = super.configImagemDeFundo("background.jpg");
		add(background);
	}

	public void addComponentes() {

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

}