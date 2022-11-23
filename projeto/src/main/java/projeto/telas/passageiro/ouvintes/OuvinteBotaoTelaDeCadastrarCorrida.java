package projeto.telas.passageiro.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import projeto.telas.passageiro.TelaDeCadastrarCorrida;
import projeto.telas.passageiro.TelaHomePassageiro;
import utilidades.fabricas.FabricaJOptionPane;

public class OuvinteBotaoTelaDeCadastrarCorrida implements ActionListener {

	private TelaDeCadastrarCorrida tela;

	public OuvinteBotaoTelaDeCadastrarCorrida(TelaDeCadastrarCorrida tela) {
		this.tela = tela;

	}

	public void actionPerformed(ActionEvent evento) {
		JButton item = (JButton) evento.getSource();

		try {

			System.out.println(tela.getTxtHora().getText());
		} catch (Exception e) {
			FabricaJOptionPane.criarMsgErro("Hora Invalida");
			tela.getTxtHora().setText("");
			e.printStackTrace();
		}
		if (item == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomePassageiro();

		} else if (item == tela.getBtnSalvar()) {

			if (tela.getHorario() != null) {
				System.out.println(tela.getHorario());
			} else {
				FabricaJOptionPane.criarMsgErro("Os campos De seleção devem estar selecionados.");

			}

		}

	}
}
