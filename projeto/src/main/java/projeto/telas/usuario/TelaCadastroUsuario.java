package projeto.telas.usuario;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import projeto.telas.usuario.ouvintes.OuvinteTelaCadastroUsuario;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJFormatted;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaCadastroUsuario extends JFrame {

	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JFormattedTextField txtData;
	private JComboBox<String> box;
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
		OuvinteTelaCadastroUsuario ouvinte = new OuvinteTelaCadastroUsuario(this);

		JLabel menu = FabricaJLabel.criarJLabel(180, 160, 500, 500, Color.BLACK, 4);
		menu.setBackground(Color.BLACK);

		JLabel lblTipo = FabricaJLabel.criarJLabel("Tipo do usuario", 20, 20, 460, 40, Color.white, 25);
		JLabel lblNome = FabricaJLabel.criarJLabel("Nome Completo", 20, 95, 460, 40, new Color(247, 247, 247), 25);
		JLabel lblEmail = FabricaJLabel.criarJLabel("Email", 20, 168, 460, 40, new Color(247, 247, 247), 25);
		JLabel lblSenha = FabricaJLabel.criarJLabel("Senha", 20, 238, 460, 40, new Color(247, 247, 247), 25);

		txtNome = FabricaJText.criarJTextField(20, 130, 460, 40, Color.white, Color.black, 16);
		txtEmail = FabricaJText.criarJTextField(20, 200, 460, 40, Color.white, Color.black, 16);
		txtSenha = FabricaJText.criarJPasswordField(20, 270, 460, 40, Color.white, Color.black, 20);

		box = new JComboBox<String>(new String[] { "Mototaxista", "Passageiro" });
		box.setBounds(20, 60, 460, 40);
		box.setFont(new Font("Arial", 1, 20));
		box.setForeground(Color.black);
		box.setBackground(Color.white);

		JLabel lblDataNascimento = FabricaJLabel.criarJLabel("Data de Nascimento", 20, 315, 460, 40, Color.white, 25);
		try {
			txtData = FabricaJFormatted.criarJFormatted(20, 350, 460, 40, new MaskFormatter("##/##/####"));
		} catch (Exception e) {
		}
		JButton btnCadastrar = FabricaJButton.criarJButton("Cadastrar", 170, 420, 150, 45, Color.white,
				Color.black, 28);
		btnCadastrar.addMouseListener(ouvinte);
		menu.add(lblTipo);
		menu.add(box);
		menu.add(lblNome);
		menu.add(txtNome);
		menu.add(lblEmail);
		menu.add(txtEmail);
		menu.add(lblSenha);
		menu.add(txtSenha);
		menu.add(lblDataNascimento);
		menu.add(txtData);
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

	public static void main(String[] args) {
		new TelaCadastroUsuario();
	}
}
