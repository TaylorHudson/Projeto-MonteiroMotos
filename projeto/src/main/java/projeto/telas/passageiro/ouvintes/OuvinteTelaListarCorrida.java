package projeto.telas.passageiro.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import projeto.modelo.Corrida;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.passageiro.TelaDeDetalhesPassageiro;
import projeto.telas.passageiro.TelaHomePassageiro;
import projeto.telas.passageiro.TelaListarCorridas;
import utilidades.fabricas.FabricaJOptionPane;
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
		if (evento.getSource() == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomePassageiro();
		}

	}

}
