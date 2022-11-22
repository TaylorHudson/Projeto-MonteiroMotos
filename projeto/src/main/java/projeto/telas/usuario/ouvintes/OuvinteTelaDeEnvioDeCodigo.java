package projeto.telas.usuario.ouvintes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import projeto.excecoes.usuario.ValidacaoException;
import projeto.telas.usuario.TelaDeEnvioDeCodigo;
import projeto.telas.usuario.TelaDeMudarDeSenha;
import utilidades.email.Mensageiro;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.validacao.Validador;

public class OuvinteTelaDeEnvioDeCodigo implements MouseListener {

	private TelaDeEnvioDeCodigo tela;

	public OuvinteTelaDeEnvioDeCodigo(TelaDeEnvioDeCodigo tela) {
		this.tela = tela;
	}

	public void mouseClicked(MouseEvent e) {
		String email = tela.getTxtEmail().getText();
		try {
			boolean valido = Validador.validarEmail(email);
			if (valido) {
				int codigo = Mensageiro.enviarEmailComCodigoDeVerificacao(email);
				int codigoDoUsuario = FabricaJOptionPane.criarInput("Digite seu codigo de Confirmação");
				if (codigo == codigoDoUsuario) {
					tela.dispose();
					new TelaDeMudarDeSenha();
				} else {
					FabricaJOptionPane.criarMsgErro("Codigo Invalido");
					tela.getTxtEmail().setText("");
				}
			}

		} catch (ValidacaoException erro) {
			FabricaJOptionPane.criarMsgErro(erro.getMessage());

		}

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {
		e.getComponent().setForeground(new Color(66, 65, 65));
		e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

	public void mouseExited(MouseEvent e) {
		e.getComponent().setForeground(Color.black);
		e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

	}

}
