package projeto.telas.ADM.ouvintes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import projeto.telas.ADM.TelaDadosDosUsuarios;

public class OuvinteTelaDadosDosUsuarios implements MouseListener {
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

	
	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	
	public void mouseReleased(MouseEvent e) {

	}

	
	public void mouseEntered(MouseEvent e) {
		e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
		e.getComponent().setForeground(new Color(179, 177, 177));

	}

	public void mouseExited(MouseEvent e) {
		e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		e.getComponent().setForeground(Color.WHITE);

	}

}
