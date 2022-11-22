package projeto.telas.ADM.ouvintes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import projeto.telas.ADM.TelaCadastroADM;

public class OuvintesTelaDeCadastroADM implements MouseListener {

	private TelaCadastroADM tela;

	public OuvintesTelaDeCadastroADM(TelaCadastroADM tela) {
		this.tela = tela;
	}

	public void mouseClicked(MouseEvent e) {
		String nomeCompleto = tela.getTxtNomeCompleto().getText();
		String senha = String.valueOf(tela.getTxtSenha().getPassword());
		String email = tela.getTxtEmail().getText();
		String dataNascimento = tela.getTxtData().getText();
		System.out.println(dataNascimento);
	}

	public void mouseEntered(MouseEvent e) {
		e.getComponent().setForeground(new Color(81, 82, 82));
		e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void mouseExited(MouseEvent e) {
		e.getComponent().setForeground(Color.BLACK);
		e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
