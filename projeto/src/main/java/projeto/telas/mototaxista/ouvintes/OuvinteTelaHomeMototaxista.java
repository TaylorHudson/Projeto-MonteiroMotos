package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import projeto.telas.mototaxista.TelaHomeMototaxista;
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
			case "Editar Perfil":
				tela.dispose();
		}
	}
}
