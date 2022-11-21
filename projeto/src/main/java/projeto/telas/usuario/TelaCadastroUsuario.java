package projeto.telas.usuario;

import java.awt.Color;


//esta em observação pois a tela de cadastro está faltando o tipo do usuario, tem que ajeitar, e da uma ajeitada nesse pacote
//"projeto.telas.usuario" por Completo.

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import projeto.telas.mototaxista.ouvintes.OuvinteBotoesTelaEdicao;
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
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800,Imagens.BACKGROUND);
		add(background);
	}

	private void configFormLogin() {
		OuvinteTelaCadastroUsuario ouvinte = new OuvinteTelaCadastroUsuario(this);
		
		JLabel menu = FabricaJLabel.criarJLabel(180, 160, 500, 430, Color.BLACK, 4);
		menu.setBackground(Color.BLACK);
		
		JLabel lblNome = FabricaJLabel.criarJLabel("Nome Completo", 20, 5, 460, 40, new Color(247, 247, 247), 25);
		JLabel lblEmail = FabricaJLabel.criarJLabel("Email", 20, 80, 460, 40, new Color(247, 247, 247), 25);
		JLabel lblSenha = FabricaJLabel.criarJLabel("Senha", 20, 155, 460, 40, new Color(247, 247, 247), 25);

		txtNome = FabricaJText.criarJTextField(20, 40, 460, 40, Color.white, Color.black, 16);
		txtEmail = FabricaJText.criarJTextField(20, 115, 460, 40, Color.white, Color.black, 16);
		txtSenha = FabricaJText.criarJPasswordField(20, 190, 460, 40, Color.white, Color.black,20);
		
		JLabel lblDataNascimento = FabricaJLabel.criarJLabel("Data de Nascimento", 20, 230, 460, 40, Color.white, 25);
		try {
			txtData = FabricaJFormatted.criarJFormatted(20, 265, 460, 40, new MaskFormatter("##/##/####"));
		} catch (Exception e) {
		}
		JButton btnCadastrar = FabricaJButton.criarJButton("Cadastrar", 170, 350, 150, 45, Color.white,
				Color.black, 28);
		btnCadastrar.addMouseListener(ouvinte);
	

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
