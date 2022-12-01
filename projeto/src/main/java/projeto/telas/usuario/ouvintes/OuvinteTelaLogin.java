package projeto.telas.usuario.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import projeto.excecoes.usuario.UsuarioInativoException;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.excecoes.usuario.ValidacaoException;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import projeto.telas.passageiro.TelaHomePassageiro;
import projeto.telas.usuario.TelaCadastroUsuario;
import projeto.telas.usuario.TelaDeEnvioDeCodigo;
import projeto.telas.usuario.TelaLogin;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;
import utilidades.validacao.Validador;

public class OuvinteTelaLogin implements ActionListener {

	private TelaLogin tela;
	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central;

	public OuvinteTelaLogin(TelaLogin tela) {
		this.tela = tela;
		central = persistencia.recuperarCentral("central");
	}

	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		if (componente == tela.getBtnCadastrese()) {
			tela.dispose();
			new TelaCadastroUsuario();
		} else if (componente == tela.getBtnResetSenha()) {
			tela.dispose();
			new TelaDeEnvioDeCodigo();
		}
	}

}
