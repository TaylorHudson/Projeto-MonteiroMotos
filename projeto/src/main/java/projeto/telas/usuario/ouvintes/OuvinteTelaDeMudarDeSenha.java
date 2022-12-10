package projeto.telas.usuario.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.excecoes.usuario.ValidacaoException;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.usuario.TelaDeMudarDeSenha;
import projeto.telas.usuario.TelaLogin;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;
import utilidades.validacao.Validador;

public class OuvinteTelaDeMudarDeSenha implements ActionListener {

	private TelaDeMudarDeSenha tela;
	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central;

	public OuvinteTelaDeMudarDeSenha(TelaDeMudarDeSenha tela) {
		this.tela = tela;
		central = persistencia.recuperarCentral("central");
	}

	public void actionPerformed(ActionEvent e) {
		String novaSenha = tela.getTxtNovaSenha().getText().trim();
		String confirmacaoSenha = tela.getTxtConfirmarSenha().getText().trim();
		try {
			if (novaSenha.equals(confirmacaoSenha)) {
				central.atualizarSenha(tela.getEmail(), novaSenha);
				persistencia.salvarCentral(central, "central");
				FabricaJOptionPane.criarMsg("Senha atualizada com sucesso");
				tela.dispose();
				new TelaLogin();
			} else FabricaJOptionPane.criarMsgErro("As senhas não coincidem");
		} catch (ValidacaoException e1) {
			FabricaJOptionPane.criarMsgErro(e1.getMessage());
		}
	}
}
