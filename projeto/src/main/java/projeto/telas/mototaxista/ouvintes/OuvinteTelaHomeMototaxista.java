package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.TelaLogin;
import projeto.telas.mototaxista.TelaEdicaoPerfil;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import projeto.telas.mototaxista.TelaListarCorridas;
import utilidades.fabricas.FabricaJOptionPane;

public class OuvinteTelaHomeMototaxista implements ActionListener {

	private TelaHomeMototaxista tela;

	public OuvinteTelaHomeMototaxista(TelaHomeMototaxista tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Deletar Perfil")) {
			int opcDeletar = FabricaJOptionPane.criarInput("Escolha uma opção", "Deseja deletar sua conta?");
			if (opcDeletar == 0)
				System.out.println("Deletar a conta");

			else if (e.getActionCommand().equals("Editar Perfil")) {
				tela.dispose();
				new TelaEdicaoPerfil();
			}

			else if (e.getActionCommand().equals("Sair")) {
				int opcSair = FabricaJOptionPane.criarInput("Escolha uma opção", "Deseja sair realmente?");
				if (opcSair == 0) {
					tela.dispose();
					new TelaLogin();
				}

			} else if (e.getActionCommand().equals("Listar Corridas")) {
				tela.dispose();
				new TelaListarCorridas();
			}
			
		}
	}
}
