package projeto.telas.usuario;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projeto.telas.usuario.ouvintes.OuvinteTelaCadastroUsuario;
import utilidades.Imagens;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;

public class TelaCadastroUsuario extends JFrame {

	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JLabel background;

	public TelaCadastroUsuario() {
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
		setTitle("Cadastro");
	}

	private void configImagemFundo() {
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUND);
		add(background);
	}

	private void configFormLogin() {
		JLabel menu = FabricaJLabel.criarJLabel(180, 200, 500, 400, Color.BLACK, 4);
		JLabel lblNome = FabricaJLabel.criarJLabel("Nome", 20, 5, 460, 40, new Color(247, 247, 247), 25);
		JLabel lblEmail = FabricaJLabel.criarJLabel("Email", 20, 80, 460, 40, new Color(247, 247, 247), 25);
		JLabel lblSenha = FabricaJLabel.criarJLabel("Senha", 20, 155, 460, 40, new Color(247, 247, 247), 25);

		txtNome = FabricaJText.criarJTextField(20, 40, 460, 40, new Color(28, 28, 30), new Color(179, 177, 177), 16);
		txtEmail = FabricaJText.criarJTextField(20, 115, 460, 40, new Color(28, 28, 30), new Color(179, 177, 177), 16);
		txtSenha = FabricaJText.criarJPasswordField(20, 190, 460, 40, new Color(28, 28, 30), new Color(179, 177, 177),20);

		OuvinteTelaCadastroUsuario ouvinte = new OuvinteTelaCadastroUsuario(this);
		
		JButton btnCadastrar = FabricaJButton.criarJButton("Cadastrar", 170, 330, 150, 45, new Color(28, 28, 20),
				new Color(179, 177, 177), 28);
		btnCadastrar.addMouseListener(ouvinte);

		menu.add(lblNome);
		menu.add(txtNome);
		menu.add(lblEmail);
		menu.add(txtEmail);
		menu.add(lblSenha);
		menu.add(txtSenha);
		menu.add(btnCadastrar);

		background.add(menu);
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

}
