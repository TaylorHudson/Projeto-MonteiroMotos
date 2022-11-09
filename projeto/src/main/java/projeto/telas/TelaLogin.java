package projeto.telas;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utilidades.Imagens;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;

public class TelaLogin extends JFrame {

	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JLabel background;
	private JButton btnResetSenha;
	private JButton btnEntrar;

	public TelaLogin() {
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
		setTitle("Login");
	}

	private void configImagemFundo() {
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUND);
		add(background);
	}

	private void configFormLogin() {
		JLabel menu = FabricaJLabel.criarJLabel(180, 200, 500, 400, Color.BLACK, 4);
		JLabel lblLogin = FabricaJLabel.criarJLabel("Login", 20, 60, 460, 40, new Color(247, 247, 247), 25);
		JLabel lblSenha = FabricaJLabel.criarJLabel("Senha", 20, 160, 460, 40, new Color(247, 247, 247), 25);

		txtLogin = FabricaJText.criarJTextField(20, 95, 460, 40, new Color(28, 28, 30), new Color(179, 177, 177), 16);
		txtSenha = FabricaJText.criarJPasswordField(20, 195, 460, 40, new Color(28, 28, 30), new Color(179, 177, 177),20);
		btnResetSenha = FabricaJButton.criarJButton("Esqueceu a senha?", 10, 360, 120, 30, new Color(28, 28, 20),new Color(179, 177, 177), 12);
		btnEntrar = FabricaJButton.criarJButton("Entrar", 180, 270, 120, 45, new Color(28, 28, 20),new Color(179, 177, 177), 30);

		menu.add(txtLogin);
		menu.add(lblLogin);
		menu.add(txtSenha);
		menu.add(lblSenha);
		menu.add(btnEntrar);
		menu.add(btnResetSenha);

		background.add(menu);
	}

	public JTextField getTxtLogin() {
		return txtLogin;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

	public JButton getBtnResetSenha() {
		return btnResetSenha;
	}

	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	public static void main(String[] args) {
		new TelaLogin();
	}
}
