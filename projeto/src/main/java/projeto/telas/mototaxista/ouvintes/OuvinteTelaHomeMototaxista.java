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
				int opcDeletar = FabricaJOptionPane.criarInput("Escolha uma opção", "Deseja deletar sua conta?");
				if(opcDeletar == 0) {
					System.out.println("Deletar a conta");
				}
				break;
			case "Editar Perfil":
				tela.dispose();
				new TelaEdicaoPerfil();
				break;
			case "Sair":
			int opcSair = FabricaJOptionPane.criarInput("Escolha uma opção", "Deseja sair realmente?");
      if (opcSair == 0) {
        tela.dispose();
        new TelaLoginUsuario();
      }  
				break;
		}
	}
}
