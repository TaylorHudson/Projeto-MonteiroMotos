package projeto.telas.usuario.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.usuario.TelaCadastroUsuario;
import projeto.telas.usuario.TelaDeEnvioDeCodigo;
import projeto.telas.usuario.TelaLogin;

public class OuvinteTelaLogin implements ActionListener {

	private TelaLogin tela;

	public OuvinteTelaLogin(TelaLogin tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tela.getBtnCadastrese()) {
			tela.dispose();
			new TelaCadastroUsuario();

		} else {
			tela.dispose();
			new TelaDeEnvioDeCodigo();
		}
	}
	
}
