package projeto.telas.passageiro;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;

public class TelaHomePassageiro extends JFrame {

	private JLabel background;

	private JMenuBar menu = new JMenuBar();
	private JMenu deletar = new JMenu("Deletar");
	private JMenu editar = new JMenu("editar");

	public TelaHomePassageiro() {
		configImagemFundo();
		configMenu();
		configurarTela();
		configButton();
		setVisible(true);
	}

	private void configurarTela() {
		setSize(900, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Home");
	}

	private void configMenu() {
		setBounds(20, 30, 500, 500);
		menu.setLayout(null);
		menu.add(deletar);
		menu.add(editar);
		this.setJMenuBar(menu);
	}

	private void configImagemFundo() {
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUNDHOME);
		add(background);
	}

	private void configButton() {
		JButton btnListarCorrida = FabricaJButton.criarJButton("Listar Corrida", 270, 190, 380, 240,
				new Color(28, 28, 20), new Color(179, 177, 177), 28);
		btnListarCorrida.addMouseListener(null);
		JButton btnCadastrarCorrida = FabricaJButton.criarJButton("Cadastrar Corrida", 270, 440, 380, 240,
				new Color(28, 28, 20), new Color(179, 177, 177), 28);
		btnCadastrarCorrida.addMouseListener(null);

		background.add(btnCadastrarCorrida);
		background.add(btnListarCorrida);

	}

	public static void main(String[] args) {
		new TelaHomePassageiro();
	}
}
