package projeto.telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import projeto.excecoes.usuario.CodigoInvalidoException;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.usuario.TelaDeMudarDeSenha;
import utilidades.email.Mensageiro;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;

public class OuvinteTelaLogin implements MouseListener {

	private TelaCadastroUsuario tela;
	private CentralDeInformacoes central;
	private Persistencia persistencia = new Persistencia();

	public OuvinteTelaLogin(TelaCadastroUsuario tela) {
		this.tela = tela;
		central = persistencia.recuperarCentral("central");
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tela.getBtnResetSenha()) {
			Usuario usuario = central.getUsuarios().get(0);
			int codigo = Mensageiro.enviarEmailComCodigoDeVerificacao(usuario);
			String codigoEmString = JOptionPane.showInputDialog("Digite o c�digo enviado por email");
			
			if (String.valueOf(codigo).equals(codigoEmString)) {
				tela.dispose();
				new TelaDeMudarDeSenha();
			}else {
				try {
					throw new CodigoInvalidoException();
				} catch (CodigoInvalidoException erro) {
					FabricaJOptionPane.criarMsgErro(erro.getMessage());
				}
			}
			
		}
		
		else if (e.getSource() == tela.getBtnEntrar()) {
			String email = tela.getTxtEmail().getText().trim();
			String senha = String.valueOf(tela.getTxtSenha().getPassword()).trim();
			Usuario usuario = central.recuperarUsuarioPeloEmail(email);
			if (usuario != null && usuario.getSenha().equals(senha))
				System.out.println("Logado");
			else
				System.out.println("Senha incorreta");
		}
		
	}

	public void mouseEntered(MouseEvent e) {
		e.getComponent().setForeground(new Color(255, 255, 255));
		e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void mouseExited(MouseEvent e) {
		e.getComponent().setForeground(new Color(179, 177, 177));
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
