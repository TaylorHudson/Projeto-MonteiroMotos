package projeto.telas.usuario;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto.OuvinteBotaoPadrao;
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
		JLabel menu = FabricaJLabel.criarJLabel(175, 200, 500, 400, Color.BLACK,3);
		menu.setBackground(Color.BLACK);
		
		JLabel lblNovaSenha = FabricaJLabel.criarJLabel("Nova Senha", 20, 100, 460, 40, Color.white, 25);
		JLabel lblConfirmarSenha = FabricaJLabel.criarJLabel("Confirmar Senha", 20, 190, 460, 40, Color.white, 25);
		txtNovaSenha = FabricaJText.criarJTextField(20, 140,460 , 40, Color.white, Color.black, 16);
		txtConfirmarSenha = FabricaJText.criarJTextField(20, 230,460 , 40, Color.white, Color.black, 16);
		
		OuvinteTelaDeMudarDeSenha ouvinte = new OuvinteTelaDeMudarDeSenha(this);
		
		JButton btnConfirmar = FabricaJButton.criarJButton("Confirmar", 165, 320, 170, 45,  Color.white, Color.black, 30);
		btnConfirmar.addActionListener(ouvinte);
		btnConfirmar.addMouseListener(new OuvinteBotaoPadrao());
		
		menu.add(txtNovaSenha);
		menu.add(lblNovaSenha);
		menu.add(lblConfirmarSenha);
		menu.add(txtConfirmarSenha);
		menu.add(btnConfirmar);
		background.add(menu);
		add(background);
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
