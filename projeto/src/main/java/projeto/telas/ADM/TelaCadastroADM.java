package projeto.telas.ADM;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import projeto.telas.ADM.ouvintes.OuvintesTelaDeCadastroADM;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJFormatted;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaCadastroADM extends JFrame {

	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JLabel background;
	private JTextField txtNomeCompleto;
	private JFormattedTextField txtData;

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
		OuvintesTelaDeCadastroADM ouvinte = new OuvintesTelaDeCadastroADM(this);

		JLabel menu = FabricaJLabel.criarJLabel(180, 160, 500, 450, Color.BLACK, 4);
		menu.setBackground(Color.BLACK);

		JLabel lblEmail = FabricaJLabel.criarJLabel("Email", 20, 30, 460, 40, Color.WHITE, 25);
		JLabel lblSenha = FabricaJLabel.criarJLabel("Senha", 20, 100, 460, 40, Color.WHITE, 25);
		JLabel lblNomeCompleto = FabricaJLabel.criarJLabel("Nome Completo", 20, 175, 460, 40, Color.WHITE, 25);

		txtEmail = FabricaJText.criarJTextField(20, 65, 460, 40, Color.WHITE, Color.BLACK, 16);
		txtSenha = FabricaJText.criarJPasswordField(20, 135, 460, 40, Color.WHITE,Color.BLACK,20);
		txtNomeCompleto = FabricaJText.criarJTextField(20, 210, 460, 40, Color.WHITE,Color.BLACK, 16);

		JLabel lblDataNascimento = FabricaJLabel.criarJLabel("Data de Nascimento", 20, 250, 460, 40, Color.white, 25);
		try {
			txtData = FabricaJFormatted.criarJFormatted(20, 290, 460, 40, new MaskFormatter("##/##/####"));
		} catch (Exception e) {
		}

		JButton btnCadastrar = FabricaJButton.criarJButton("Cadastrar", 170, 360, 160, 50, Color.WHITE,
				Color.BLACK, 30);
		btnCadastrar.addMouseListener(ouvinte);

		menu.add(lblEmail);
		menu.add(lblSenha);
		menu.add(lblNomeCompleto);
		menu.add(txtEmail);
		menu.add(txtSenha);
		menu.add(txtNomeCompleto);
		menu.add(btnCadastrar);
		menu.add(lblDataNascimento);
		menu.add(txtData);

		background.add(menu);

	}

	private void configImagemFundo() {
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUND);
		add(background);
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

	public JTextField getTxtNomeCompleto() {
		return txtNomeCompleto;
	}

	public JFormattedTextField getTxtData() {
		return txtData;
	}

	public static void main(String[] args) {
		new TelaCadastroADM();
	}

}