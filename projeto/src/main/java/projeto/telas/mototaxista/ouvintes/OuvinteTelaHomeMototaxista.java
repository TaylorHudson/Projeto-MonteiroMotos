package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.mototaxista.TelaEdicaoPerfil;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import projeto.telas.usuario.TelaLoginUsuario;
import utilidades.fabricas.FabricaJOptionPane;

public class OuvinteTelaHomeMototaxista implements ActionListener {

	private TelaHomeMototaxista tela;

	public OuvinteTelaHomeMototaxista(TelaHomeMototaxista tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Deletar Perfil":
				int opc = FabricaJOptionPane.criarInput("Escolha uma opção", "Deseja deletar sua conta?");
				System.out.println(opc);
				break;
			case "Editar Perfil":
				tela.dispose();
				new TelaEdicaoPerfil();
				break;
			case "Sair":
				new TelaLoginUsuario();
				break;
		}
	}
}
