package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import projeto.telas.mototaxista.TelaComprarCreditos;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import projeto.telas.mototaxista.TelaListarCorridas;

public class OuvinteTelaHomeMototaxista implements ActionListener {

	private TelaHomeMototaxista tela;

	public OuvinteTelaHomeMototaxista(TelaHomeMototaxista tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == tela.getBtnListarCorridas()) {
			tela.dispose();
			new TelaListarCorridas();
		}else if(btn == tela.getBtnComprarCreditos()) {
			tela.dispose();
			new TelaComprarCreditos();
		}
	}
}
