package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import projeto.telas.ADM.TelaDadosDosUsuarios;
import projeto.telas.ADM.TelaDeEdicaoDosDadosDosUsuarios;

public class OuvinteTelaDeEdicaoDosDadosDosUsuarios implements ActionListener {
	private TelaDeEdicaoDosDadosDosUsuarios tela;
	
	public OuvinteTelaDeEdicaoDosDadosDosUsuarios(TelaDeEdicaoDosDadosDosUsuarios tela) {
		this.tela = tela;
	}
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if(btn == tela.getBtnEnviarEmail()) {
			tela.dispose();
		}else if(btn == tela.getBtnSeta()) {
			tela.dispose();
			new TelaDadosDosUsuarios();
		}
	}

}
