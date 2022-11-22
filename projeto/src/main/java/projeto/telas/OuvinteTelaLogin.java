package projeto.telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.ADM.TelaHomeADM;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import projeto.telas.passageiro.TelaHomePassageiro;
import projeto.telas.usuario.TelaCadastroUsuario;
import projeto.telas.usuario.TelaDeMudarDeSenha;
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
			String tipo = "";
			switch (tela.getBox().getSelectedIndex()) {
				case 0:
					tipo = "mototaxista";
					break;
				case 1:
					tipo = "passageiro";
					break;
			}

			Usuario adm = central.getAdministrador();
			if (adm.getEmail().equals(email) && adm.getSenha().equals(senha)) {
				tela.dispose();
				new TelaHomeADM();
			}

			else if (tipo.equals("mototaxista")) {
				Mototaxista mototaxista = central.recuperarMototaxistaPeloEmail(email);
				if (mototaxista != null && mototaxista.getSenha().equals(senha)) {
					tela.dispose();
					new TelaHomeMototaxista();
				}
			}

			else {
				Passageiro passageiro = central.recuperarPassageiroPeloEmail(email);
				if (passageiro != null && passageiro.getSenha().equals(senha)) {
					tela.dispose();
					new TelaHomePassageiro();
				}
			}
		}

		else if (e.getSource() == tela.getBtnCadastrese()) {
			tela.dispose();
			new TelaCadastroUsuario();
		
		}else if(e.getSource() == tela.getBtnResetSenha()) {
			new TelaDeMudarDeSenha();
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
