package projeto.telas.mototaxista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoBranco;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJCheckBox;
import utilidades.fabricas.FabricaJFormatted;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaReivindicarCorrida extends TelaPadrao {
	
	private JTextField txtDestino;
	private JTextField txtEncontro;
	private JTextField txtEmailPassageiro;
	private JFormattedTextField txtData;
	private JFormattedTextField txtHora;
	private JCheckBox cbConcluido;
	private JButton btnSeta;
	private ImagemDeFundo background;
	private JButton btnReivindicar;

	public TelaReivindicarCorrida() {
		super("Reivindicar corrida");
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configLabel();
		configTextField();
		configBotao();
	}

	private void configTextField() {
		txtDestino = FabricaJText.criarJTextField(50, 85, 300, 50,Color.WHITE,Color.BLACK,20);
		txtEncontro = FabricaJText.criarJTextField(50, 285, 300, 50,Color.WHITE,Color.BLACK,20);
		txtEmailPassageiro = FabricaJText.criarJTextField(50, 485, 300, 50,Color.WHITE,Color.BLACK,20);
		
		try {
			txtData = FabricaJFormatted.criarJFormatted(550, 85, 300, 50, new MaskFormatter("##/##/####"));
			txtHora = FabricaJFormatted.criarJFormatted(550, 285, 300, 50, new MaskFormatter("##:##:##"));
		} catch (ParseException e) {
		}
		
		background.add(txtDestino);
		background.add(txtEncontro);
		background.add(txtEmailPassageiro);
		background.add(txtData);
		background.add(txtHora);
	}
	
	private void configImagemFundo() {
		background = super.configImagemDeFundo("background_2.jpg");
		add(background);
	}

	private void configBotao() {
		btnReivindicar = FabricaJButton.criarJButton("Reivindicar",300, 635, 250, 55,Color.BLACK,Color.WHITE,30);
		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 5, 5, 50, 50);
		
		OuvinteBotaoFundoBranco ouvinteBotao = new OuvinteBotaoFundoBranco();
		
		btnSeta.addActionListener(new OuvinteTelaReivindicarCorrida(this));
		btnSeta.addMouseListener(ouvinteBotao);
		
		btnReivindicar.addMouseListener(ouvinteBotao);
		
		background.add(btnReivindicar);
		background.add(btnSeta);
	}

	private void configLabel() {
		JLabel lblDestino = FabricaJLabel.criarJLabel("Local de Destino", 50, 50, 200, 25, Color.WHITE,25);
		JLabel lblEncontro = FabricaJLabel.criarJLabel("Ponto de Encontro", 50, 250, 230, 25, Color.WHITE,25);
		JLabel lblEmailPassageiro = FabricaJLabel.criarJLabel("E-mail do Passageiro", 50, 450, 250, 25, Color.WHITE,25);
		JLabel lblData = FabricaJLabel.criarJLabel("Data", 550, 50, 250, 25, Color.WHITE,25);
		JLabel lblHora = FabricaJLabel.criarJLabel("Hora", 550, 250, 250, 25, Color.WHITE,25);
		cbConcluido = FabricaJCheckBox.criarJCheckBox(550, 480, 150, 50, "Concluída",Color.BLACK, Color.WHITE);
		cbConcluido.setFont(new Font("Arial", Font.BOLD, 25));
		
		background.add(lblDestino);
		background.add(lblEncontro);
		background.add(lblEmailPassageiro);
		background.add(lblData);
		background.add(lblHora);
		background.add(cbConcluido);
	}
	
	public class OuvinteTelaReivindicarCorrida implements ActionListener {

		private TelaReivindicarCorrida tela;
		
		public OuvinteTelaReivindicarCorrida(TelaReivindicarCorrida tela) {
			this.tela = tela;
		}
		
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			if(btn == btnSeta) {
				tela.dispose();
				new TelaListarCorridas();
			}else if(btn == btnReivindicar) {
				
			}
		}
		
	}

	public static void main(String[] args) {
		new TelaReivindicarCorrida();
	}
}
