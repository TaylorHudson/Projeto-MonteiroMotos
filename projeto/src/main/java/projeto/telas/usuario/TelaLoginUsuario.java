package projeto.telas.usuario;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projeto.telas.TelaPadrao;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaLoginUsuario extends TelaPadrao {

	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JButton btnResetSenha;
	private JButton btnEntrar;
	
	public TelaLoginUsuario() {
		super("Login");
	}

	public TelaLoginUsuario(String titulo) {
		super(titulo);
	}

	@Override
	public void addComponentes() {
		addBackground(Imagens.BACKGROUND);
		addFormLogin();
	}
	
	public void addBackground(ImageIcon bg) {
		JLabel background = new JLabel(bg);
		setContentPane(background);
	}
	
	private void addFormLogin() {
		JLabel menu = FabricaJLabel.criarJLabel(180, 200, 500, 400, Color.BLACK, 4);
		JLabel lblEmail = FabricaJLabel.criarJLabel("Email", 20, 60, 460, 40, new Color(247, 247, 247), 25);
		JLabel lblSenha = FabricaJLabel.criarJLabel("Senha", 20, 160, 460, 40, new Color(247, 247, 247), 25);

		txtEmail = FabricaJText.criarJTextField(20, 100, 460, 40, new Color(28, 28, 30), new Color(179, 177, 177), 16);
		txtSenha = FabricaJText.criarJPasswordField(20, 200, 460, 40, new Color(28, 28, 30), new Color(179, 177, 177),20);
	
		btnResetSenha = FabricaJButton.criarJButton("Esqueceu a senha?", 10, 360, 120, 30, new Color(28, 28, 20),new Color(179, 177, 177), 12);
		btnEntrar = FabricaJButton.criarJButton("Entrar", 180, 300, 120, 45, new Color(28, 28, 20),new Color(179, 177, 177), 30);
		
		menu.add(txtEmail);
		menu.add(lblEmail);
		menu.add(txtSenha);
		menu.add(lblSenha);
		menu.add(btnEntrar);
		menu.add(btnResetSenha);
		add(menu);
	}
	
	public static void main(String[] args) {
		new TelaLoginUsuario("Login do Usu�rio");
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

}
