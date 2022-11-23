package projeto.telas.ADM.ouvintes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import projeto.telas.ADM.TelaDadosDosUsuarios;
import projeto.telas.ADM.TelaHomeADM;

public class OuvinteTelaDadosDosUsuarios implements ActionListener {
	private TelaDadosDosUsuarios tela;

	public OuvinteTelaDadosDosUsuarios(TelaDadosDosUsuarios tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if(btn == tela.getBtnDetalhes()) {
			tela.dispose();
		}else if(btn == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomeADM();
		}

	}

}
