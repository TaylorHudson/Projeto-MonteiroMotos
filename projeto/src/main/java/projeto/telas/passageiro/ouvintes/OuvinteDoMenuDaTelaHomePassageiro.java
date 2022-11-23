package projeto.telas.passageiro.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import projeto.telas.mototaxista.TelaEdicaoPerfil;
import projeto.telas.passageiro.TelaHomePassageiro;
import projeto.telas.usuario.TelaLogin;
import utilidades.fabricas.FabricaJOptionPane;

public class OuvinteDoMenuDaTelaHomePassageiro implements ActionListener {

	private TelaHomePassageiro tela;

	public void OuvinteTelaHomePassageiro(TelaHomePassageiro tela) {
		this.tela = tela;

	}

	public void actionPerformed(ActionEvent evento) {
		JMenuItem item = (JMenuItem) evento.getSource();

		if (item == tela.getItemSair()) {
			int opcSair = FabricaJOptionPane.criarMsgDeOpcao("Escolha uma opção", "Deseja sair?");
			tela.dispose();
			new TelaLogin();
		} else if (item == tela.getItemDeletar()) {
			int opcDeletar = FabricaJOptionPane.criarMsgDeOpcao("Escolha uma opção", "Deseja deletar sua conta?");
			if (opcDeletar == 0)
				System.out.println("Deletar a conta");
		} else {
			tela.dispose();
			new TelaEdicaoPerfil();
		}
	}
}
