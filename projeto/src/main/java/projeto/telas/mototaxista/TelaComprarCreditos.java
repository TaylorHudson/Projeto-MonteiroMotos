package projeto.telas.mototaxista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoBranco;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.mototaxista.ouvintes.OuvinteSpinner;
import projeto.telas.mototaxista.ouvintes.OuvinteTelaComprarCreditos;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaComprarCreditos extends TelaPadrao {

	private JTextField txtPrecoTotal;
	private JSpinner spinner;
	private ImagemDeFundo background;
	private JButton btnSeta;

	public TelaComprarCreditos() {
		super("Tela para compra de creditos");
		setVisible(true);
	}

	@Override
	public void configurarComponentes() {
		configImagemFundo();
		configMenu();
		configSeta();
	}

	private void configImagemFundo() {
		background = super.configImagemDeFundo("background_2.jpg");
		add(background);
	}

	private void configSeta() {
		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		btnSeta.addActionListener(new OuvinteTelaComprarCreditos(this));
		btnSeta.addMouseListener(new OuvinteBotaoFundoBranco());
		background.add(btnSeta);
	}

	private void configMenu() {
		OuvinteTelaComprarCreditos ouvinte = new OuvinteTelaComprarCreditos(this);

		JLabel menu = FabricaJLabel.criarJLabel(150, 150, 550, 450, Color.BLACK, 0);
		menu.setBackground(Color.BLACK);

		JLabel lblQuantidade = FabricaJLabel.criarJLabel("Quantidade de Creditos", 10, 80, 350, 26, Color.BLACK,
				Color.WHITE, 26);

		spinner = new JSpinner();
		spinner.setBounds(10, 120, 100, 35);
		spinner.setFont(new Font("Arial", 1, 20));
		spinner.addChangeListener(new OuvinteSpinner(this));

		JLabel lblPrecoTotal = FabricaJLabel.criarJLabel("Valor Total", 10, 180, 350, 30, Color.BLACK, Color.WHITE, 26);

		txtPrecoTotal = FabricaJText.criarJTextField(10, 220, 300, 30, Color.WHITE, Color.BLACK, 24);
		txtPrecoTotal.setEditable(false);

		JButton btnGerarBoleto = FabricaJButton.criarJButton("Gerar Boleto", 180, 350, 180, 40, Color.WHITE,
				Color.BLACK, 24);
		btnGerarBoleto.addMouseListener(new OuvinteBotaoFundoPreto());
		btnGerarBoleto.addActionListener(ouvinte);

		menu.add(lblQuantidade);
		menu.add(spinner);
		menu.add(lblPrecoTotal);
		menu.add(txtPrecoTotal);
		menu.add(btnGerarBoleto);

		background.add(menu);
		add(background);
	}

	public JTextField getTxtPrecoTotal() {
		return txtPrecoTotal;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public JButton getBtnSeta() {
		return btnSeta;
	}

	public static void main(String[] args) {
		new TelaComprarCreditos();
	}

}
