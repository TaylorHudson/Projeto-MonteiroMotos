package projeto.telas.passageiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utilidades.fabricas.FabricaJOptionPane;

public class OuvinteTelaHomePassageiro implements ActionListener {
	
	private TelaHomePassageiro tela;
	
	
	public OuvinteTelaHomePassageiro(TelaHomePassageiro tela) {
		this.tela = tela;
		
	}

	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == tela.getItemDeletar()) {
			int opc  = FabricaJOptionPane.criarInput("Atenção", "Tem certeza que você deseja deletar sua Conta?");
			System.out.println(opc);
		}
	}
}
