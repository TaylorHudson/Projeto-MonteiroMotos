package projeto.tela.ADM;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projeto.telas.ADM.ouvintes.OuvintesTelaDeLoginUsuario;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaCadastroADM extends JFrame {

	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JLabel background;
	private JLabel menu;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JLabel lblNomeCompleto;
	private JButton btnResetSenha;
	private JButton btnCadastrar;
	private JTextField txtNomeCompleto;

	public TelaCadastroADM() {
		configurarTela();
		configImagemFundo();
		configFormLogin();
		setVisible(true);
	}

	private void configurarTela() {
		setSize(900, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Cadastro do ADM");
	}
	private void configFormLogin() {
		OuvintesTelaDeLoginUsuario ouvinte = new OuvintesTelaDeLoginUsuario(this);

		menu = FabricaJLabel.criarJLabel(180, 200, 500, 400, Color.BLACK, 4);
		lblEmail = FabricaJLabel.criarJLabel("Email", 20, 30, 460, 40, new Color(247, 247, 247), 25);
		lblSenha = FabricaJLabel.criarJLabel("Senha", 20, 100, 460, 40, new Color(247, 247, 247), 25);
		lblNomeCompleto = FabricaJLabel.criarJLabel("Nome Completo", 20, 175, 460, 40, new Color(247, 247, 247), 25);

		txtEmail = FabricaJText.criarJTextField(20, 65, 460, 40, new Color(28, 28, 30), new Color(179, 177, 177), 16);
		txtSenha = FabricaJText.criarJPasswordField(20, 135, 460, 40, new Color(28, 28, 30), new Color(179, 177, 177),
				20);
		txtNomeCompleto = FabricaJText.criarJTextField(20, 210, 460, 40, new Color(28, 28, 30),
				new Color(179, 177, 177), 16);

		btnCadastrar = FabricaJButton.criarJButton("Cadastrar", 170, 280, 160, 60, new Color(28, 28, 20),
				new Color(179, 177, 177), 30);
		btnCadastrar.addActionListener(ouvinte);

		menu.add(lblEmail);
		menu.add(lblSenha);
		menu.add(lblNomeCompleto);
		menu.add(txtEmail);
		menu.add(txtSenha);
		menu.add(txtNomeCompleto);
		menu.add(btnCadastrar);

		background.add(menu);

	}

	private void configImagemFundo() {
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUND);
		add(background);
	}

	public static void main(String[] args) {
		new TelaCadastroADM();
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

}