package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.mototaxista.TelaHomeMototaxista;
import projeto.telas.mototaxista.TelaListarCorridasMototaxi;

public class OuvinteBotoesTelaListarCorridas implements ActionListener {

	private TelaListarCorridasMototaxi tela;
	
	public OuvinteBotoesTelaListarCorridas(TelaListarCorridasMototaxi t) {
		tela = t;
	}

	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		if (componente == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomeMototaxista();
		}
	}

}
