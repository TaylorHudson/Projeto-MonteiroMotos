package projeto.telas.ADM;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.ADM.ouvintes.OuvinteTelaValorDeCreditosADM;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJFormatted;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaValorDeCreditosADM extends TelaPadrao {
	private ImagemDeFundo imagem; 
	private JButton btnSalvar;
	private JButton btnSeta;
	private JLabel lblValor;
	private JFormattedTextField txtCreditos;

	public TelaValorDeCreditosADM() {
		super("Valor dos Creditos");
		setVisible(true);
		
	}

	@Override
	public void configurarComponentes() {
		confgImagemDeFundo();
		confgBotoes();
		confgTexto();
		
		
	}
	public void confgImagemDeFundo() {
		imagem = super.configImagemDeFundo("background_2.jpg");
		add(imagem);
	}
	public void confgBotoes() {
		OuvinteTelaValorDeCreditosADM ouvinte = new OuvinteTelaValorDeCreditosADM(this);
		OuvinteBotaoFundoPreto mouse = new OuvinteBotaoFundoPreto();
		btnSalvar = FabricaJButton.criarJButton("SALVAR", 270, 650, 300, 40, Color.white, Color.black,28);
		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		
		btnSalvar.addActionListener(ouvinte);
		btnSeta.addActionListener(ouvinte);
		btnSalvar.addMouseListener(mouse);
		
		imagem.add(btnSalvar);
		imagem.add(btnSeta);
	}
	public void confgTexto() {
		lblValor = FabricaJLabel.criarJLabel("Valor dos Creditos de Reivindicação", 50, 100, 450, 40, Color.black,Color.white, 25);
		try {
		txtCreditos = FabricaJFormatted.criarJFormatted(50, 150, 90, 40, new MaskFormatter("0,##"));
		}catch (Exception e) {
			
		}
		imagem.add(lblValor);
		imagem.add(txtCreditos);
	}
	public JButton getBtnSalvar() {
		return btnSalvar;
	}
	
	public JButton getBtnSeta() {
		return btnSeta;
	}
	
	public JTextField getTxtCreditos() {
		return txtCreditos;
	}
	
	public static void main(String[] args) {
		new TelaValorDeCreditosADM();
	}

	

}
