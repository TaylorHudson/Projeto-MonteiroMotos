package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import projeto.telas.ADM.TelaDetalhesDaCorridaADM;
import projeto.telas.ADM.TelaListarCorridasADM;

public class OuvinteTelaDetalhesDaCorridaADM implements ActionListener{
	private TelaDetalhesDaCorridaADM tela;
	
	public OuvinteTelaDetalhesDaCorridaADM(TelaDetalhesDaCorridaADM tela) {
		this.tela = tela;
	}
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == tela.getBtnSeta()) {
			tela.dispose();
			new TelaListarCorridasADM();
		}
	}

}
