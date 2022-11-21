package projeto.telas.mototaxista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import projeto.telas.mototaxista.ouvintes.OuvinteBotoesTelaEdicao;
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
	private JLabel lblSeta;

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
		OuvinteBotoesTelaEdicao ouvinte = new OuvinteBotoesTelaEdicao(this);

		JLabel background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUND_2);

		lblSeta = FabricaJLabel.criarJLabel(10, 10, 50, 50, Imagens.SETA);
		lblSeta.addMouseListener(ouvinte);

		JLabel menu = FabricaJLabel.criarJLabel(80, 80, 700, 620, Color.BLACK,3);
		menu.setBackground(Color.BLACK);

		JLabel lblNomeCompleto = FabricaJLabel.criarJLabel("Nome Completo", 30, 60, 460, 40, Color.white, 25);
		txtNomeCompleto = FabricaJText.criarJTextField(30, 100, 640, 40, Color.white, Color.BLACK, 16);

		JLabel lblEmail = FabricaJLabel.criarJLabel("Email", 30, 140, 460, 40, Color.white, 25);
		txtEmail = FabricaJText.criarJTextField(30, 180, 640, 40, Color.white, Color.BLACK, 16);

		JLabel lblSenha = FabricaJLabel.criarJLabel("Senha", 30, 220, 460, 40, Color.white, 25);
		txtSenha = FabricaJText.criarJPasswordField(30, 260, 640, 40, Color.white, Color.BLACK, 16);

		JLabel lblDataNascimento = FabricaJLabel.criarJLabel("Data de Nascimento", 30, 300, 460, 40, Color.white, 25);
		try {
			txtData = FabricaJFormatted.criarJFormatted(30, 340, 640, 40, new MaskFormatter("##/##/####"));
		} catch (Exception e) {
		}

		JButton btnSalvar = FabricaJButton.criarJButton("Salvar", 270, 470, 150, 50,Color.WHITE,Color.BLACK, 25);
		btnSalvar.addMouseListener(ouvinte);

		menu.add(lblNomeCompleto);
		menu.add(txtNomeCompleto);
		menu.add(lblEmail);
		menu.add(txtEmail);
		menu.add(lblSenha);
		menu.add(txtSenha);
		menu.add(lblDataNascimento);
		menu.add(txtData);
		menu.add(btnSalvar);
		background.add(menu);
		background.add(lblSeta);
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

	public JLabel getLblSeta() {
		return lblSeta;
	}

	public static void main(String[] args) {
		new TelaEdicaoPerfil();
	}
}
