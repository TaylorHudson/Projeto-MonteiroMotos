package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import projeto.telas.ADM.TelaDetalhesDaCorridaADM;
import projeto.telas.ADM.TelaHomeADM;
import projeto.telas.ADM.TelaListarCorridasADM;

public class OuvinteTelaListarCorridasADM implements ActionListener {
	private TelaListarCorridasADM tela;
	
	public OuvinteTelaListarCorridasADM(TelaListarCorridasADM tela) {
		this.tela = tela;
	}
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if(btn == tela.getBtnDetalhes()) {
			tela.dispose();
			new TelaDetalhesDaCorridaADM();
		}else if(btn == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomeADM();
		}
	}

}
