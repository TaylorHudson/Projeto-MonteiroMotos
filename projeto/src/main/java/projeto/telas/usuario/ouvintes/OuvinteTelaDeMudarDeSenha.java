package projeto.telas.usuario.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.usuario.TelaDeMudarDeSenha;
import utilidades.persistencia.Persistencia;

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
	}
}
