package projeto.telas.ADM.ouvintes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import projeto.telas.ADM.TelaDadosDosUsuarios;

public class OuvinteTabelaTelaDadosDosUsuarios implements MouseListener {
	private TelaDadosDosUsuarios tela;

	public OuvinteTabelaTelaDadosDosUsuarios(TelaDadosDosUsuarios tela) {
		this.tela = tela;
		
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
		e.getComponent().setForeground(Color.black);

	}

}
