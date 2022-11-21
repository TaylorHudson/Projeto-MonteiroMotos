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
	private JLabel menu;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JLabel lblNomeCompleto;
	private JButton btnCadastrar;
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

		menu = FabricaJLabel.criarJLabel(180, 160, 500, 450, Color.BLACK, 4);
		menu.setBackground(Color.BLACK);

		lblEmail = FabricaJLabel.criarJLabel("Email", 20, 30, 460, 40, Color.WHITE, 25);
		lblSenha = FabricaJLabel.criarJLabel("Senha", 20, 100, 460, 40, Color.WHITE, 25);
		lblNomeCompleto = FabricaJLabel.criarJLabel("Nome Completo", 20, 175, 460, 40, Color.WHITE, 25);

		txtEmail = FabricaJText.criarJTextField(20, 65, 460, 40, Color.WHITE, Color.BLACK, 16);
		txtSenha = FabricaJText.criarJPasswordField(20, 135, 460, 40, Color.WHITE,Color.BLACK,20);
		txtNomeCompleto = FabricaJText.criarJTextField(20, 210, 460, 40, Color.WHITE,Color.BLACK, 16);

		JLabel lblDataNascimento = FabricaJLabel.criarJLabel("Data de Nascimento", 20, 250, 460, 40, Color.white, 25);
		try {
			txtData = FabricaJFormatted.criarJFormatted(20, 290, 460, 40, new MaskFormatter("##/##/####"));
		} catch (Exception e) {
		}

		btnCadastrar = FabricaJButton.criarJButton("Cadastrar", 170, 360, 160, 50, Color.WHITE,
				Color.BLACK, 30);
		btnCadastrar.addActionListener(ouvinte);

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

	public static void main(String[] args) {
		new TelaCadastroADM();
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

}