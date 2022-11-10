package projeto.telas.usuario.ouvintes;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import projeto.telas.TelaLogin;
import projeto.telas.usuario.TelaDeMudarDeSenha;

public class OuvinteTelaDeMudarDeSenha implements MouseListener{

	private TelaDeMudarDeSenha tela;
	
	public OuvinteTelaDeMudarDeSenha(TelaDeMudarDeSenha tela) {
		this.tela = tela;
	}
	
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		e.getComponent().setForeground(new Color(255, 255, 255));
	}

	public void mouseExited(MouseEvent e) {
		e.getComponent().setForeground(new Color(179,177,177));
	}

	
	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
