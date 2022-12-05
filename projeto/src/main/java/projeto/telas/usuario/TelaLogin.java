package projeto.telas.usuario;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projeto.OuvinteBotaoFundoPreto;
import projeto.telas.usuario.ouvintes.OuvinteBotaoEntrarTelaLogin;
import projeto.telas.usuario.ouvintes.OuvinteTelaLogin;
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
	private JButton btnCadastrese;

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

		JLabel menu = FabricaJLabel.criarJLabel(190, 170, 500,450, Color.BLACK,3);
		menu.setBackground(Color.BLACK);
		
		
		JLabel lblTipo = FabricaJLabel.criarJLabel("Tipo do usuario",20, 20, 460, 40,Color.white, 25);
		JLabel lblEmail = FabricaJLabel.criarJLabel("Email", 20, 100, 460, 40, Color.white, 25);
		JLabel lblSenha = FabricaJLabel.criarJLabel("Senha", 20, 180, 460, 40, Color.white, 25);
		JLabel lblInfo = FabricaJLabel.criarJLabel("Ainda não tem Conta?", 10, 410, 460, 40,Color.white, 10);

		txtEmail = FabricaJText.criarJTextField(20, 135, 460, 40, Color.white, Color.black, 16);
		txtSenha = FabricaJText.criarJPasswordField(20, 220, 460, 40, Color.white, Color.black,20);
		
		box = new JComboBox<String>(new String[] {"Mototaxista","Passageiro"});
		box.setBounds(20, 60, 460, 40);
		box.setFont(new Font("Arial", 1, 20));
		box.setForeground(Color.black);
		box.setBackground(Color.white);	
		OuvinteTelaLogin ouvinte = new OuvinteTelaLogin(this);
		
		btnResetSenha = FabricaJButton.criarJButton("Esqueceu a senha?", 340, 270, 120, 20, Color.white,Color.black, 12);
		btnResetSenha.addActionListener(ouvinte);
		btnCadastrese = FabricaJButton.criarJButton("Cadastre-se", 130, 418, 120, 20, Color.white,Color.black, 12);
		btnCadastrese.addActionListener(ouvinte);
		btnEntrar = FabricaJButton.criarJButton("Entrar", 180, 300, 120, 45, Color.white,Color.black, 30);
		
		OuvinteBotaoFundoPreto ouvinteBotaoPadrao = new OuvinteBotaoFundoPreto();
		btnResetSenha.addActionListener(ouvinte);
		btnResetSenha.addMouseListener(ouvinteBotaoPadrao);
		btnCadastrese.addActionListener(ouvinte);
		btnCadastrese.addMouseListener(ouvinteBotaoPadrao);
		btnEntrar.addActionListener(new OuvinteBotaoEntrarTelaLogin(this));
		btnEntrar.addMouseListener(ouvinteBotaoPadrao);

		menu.add(lblInfo);
		menu.add(txtEmail);
		menu.add(lblEmail);
		menu.add(txtSenha);
		menu.add(lblSenha);
		menu.add(lblTipo);
		menu.add(box);
		menu.add(btnCadastrese);
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

	public JButton getBtnCadastrese() {
		return btnCadastrese;
	}
	
}
