package projeto.telas.usuario.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.TelaPadrao;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.excecoes.usuario.ValidacaoException;
import projeto.modelo.Mototaxista;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.ADM.TelaHomeADM;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import projeto.telas.passageiro.TelaHomePassageiro;
import projeto.telas.usuario.TelaLogin;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;
import utilidades.validacao.Validador;

public class OuvinteBotaoEntrarTelaLogin implements ActionListener {

	private TelaLogin tela;
	private CentralDeInformacoes central;
	private Persistencia persistencia = new Persistencia();

	public OuvinteBotaoEntrarTelaLogin(TelaLogin tela) {
		this.tela = tela;
		central = persistencia.recuperarCentral("central");
	}

	public void actionPerformed(ActionEvent e) {
		String email = tela.getTxtEmail().getText().trim();
		String senha = String.valueOf(tela.getTxtSenha().getPassword());
		String tipoUsuario = (String) tela.getBox().getSelectedItem();

		Usuario adm = central.getAdministrador();
		if (adm != null && adm.getEmail().equals(email) && adm.getSenha().equals(senha)) {
			tela.dispose();
			new TelaHomeADM();
		} else {
			try {
				if (tipoUsuario.equals("Mototaxista")) {
					Validador.logarMototaxista(email, senha, central);
					Mototaxista mototaxista = central.recuperarMototaxistaPeloEmail(email);
					TelaPadrao.mototaxistaLogado = mototaxista;
					tela.dispose();
					new TelaHomeMototaxista();
				} else if (tipoUsuario.equals("Passageiro")) {
					Validador.logarPassageiro(email, senha, central);
					tela.dispose();
					new TelaHomePassageiro();
				}
			} catch (ValidacaoException | UsuarioNaoExisteException erro) {
				FabricaJOptionPane.criarMsgErro(erro.getMessage());
			}
		}
	}

}
