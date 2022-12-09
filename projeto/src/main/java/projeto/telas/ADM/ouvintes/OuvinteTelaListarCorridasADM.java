package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import projeto.modelo.Corrida;
import projeto.modelo.Mototaxista;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.ADM.TelaDetalhesDaCorridaADM;
import projeto.telas.ADM.TelaHomeADM;
import projeto.telas.ADM.TelaListarCorridasADM;
import projeto.telas.passageiro.TelaDeDetalhesPassageiro;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;

public class OuvinteTelaListarCorridasADM implements ActionListener {
	private TelaListarCorridasADM tela;
	private Persistencia p = new Persistencia();
	private CentralDeInformacoes central = p.recuperarCentral("central");

	public OuvinteTelaListarCorridasADM(TelaListarCorridasADM tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		String tipo = (String) tela.getBox().getSelectedItem();
		int var = tela.getTabelaListarCorridas().getSelectedRow();
		if (btn == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomeADM();
		} else if (btn == tela.getBtnOrdenar()) {
			if (tipo.equals("Finalizada")) {
				tela.getModelo().setRowCount(0);
				tela.popularTabelaFinalizada();
				tela.repaint();

			} else if (tipo.equals("Espera")) {
				tela.getModelo().setRowCount(0);
				tela.popularTabelaEspera();
				tela.repaint();
			}
		} else if (btn == tela.getBtnDetalhes()) {
			if (tela.getTabelaListarCorridas().getSelectedRow() == -1) {
				FabricaJOptionPane.criarMsgErro("Selecione Alguma corrida");
			} else {
				long idSelecionado = (long) tela.getTabelaListarCorridas().getValueAt(var, 3);

				Corrida corrida = central.recuperarCorridaPeloId(idSelecionado);
				tela.dispose();
				new TelaDetalhesDaCorridaADM(corrida);
			}
		}

	}

}
