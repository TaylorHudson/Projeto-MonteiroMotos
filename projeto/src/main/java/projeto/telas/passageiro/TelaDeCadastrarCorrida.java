package projeto.telas.passageiro;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJCheckBox;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaDeCadastrarCorrida extends JFrame {

	private JLabel background;
	private JButton btnSeta;
	private JTextField txtPontoDeEncontro;
	private JTextField txtLocalDestino;
	private JTextField txtComplemento;
	private JTextField txtSexo;
	private JDateChooser chooser;
	private JLabel lblChooser;

	public TelaDeCadastrarCorrida() {
		configurarDateChooser();
		configurarTela();
		configMenu();
		configImagemFundo();
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

	private void configurarTela() {
		setSize(900, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Cadastrar corrida ");
	}

	private void configImagemFundo() {
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUND_2);
		add(background);
	}

	private void configMenu() {

		JLabel background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUND_2);

		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);

		JLabel menu = FabricaJLabel.criarJLabel(80, 80, 700, 620, Color.BLACK, 3);
		menu.setBackground(Color.BLACK);

		JCheckBox checkBoxFeminino = FabricaJCheckBox.criarJCheckBox(30, 300, 90, 30, "Feminino", Color.BLACK,
				Color.WHITE);
		JCheckBox checkBoxMasculino = FabricaJCheckBox.criarJCheckBox(130, 300, 90, 30, "Masculino", Color.black,
				Color.white);

		JLabel lblPontoDeEcontro = FabricaJLabel.criarJLabel("Ponto de encontro", 30, 60, 460, 40, Color.white, 25);
		txtPontoDeEncontro = FabricaJText.criarJTextField(30, 100, 640, 40, Color.white, Color.BLACK, 16);

		JLabel lblLocalDeDestino = FabricaJLabel.criarJLabel("Local de destino", 30, 140, 460, 40, Color.white, 25);
		txtLocalDestino = FabricaJText.criarJTextField(30, 180, 640, 40, Color.white, Color.BLACK, 16);

		JLabel lblComplemento = FabricaJLabel.criarJLabel("Complemento", 30, 220, 460, 40, Color.white, 25);
		txtComplemento = FabricaJText.criarJTextField(30, 260, 640, 40, Color.white, Color.BLACK, 16);

		JButton btnConfirmar = FabricaJButton.criarJButton("Confirmar", 270, 470, 150, 50, Color.WHITE, Color.BLACK,
				25);

		menu.add(lblPontoDeEcontro);
		menu.add(txtPontoDeEncontro);
		menu.add(lblLocalDeDestino);
		menu.add(txtLocalDestino);
		menu.add(lblComplemento);
		menu.add(txtComplemento);
		menu.add(checkBoxFeminino);
		menu.add(checkBoxMasculino);
		menu.add(lblChooser);

		menu.add(btnConfirmar);
		background.add(menu);
		background.add(btnSeta);
		add(background);
	}

	private void configButton() {

	}

	public static void main(String[] args) {
		new TelaDeCadastrarCorrida();
	}
}
