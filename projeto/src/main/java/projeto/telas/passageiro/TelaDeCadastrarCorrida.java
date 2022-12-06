package projeto.telas.passageiro;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.modelo.enuns.StatusDaCorrida;
import projeto.telas.passageiro.ouvintes.OuvinteBotaoTelaDeCadastrarCorrida;
import projeto.telas.passageiro.ouvintes.OuvinteCheckBoxTelaDeCadastrarCorrida;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJCheckBox;
import utilidades.fabricas.FabricaJFormatted;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaDeCadastrarCorrida extends TelaPadrao {

	private ImagemDeFundo background;
	private JButton btnSeta;
	private JTextField txtPontoDeEncontro;
	private JTextField txtLocalDestino;
	private JTextField txtComplemento;
	private JTextField txtSexo;
	private JDateChooser chooser;
	private JLabel lblChooser;
	private JButton btnSalvar;
	private StatusDaCorrida horario;
	private JFormattedTextField txtHora;

	private JCheckBox checkBoxParaAgora;
	private JCheckBox checkBoxParaDepois;

	public TelaDeCadastrarCorrida() {
		super("Cadastrar corrida");
		setVisible(true);
	}

	private void configurarDateChooser() {

		chooser = new JDateChooser(new Date());
		lblChooser = new JLabel();

		lblChooser.setLayout(null);
		lblChooser.setBounds(-10, 330, 200, 50);
		lblChooser.setOpaque(true);
		lblChooser.setLayout(null);
		lblChooser.setBackground(Color.black);
		lblChooser.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		chooser.setBounds(40, 10, 152, 30);
		chooser.setForeground(Color.black);
		chooser.setFont(new Font("Arial", 1, 13));

		lblChooser.add(chooser);
	}
	
	public void configurarComponentes() {
		configurarDateChooser();
		configMenu();
		configImagemFundo();
		
	}
	private void configImagemFundo() {
		background = super.configImagemDeFundo("background_2.jpg");
		add(background);
	}

	private void configMenu() {
		OuvinteBotaoTelaDeCadastrarCorrida ouvinteBotao = new OuvinteBotaoTelaDeCadastrarCorrida(this);
		OuvinteCheckBoxTelaDeCadastrarCorrida ouvinteCheckBox = new OuvinteCheckBoxTelaDeCadastrarCorrida(this);

		JLabel background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUND_2);

		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		btnSeta.addMouseListener(new OuvinteBotaoFundoPreto());
		btnSeta.addActionListener(ouvinteBotao);

		JLabel menu = FabricaJLabel.criarJLabel(80, 80, 700, 620, Color.BLACK, 3);
		menu.setBackground(Color.BLACK);

		checkBoxParaAgora = FabricaJCheckBox.criarJCheckBox(30, 300, 90, 30, "Para agora", Color.BLACK, Color.WHITE);
		checkBoxParaAgora.addItemListener(ouvinteCheckBox);
		checkBoxParaDepois = FabricaJCheckBox.criarJCheckBox(130, 300, 90, 30, "Data futura", Color.black, Color.white);
		checkBoxParaDepois.addItemListener(ouvinteCheckBox);

		JLabel lblPontoDeEcontro = FabricaJLabel.criarJLabel("Ponto de encontro", 30, 60, 460, 40, Color.white, 25);
		txtPontoDeEncontro = FabricaJText.criarJTextField(30, 100, 640, 40, Color.white, Color.BLACK, 16);

		JLabel lblLocalDeDestino = FabricaJLabel.criarJLabel("Local de destino", 30, 140, 460, 40, Color.white, 25);
		txtLocalDestino = FabricaJText.criarJTextField(30, 180, 640, 40, Color.white, Color.BLACK, 16);

		JLabel lblComplemento = FabricaJLabel.criarJLabel("Complemento", 30, 220, 460, 40, Color.white, 25);
		txtComplemento = FabricaJText.criarJTextField(30, 260, 640, 40, Color.white, Color.BLACK, 16);

		JLabel lblMsg = FabricaJLabel.criarJLabel("Digite A hora da corrida", 30, 370, 300, 40, Color.white, 9);

		try {
			txtHora = FabricaJFormatted.criarJFormatted(30, 400, 100, 40, new MaskFormatter("##:##:##"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		txtHora.addActionListener(ouvinteBotao);

		btnSalvar = FabricaJButton.criarJButton("Salvar", 270, 470, 150, 50, Color.WHITE, Color.BLACK, 25);
		btnSalvar.addMouseListener(new OuvinteBotaoFundoPreto());
		btnSalvar.addActionListener(ouvinteBotao);

		menu.add(lblPontoDeEcontro);
		menu.add(txtPontoDeEncontro);
		menu.add(lblLocalDeDestino);
		menu.add(txtLocalDestino);
		menu.add(lblComplemento);
		menu.add(txtComplemento);
		menu.add(checkBoxParaAgora);
		menu.add(checkBoxParaDepois);
		menu.add(lblChooser);
		menu.add(txtHora);
		menu.add(lblMsg);

		menu.add(btnSalvar);
		background.add(menu);
		background.add(btnSeta);
		add(background);
	}

	public static void main(String[] args) {
		new TelaDeCadastrarCorrida();
	}

	public JButton getBtnSeta() {
		return btnSeta;
	}

	public JDateChooser getChooser() {
		return chooser;
	}

	public JLabel getLblChooser() {
		return lblChooser;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public JTextField getTxtPontoDeEncontro() {
		return txtPontoDeEncontro;
	}

	public JTextField getTxtLocalDestino() {
		return txtLocalDestino;
	}

	public JTextField getTxtComplemento() {
		return txtComplemento;
	}

	public JTextField getTxtSexo() {
		return txtSexo;
	}

	public JCheckBox getCheckBoxParaAgora() {
		return checkBoxParaAgora;
	}

	public JCheckBox getCheckBoxParaDepois() {
		return checkBoxParaDepois;
	}

	public StatusDaCorrida getHorario() {
		return horario;
	}

	public void setHorario(StatusDaCorrida horario) {
		this.horario = horario;
	}

	public JFormattedTextField getTxtHora() {
		return txtHora;
	}

}
