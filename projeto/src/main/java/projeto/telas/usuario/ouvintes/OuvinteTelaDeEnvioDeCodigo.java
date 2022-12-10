package projeto.telas.usuario.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.excecoes.usuario.ValidacaoException;
import projeto.telas.usuario.TelaDeEnvioDeCodigo;
import projeto.telas.usuario.TelaDeMudarDeSenha;
import projeto.telas.usuario.TelaLogin;
import utilidades.email.Mensageiro;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.validacao.Validador;

public class OuvinteTelaDeEnvioDeCodigo implements ActionListener {

	private TelaDeEnvioDeCodigo tela;

	public OuvinteTelaDeEnvioDeCodigo(TelaDeEnvioDeCodigo tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		String email = tela.getTxtEmail().getText();

		if (e.getSource() == tela.getBtnSeta()) {
			tela.dispose();
			new TelaLogin();
		} else {
			try {
				boolean valido = Validador.validarEmail(email);
				if (valido) {
					int c = Mensageiro.enviarEmailComCodigoDeVerificacao(email);
					String codigoDoUsuario = FabricaJOptionPane.criarInput("Digite seu codigo de Confirmação");
					String codigo = String.valueOf(c);
					if (codigo.equals(codigoDoUsuario)) {
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
	}

}
