package projeto.telas.passageiro.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import projeto.modelo.Corrida;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.passageiro.TelaHomePassageiro;
import projeto.telas.passageiro.TelaListarCorridas;
import utilidades.persistencia.Persistencia;

public class OuvinteTelaListarCorrida implements ActionListener {

	private TelaListarCorridas tela;
	private CentralDeInformacoes central;
	private Persistencia persistencia = new Persistencia();
	private ArrayList<Corrida> corridasSendoExibidas;

	public OuvinteTelaListarCorrida(TelaListarCorridas tela) {
		central = persistencia.recuperarCentral("central");
		this.tela = tela;

	}

	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == tela.getBtnDetalhes()) {

		} else if (evento.getSource() == tela.getBtnOrdenar()) {

		} else if (evento.getSource() == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomePassageiro();
		}

	}

}
