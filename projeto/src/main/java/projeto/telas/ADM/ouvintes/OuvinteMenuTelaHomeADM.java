package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import projeto.telas.ADM.TelaHomeADM;
import projeto.telas.ADM.TelaValorDeCreditosADM;
import projeto.telas.usuario.TelaLogin;
import utilidades.fabricas.FabricaJOptionPane;

public class OuvinteMenuTelaHomeADM implements ActionListener {
	
	private TelaHomeADM tela;
	
	public OuvinteMenuTelaHomeADM(TelaHomeADM tela) {
		this.tela = tela;
	}
	
	public void actionPerformed(ActionEvent e) {
	    JMenuItem item = (JMenuItem) e.getSource();

	    if(item == tela.getItemEditar()) {
	      tela.dispose();
	    }else if(item == tela.getItemListaDeCorridas()) {
	    	tela.dispose();
	    }else if(item == tela.getItemDefinirValorDosCreditos()) {
	    	tela.dispose();
	    	new TelaValorDeCreditosADM();
	    }else {
	    	int opcSair = FabricaJOptionPane.criarMsgDeOpcao("Escolha uma opção", "Deseja sair da sua conta?");
			if (opcSair == 0) {
				tela.dispose();
				new TelaLogin();
			}
	    }
	}
}
