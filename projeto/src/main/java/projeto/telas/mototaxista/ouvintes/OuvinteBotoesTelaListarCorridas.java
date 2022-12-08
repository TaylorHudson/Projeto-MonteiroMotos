package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.table.DefaultTableModel;

import projeto.modelo.Corrida;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import projeto.telas.mototaxista.TelaListarCorridasMototaxi;
import utilidades.persistencia.Persistencia;

public class OuvinteBotoesTelaListarCorridas implements ActionListener {

	private TelaListarCorridasMototaxi tela;
	private CentralDeInformacoes central;
	private Persistencia persistencia = new Persistencia();

	public OuvinteBotoesTelaListarCorridas(TelaListarCorridasMototaxi t) {
		central = persistencia.recuperarCentral("central");
		tela = t;
	}

	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		
		if (componente == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomeMototaxista();
		} 
		else if (componente == tela.getBtnOrdenar()) {
			DefaultTableModel modelo = tela.getModelo();
			ArrayList<Corrida> corridas = central.getCorridas();
			Collections.sort(corridas, corridas.get(0));
			modelo.setRowCount(0);
			for (Corrida c : corridas) tela.addLinha(modelo, c);
			tela.getScrol().repaint();
		}
	}

}
