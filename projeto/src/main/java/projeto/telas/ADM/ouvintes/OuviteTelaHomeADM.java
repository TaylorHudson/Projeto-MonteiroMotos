package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.ADM.TelaHomeADM;

public class OuviteTelaHomeADM implements ActionListener{
private TelaHomeADM tela;
	
	public OuviteTelaHomeADM(TelaHomeADM tela) {
		this.tela = tela;
	}
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Editar Perfil":
				tela.dispose();
				break;
			case "Lista de Corridas":
				tela.dispose();
				break;
			case "Definir Valor dos CrÃ©ditos":
				tela.dispose();
				break;
		}
	}
}

