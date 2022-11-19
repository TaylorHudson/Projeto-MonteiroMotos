package projeto.telas.passageiro.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.passageiro.TelaListarCorridas;
import utilidades.fabricas.FabricaJOptionPane;

public class OuvinteTelaListarCorrida implements ActionListener {

	private TelaListarCorridas tela;

	public OuvinteTelaListarCorrida(TelaListarCorridas tela) {
		this.tela = tela;

	}

	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == tela.getBtnDetalhes()){
			System.out.println("Teste detalhes");
		}else if(evento.getSource() == tela.getBtnOrdenar()) {
			System.out.println("teste ordenar");
		}
		
	}

}
