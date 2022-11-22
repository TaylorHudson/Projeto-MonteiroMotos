package projeto.telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.passageiro.TelaHomePassageiro;
import utilidades.persistencia.Persistencia;

public class OuvinteTelaLogin implements MouseListener {

	private TelaLogin tela;
	private CentralDeInformacoes central;
	private Persistencia persistencia = new Persistencia();

	public OuvinteTelaLogin(TelaLogin tela) {
		this.tela = tela;
		central = persistencia.recuperarCentral("central");
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tela.getBtnResetSenha()) {

		} else if (e.getSource() == tela.getBtnEntrar()) {
			String email = tela.getTxtEmail().getText().trim();
			String senha = String.valueOf(tela.getTxtSenha().getPassword()).trim();

			switch (tela.getBox().getSelectedIndex()) {
				case 0:
					break;
				case 1:
					boolean valido = central.validarPassageiro(email, senha);
					if (valido) new TelaHomePassageiro();
					break;
			}

		}
	}

	public void mouseEntered(MouseEvent e) {
		e.getComponent().setForeground(new Color(66, 65, 65));
		e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void mouseExited(MouseEvent e) {
		e.getComponent().setForeground(new Color(15, 15, 15));
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
