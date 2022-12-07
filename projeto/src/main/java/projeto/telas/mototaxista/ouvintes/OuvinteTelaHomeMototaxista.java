package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.mototaxista.TelaComprarCreditos;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import projeto.telas.mototaxista.TelaListarCorridasMototaxi;
import utilidades.persistencia.Persistencia;

public class OuvinteTelaHomeMototaxista implements ActionListener {

	private TelaHomeMototaxista tela;
	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central;

	public OuvinteTelaHomeMototaxista(TelaHomeMototaxista tela) {
		central = persistencia.recuperarCentral("central");
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn == tela.getBtnListarCorridas()) {
			tela.dispose();
			new TelaListarCorridasMototaxi();
		}else if(btn == tela.getBtnComprarCreditos()) {
			tela.dispose();
			new TelaComprarCreditos();
		}
	}
}
