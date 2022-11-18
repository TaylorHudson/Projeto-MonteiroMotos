package projeto.telas.usuario;

import java.awt.Color;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;

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
		JLabel lblNomeCompleto = FabricaJLabel.criarJLabel("Nome Completo", 150, 60, 460, 40, Color.BLACK, 25);
		txtNomeCompleto = FabricaJText.criarJTextField(150, 100, 560, 40, Color.white, Color.BLACK, 16);
		
		JLabel lblEmail = FabricaJLabel.criarJLabel("Email", 150, 140, 460, 40, Color.BLACK, 25);
		txtEmail = FabricaJText.criarJTextField(150, 180, 560, 40, Color.white, Color.BLACK, 16);
		
		add(lblNomeCompleto);
		add(txtNomeCompleto);
		add(lblEmail);
		add(txtEmail);
	}
	
	public static void main(String[] args) {
		new TelaEdicaoPerfil();
	}
}




