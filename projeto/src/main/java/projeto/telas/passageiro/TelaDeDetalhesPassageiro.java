package projeto.telas.passageiro;

import java.awt.Color;

import javax.swing.JButton;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.passageiro.ouvintes.OuvinteTelaDeDetalhesDoPassageiro;
import utilidades.fabricas.FabricaJButton;
import utilidades.imagens.Imagens;

public class TelaDeDetalhesPassageiro extends TelaPadrao {
	private JButton btnSeta;
	private JButton btnBloquearMototaxi;
	private ImagemDeFundo background;

	public TelaDeDetalhesPassageiro() {
		super("Detalhes do passageiro");
		setVisible(true);
	}

	public void configurarComponentes() {
		configImagemFundo();
		configButton();

	}

	private void configImagemFundo() {
		background = super.configImagemDeFundo("background_2.jpg");
		add(background);
	}

	private void configButton() {
		OuvinteTelaDeDetalhesDoPassageiro ouvinte = new OuvinteTelaDeDetalhesDoPassageiro(this);

		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		btnSeta.addMouseListener(new OuvinteBotaoFundoPreto());
		btnSeta.addActionListener(ouvinte);

		btnBloquearMototaxi = FabricaJButton.criarJButton("Bloquear Mototaxi", 650, 650, 180, 50, new Color(28, 28, 20),
				new Color(179, 177, 177), 20);
		btnBloquearMototaxi.addActionListener(ouvinte);
		
		
		background.add(btnSeta);
		background.add(btnBloquearMototaxi);
	}

	public static void main(String[] args) {
		new TelaDeDetalhesPassageiro();
	}

	public JButton getBtnSeta() {
		return btnSeta;
	}

	public void setBtnSeta(JButton btnSeta) {
		this.btnSeta = btnSeta;
	}

	public JButton getBtnBloquearMototaxi() {
		return btnBloquearMototaxi;
	}

	public void setBtnBloquearMototaxi(JButton btnBloquearMototaxi) {
		this.btnBloquearMototaxi = btnBloquearMototaxi;
	}
	
}
