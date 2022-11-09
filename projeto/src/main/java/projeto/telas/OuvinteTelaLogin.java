package projeto.telas;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
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
		if (e.getSource() == tela.getBtnEntrar()) {
			String email = tela.getTxtEmail().getText().trim();
			String senha = String.valueOf(tela.getTxtSenha().getPassword()).trim();
			Usuario usuario = central.recuperarUsuarioPeloEmail(email);

			if (usuario != null) {
				if (usuario.getSenha().equals(senha))
					System.out.println("Logado");
				else {
					System.out.println("Senha incorreta");
				}
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == tela.getBtnEntrar())
			tela.getBtnEntrar().setForeground(new Color(255, 255, 255));
		if (e.getSource() == tela.getBtnResetSenha())
			tela.getBtnResetSenha().setForeground(new Color(255, 255, 255));
	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource() == tela.getBtnEntrar())
			tela.getBtnEntrar().setForeground(new Color(179, 177, 177));
		if (e.getSource() == tela.getBtnResetSenha())
			tela.getBtnResetSenha().setForeground(new Color(179, 177, 177));
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
