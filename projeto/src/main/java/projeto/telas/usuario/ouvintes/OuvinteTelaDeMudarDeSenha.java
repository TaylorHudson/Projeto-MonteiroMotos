package projeto.telas.usuario.ouvintes;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import projeto.excecoes.usuario.SenhaInvalidaException;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.TelaLogin;
import projeto.telas.usuario.TelaDeMudarDeSenha;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;
import utilidades.validacao.Validador;

public class OuvinteTelaDeMudarDeSenha implements MouseListener {

	private TelaDeMudarDeSenha tela;
	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central;

	public OuvinteTelaDeMudarDeSenha(TelaDeMudarDeSenha tela) {
		this.tela = tela;
		central = persistencia.recuperarCentral("central");
	}

	public void mouseClicked(MouseEvent e) {
		Usuario usuario = central.getUsuarios().get(0);

		String novaSenha = tela.getTxtNovaSenha().getText();
		String confirmacaoSenha = tela.getTxtConfirmarSenha().getText();

		String senhaAntiga = usuario.getSenha();
		if (novaSenha.equals(confirmacaoSenha) && !novaSenha.equals(senhaAntiga)) {
			try {
				Validador.validarSenha(novaSenha);
				usuario.setSenha(novaSenha);
				persistencia.salvarCentral(central, "central");
			} catch (SenhaInvalidaException erro) {
				FabricaJOptionPane.criarMsgErro(erro.getMessage());
			}
		} else {
			System.out.println("eretfshgdz");
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
