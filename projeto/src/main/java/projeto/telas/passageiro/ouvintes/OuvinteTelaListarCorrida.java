package projeto.telas.passageiro.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.modelo.Corrida;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.passageiro.TelaHomePassageiro;
import projeto.telas.passageiro.TelaListarCorridas;
import utilidades.persistencia.Persistencia;

public class OuvinteTelaListarCorrida implements ActionListener {

	private TelaListarCorridas tela;
	private CentralDeInformacoes central;
	private Persistencia persistencia = new Persistencia();

	public OuvinteTelaListarCorrida(TelaListarCorridas tela) {
		central = persistencia.recuperarCentral("central");
		this.tela = tela;

	}

	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == tela.getBtnDetalhes()) {

		} else if (evento.getSource() == tela.getBtnOrdenar()) {
			for (Corrida c : central.getCorridas()) {
				tela.getModelo().addRow(
						new String[] { c.getPassageiro().getNome(), c.getStatus().toString(), c.getData().toString() });
			}
		} else if (evento.getSource() == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomePassageiro();
		}

	}

}
