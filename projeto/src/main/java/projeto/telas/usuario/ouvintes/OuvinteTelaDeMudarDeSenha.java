package projeto.telas.usuario.ouvintes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.usuario.TelaDeMudarDeSenha;
import utilidades.persistencia.Persistencia;

public class OuvinteTelaDeMudarDeSenha implements MouseListener {

	private TelaDeMudarDeSenha tela;
	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central;

	public OuvinteTelaDeMudarDeSenha(TelaDeMudarDeSenha tela) {
		this.tela = tela;
		central = persistencia.recuperarCentral("central");
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {
		e.getComponent().setForeground(new Color(255, 255, 255));
		e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void mouseExited(MouseEvent e) {
		e.getComponent().setForeground(new Color(179, 177, 177));
		e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
