package projeto.telas.passageiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utilidades.fabricas.FabricaJOptionPane;

public class OuvinteTelaListarCorrida implements ActionListener {

	private TelaListarCorridas tela;

	public OuvinteTelaListarCorrida(TelaListarCorridas tela) {
		this.tela = tela;
		
	}
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() ==  tela.getItemSair()) {
			int opc = FabricaJOptionPane.criarInput("Atenção", "Tem certeza que deseja sair?");
		}
		
		
	}

}
