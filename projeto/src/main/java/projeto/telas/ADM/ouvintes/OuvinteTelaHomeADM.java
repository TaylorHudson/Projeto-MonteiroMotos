package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import projeto.telas.ADM.TelaDadosDosUsuarios;
import projeto.telas.ADM.TelaHomeADM;

public class OuvinteTelaHomeADM implements ActionListener{
	
	private TelaHomeADM tela;
	
	public OuvinteTelaHomeADM(TelaHomeADM tela) {
		this.tela = tela;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == tela.getBtnDadosDosUsuarios()) {
			tela.dispose();
			new TelaDadosDosUsuarios();
		}else {
			tela.dispose();
		}
	
	}
}
