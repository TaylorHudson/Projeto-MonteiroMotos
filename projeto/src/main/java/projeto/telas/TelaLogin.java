package projeto.telas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaLogin extends JFrame {

	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JLabel background;
	private JComboBox<String> box;
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
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800,Imagens.BACKGROUND);
		add(background);
	}

	private void configFormLogin() {
		JLabel menu = FabricaJLabel.criarJLabel(180, 200, 500, 400, Color.BLACK, 4);
		JLabel lblTipo = FabricaJLabel.criarJLabel("Tipo do usuario",20, 20, 460, 40,new Color(247, 247, 247), 25);
		JLabel lblEmail = FabricaJLabel.criarJLabel("Email", 20, 100, 460, 40, new Color(247, 247, 247), 25);
		JLabel lblSenha = FabricaJLabel.criarJLabel("Senha", 20, 180, 460, 40, new Color(247, 247, 247), 25);

		txtEmail = FabricaJText.criarJTextField(20, 135, 460, 40, new Color(28, 28, 30), new Color(179, 177, 177), 16);
		txtSenha = FabricaJText.criarJPasswordField(20, 220, 460, 40, new Color(28, 28, 30), new Color(179, 177, 177),20);
		
		box = new JComboBox<String>(new String[] {"Mototaxista","Passageiro"});
		box.setBounds(20, 60, 460, 40);
		box.setFont(new Font("Arial", 1, 20));
		box.setForeground(Color.white);
		box.setBackground(new Color(28, 28, 30));	
		OuvinteTelaLogin ouvinte = new OuvinteTelaLogin(this);
		
		btnResetSenha = FabricaJButton.criarJButton("Esqueceu a senha?", 10, 360, 120, 30, new Color(28, 28, 20),new Color(179, 177, 177), 12);
		btnResetSenha.addMouseListener(ouvinte);
		btnEntrar = FabricaJButton.criarJButton("Entrar", 180, 300, 120, 45, new Color(28, 28, 20),new Color(179, 177, 177), 30);
		btnEntrar.addMouseListener(ouvinte);
		
		menu.add(txtEmail);
		menu.add(lblEmail);
		menu.add(txtSenha);
		menu.add(lblSenha);
		menu.add(lblTipo);
		menu.add(box);
		menu.add(btnEntrar);
		menu.add(btnResetSenha);

		background.add(menu);
	}

	public JTextField getTxtEmail() {
		return txtEmail;
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

	public JComboBox<String> getBox() {
		return box;
	}

	public static void main(String[] args) {
		new TelaLogin();
	}
}
