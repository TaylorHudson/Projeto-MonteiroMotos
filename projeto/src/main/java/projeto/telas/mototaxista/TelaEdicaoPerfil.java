package projeto.telas.mototaxista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import projeto.telas.mototaxista.ouvintes.OuvinteBotaoSalvar;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJFormatted;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaEdicaoPerfil extends JFrame {

	private JTextField txtNomeCompleto;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JFormattedTextField txtData;

	public TelaEdicaoPerfil() {
		configurarTela();
		configMenu();
		setVisible(true);
	}

	private void configurarTela() {
		setSize(900, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Tela Edição de Perfil");
	}

	private void configMenu() {
		JLabel background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUND_2);

		JLabel lblNomeCompleto = FabricaJLabel.criarJLabel("Nome Completo", 150, 60, 460, 40, Color.white, 25);
		txtNomeCompleto = FabricaJText.criarJTextField(150, 100, 560, 40, Color.white, Color.BLACK, 16);

		JLabel lblEmail = FabricaJLabel.criarJLabel("Email", 150, 140, 460, 40, Color.white, 25);
		txtEmail = FabricaJText.criarJTextField(150, 180, 560, 40, Color.white, Color.BLACK, 16);

		JLabel lblSenha = FabricaJLabel.criarJLabel("Senha", 150, 220, 460, 40, Color.white, 25);
		txtSenha = FabricaJText.criarJPasswordField(150, 260, 560, 40, Color.white, Color.BLACK, 16);

		JLabel lblDataNascimento = FabricaJLabel.criarJLabel("Data de Nascimento", 150, 300, 460, 40, Color.white, 25);
		try {
			txtData = FabricaJFormatted.criarJFormatted(150, 340, 560, 40, new MaskFormatter("##/##/####"));
		} catch (Exception e) {
		}

		JButton btnSalvar = FabricaJButton.criarJButton("Salvar", 350, 420, 150, 50, Color.BLACK, Color.WHITE, 25);
		btnSalvar.addMouseListener(new OuvinteBotaoSalvar());

		background.add(lblNomeCompleto);
		background.add(txtNomeCompleto);
		background.add(lblEmail);
		background.add(txtEmail);
		background.add(lblSenha);
		background.add(txtSenha);
		background.add(lblDataNascimento);
		background.add(txtData);
		background.add(btnSalvar);
		add(background);
	}

	public JTextField getTxtNomeCompleto() {
		return txtNomeCompleto;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

	public JFormattedTextField getTxtData() {
		return txtData;
	}
	
	public static void main(String[] args) {
		new TelaEdicaoPerfil();
	}
}
