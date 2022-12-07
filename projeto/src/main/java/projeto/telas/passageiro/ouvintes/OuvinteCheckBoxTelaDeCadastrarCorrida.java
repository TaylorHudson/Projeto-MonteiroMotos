package projeto.telas.passageiro.ouvintes;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import projeto.modelo.enuns.StatusDaCorrida;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.passageiro.TelaDeCadastrarCorrida;

public class OuvinteCheckBoxTelaDeCadastrarCorrida implements ItemListener {

	CentralDeInformacoes central = new CentralDeInformacoes();

	private TelaDeCadastrarCorrida tela;

	public OuvinteCheckBoxTelaDeCadastrarCorrida(TelaDeCadastrarCorrida tela) {
		this.tela = tela;

	}

	public void itemStateChanged(ItemEvent e) {

		if (tela.getCheckBoxParaAgora().isSelected()) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			tela.getTxtHora().setText(sdf.format(new Date()));
			tela.getTxtHora().setEnabled(false);
			tela.setHorario(StatusDaCorrida.PARAAGORA);
			tela.getChooser().setEnabled(false);
		} else {
			tela.getChooser().setEnabled(true);
			tela.getTxtHora().setEnabled(true);

		}
		if (tela.getCheckBoxParaDepois().isSelected()) {
			tela.setHorario(StatusDaCorrida.PARADEPOIS);
		}
	}

}
