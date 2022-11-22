package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.ADM.TelaDadosDosUsuarios;

public class OuvinteTelaDadosDosUsuarios implements ActionListener {
private TelaDadosDosUsuarios tela;
	
	public OuvinteTelaDadosDosUsuarios(TelaDadosDosUsuarios tela) {
		this.tela = tela;
	}
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Passageiro":
				tela.dispose();
				break;
			case "Moto-Taxista":
				tela.dispose();
				break;
		}
	}

}

