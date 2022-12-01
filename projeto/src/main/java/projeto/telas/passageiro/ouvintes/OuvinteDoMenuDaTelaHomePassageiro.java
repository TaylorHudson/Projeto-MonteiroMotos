package projeto.telas.passageiro.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import projeto.telas.mototaxista.TelaEdicaoPerfil;
import projeto.telas.passageiro.TelaHomePassageiro;
import projeto.telas.usuario.TelaLogin;
import utilidades.fabricas.FabricaJOptionPane;

public class OuvinteDoMenuDaTelaHomePassageiro implements ActionListener {

	private TelaHomePassageiro tela;

	public OuvinteDoMenuDaTelaHomePassageiro(TelaHomePassageiro tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent evento) {
		JMenuItem item = (JMenuItem) evento.getSource();

		if (item == tela.getItemSair()) {
			int opcSair = FabricaJOptionPane.criarMsgDeOpcao("Escolha", "Deseja sair?");
			if (opcSair == JOptionPane.YES_OPTION) {
				tela.dispose();
				new TelaLogin();
			}
		} else if (item == tela.getItemDeletar()) {
			int opcDeletar = FabricaJOptionPane.criarMsgDeOpcao("Escolha", "Deseja deletar sua conta?");
			if (opcDeletar == JOptionPane.YES_OPTION)
				System.out.println("Deletar a conta");
		} else if(item == tela.getItemEditar()){
			tela.dispose();
			new TelaEdicaoPerfil();
		}
	}
}
