package projeto.telas.usuario;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto.telas.usuario.ouvintes.OuvinteTelaDeMudarDeSenha;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaDeMudarDeSenha extends JFrame {
	
	private JTextField txtNovaSenha;
	private JTextField txtConfirmarSenha;
	private JLabel background;

	public TelaDeMudarDeSenha() {
		setSize(900, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setTitle("Tela De Mudar Senha");
		addComponentes();
		setVisible(true);
	}
	
	public void addComponentes() {
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUND);
		JLabel lblBorda  = FabricaJLabel.criarJLabel(180, 200, 500, 400, Color.black, 4);
		JLabel lblNovaSenha = FabricaJLabel.criarJLabel("Nova Senha", 195, 280, 460, 40, new Color(28, 28, 30), Color.white, 25);
		JLabel lblConfirmarSenha = FabricaJLabel.criarJLabel("Confirmar Senha", 195, 380, 460, 40, new Color(28, 28, 30), Color.white, 25);
		txtNovaSenha = FabricaJText.criarJTextField(195, 320,460 , 40, new Color(28, 28, 30), new Color(179, 177 ,177), 16);
		txtConfirmarSenha = FabricaJText.criarJTextField(195, 420,460 , 40, new Color(28, 28, 30), new Color(179, 177 ,177), 16);
		
		OuvinteTelaDeMudarDeSenha ouvinte = new OuvinteTelaDeMudarDeSenha(this);
		
		JButton btnConfirmar = FabricaJButton.criarJButton("Confirmar", 340, 500, 170, 45, new Color(28,28,20), new Color(179,177,177), 30);
		btnConfirmar.addMouseListener(ouvinte);
		
		add(background);
		background.add(lblBorda);
		background.add(txtNovaSenha);
		background.add(lblNovaSenha);
		background.add(lblConfirmarSenha);
		background.add(txtConfirmarSenha);
		background.add(btnConfirmar);
		
	}

	public JTextField getTxtNovaSenha() {
		return txtNovaSenha;
	}

	public JTextField getTxtConfirmarSenha() {
		return txtConfirmarSenha;
	}

	public static void main(String[] args) {
		new TelaDeMudarDeSenha();
	}
}
