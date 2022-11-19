package projeto.telas.usuario.ouvintes;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import projeto.excecoes.usuario.CamposDiferentesException;
import projeto.excecoes.usuario.ConfirmacaoSenhaVaziaException;
import projeto.excecoes.usuario.SenhaInvalidaException;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
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
		try {
			if (novaSenha.isEmpty() || confirmacaoSenha.isEmpty()) {
				throw new ConfirmacaoSenhaVaziaException();
			} else if (novaSenha.equals(confirmacaoSenha) && !novaSenha.equals(senhaAntiga)) {
				Validador.validarSenha(novaSenha);
				usuario.setSenha(novaSenha);
				persistencia.salvarCentral(central, "central");
			} else if (!novaSenha.equals(confirmacaoSenha)) {
				throw new CamposDiferentesException();
			}
		} catch (SenhaInvalidaException | ConfirmacaoSenhaVaziaException |
				CamposDiferentesException erro) {
			FabricaJOptionPane.criarMsgErro(erro.getMessage());
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
