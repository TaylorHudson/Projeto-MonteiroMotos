package projeto.telas.passageiro.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import projeto.telas.passageiro.TelaDeDetalhesPassageiro;
import projeto.telas.passageiro.TelaListarCorridas;

public class OuvinteTelaDeDetalhesDoPassageiro implements ActionListener {

	private TelaDeDetalhesPassageiro tela;

	public OuvinteTelaDeDetalhesDoPassageiro(TelaDeDetalhesPassageiro tela) {
		this.tela = tela;

	}

	public void actionPerformed(ActionEvent e) {
		JButton item = (JButton) e.getSource();
		if(item == tela.getBtnSeta()) {
			tela.dispose();
			new TelaListarCorridas();
		}

	}
}
