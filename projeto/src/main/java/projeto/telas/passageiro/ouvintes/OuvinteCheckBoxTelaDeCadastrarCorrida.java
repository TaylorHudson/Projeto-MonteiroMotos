package projeto.telas.passageiro.ouvintes;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import projeto.modelo.enuns.HorarioDaCorrida;
import projeto.modelo.enuns.Sexo;
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
			tela.setHorario(HorarioDaCorrida.PARAAGORA);
		}
		if (tela.getCheckBoxParaDepois().isSelected()) {
			tela.setHorario(HorarioDaCorrida.PARADEPOIS);
		}
	}

}
