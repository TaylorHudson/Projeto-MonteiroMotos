package projeto.telas.usuario;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.usuario.ouvintes.OuvinteTelaDeMudarDeSenha;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaDeMudarDeSenha extends TelaPadrao {
	
	private JTextField txtNovaSenha;
	private JTextField txtConfirmarSenha;
	private ImagemDeFundo background;
	private String email;

	public TelaDeMudarDeSenha(String email) {
		super("Tela De Mudar Senha");
		this.email = email;
		setVisible(true);
	}
	
	public void configurarComponentes() {
		configImagemDeFundo();
		addComponentes();
	}
	
	private void configImagemDeFundo() {
		background = super.configImagemDeFundo("background.jpg");
		add(background);
	}

	
	public void addComponentes() {
		
		JLabel menu = FabricaJLabel.criarJLabel(175, 200, 500, 400, Color.BLACK,3);
		menu.setBackground(Color.BLACK);
		
		JLabel lblNovaSenha = FabricaJLabel.criarJLabel("Nova Senha", 20, 100, 460, 40, Color.white, 25);
		JLabel lblConfirmarSenha = FabricaJLabel.criarJLabel("Confirmar Senha", 20, 190, 460, 40, Color.white, 25);
		txtNovaSenha = FabricaJText.criarJTextField(20, 140,460 , 40, Color.white, Color.black, 16);
		txtConfirmarSenha = FabricaJText.criarJTextField(20, 230,460 , 40, Color.white, Color.black, 16);
		
		OuvinteTelaDeMudarDeSenha ouvinte = new OuvinteTelaDeMudarDeSenha(this);
		
		JButton btnConfirmar = FabricaJButton.criarJButton("Confirmar", 165, 320, 170, 45,  Color.white, Color.black, 30);
		btnConfirmar.addActionListener(ouvinte);
		btnConfirmar.addMouseListener(new OuvinteBotaoFundoPreto());
		
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

	public String getEmail() {
		return email;
	}

}
