package projeto.telas.passageiro.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.passageiro.TelaDeCadastrarCorrida;
import utilidades.fabricas.FabricaJOptionPane;

public class OuvinteBotaoTelaDeCadastrarCorrida implements ActionListener {

	private TelaDeCadastrarCorrida tela;

	public OuvinteBotaoTelaDeCadastrarCorrida(TelaDeCadastrarCorrida tela) {
		this.tela = tela;

	}

	public void actionPerformed(ActionEvent e) {
		if (tela.getHorario() == null) {
			FabricaJOptionPane.criarMsgErro("Os campos De seleção devem estar selecionados.");
		} else {
			System.out.println(tela.getHorario());
		}
	}
}
