package projeto.telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import utilidades.email.Mensageiro;
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
		String email = tela.getTxtEmail().getText().trim();
		String senha = String.valueOf(tela.getTxtSenha().getPassword()).trim();
		Usuario usuario = central.recuperarUsuarioPeloEmail(email);
		
		if (e.getSource() == tela.getBtnEntrar()) {
			if (usuario != null && usuario.getSenha().equals(senha))
				System.out.println("Logado");
			else
				System.out.println("Senha incorreta");
		}
		if(e.getSource() == tela.getBtnResetSenha()) {
			int codigo = Mensageiro.enviarEmailComCodigoDeVerificacao(usuario);
			JOptionPane.showInputDialog("Digite o código que foi enviado para seu email:");
		}
	}

	public void mouseEntered(MouseEvent e) {
		e.getComponent().setForeground(new Color(255, 255, 255));
	}

	public void mouseExited(MouseEvent e) {
		e.getComponent().setForeground(new Color(179, 177, 177));
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
