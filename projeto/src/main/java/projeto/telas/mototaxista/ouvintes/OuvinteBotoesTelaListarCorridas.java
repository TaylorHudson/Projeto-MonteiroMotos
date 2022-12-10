package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.table.DefaultTableModel;

import projeto.TelaPadrao;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.modelo.Corrida;
import projeto.modelo.Mototaxista;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import projeto.telas.mototaxista.TelaListarCorridasMototaxi;
import projeto.telas.mototaxista.TelaReivindicarCorrida;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;

public class OuvinteBotoesTelaListarCorridas implements ActionListener {

	private TelaListarCorridasMototaxi tela;
	private CentralDeInformacoes central;
	private Persistencia persistencia = new Persistencia();

	public OuvinteBotoesTelaListarCorridas(TelaListarCorridasMototaxi t) {
		central = persistencia.recuperarCentral("central");
		tela = t;
	}

	private void reivindicarCorrida() {
		Mototaxista mototaxistaLogado = TelaPadrao.mototaxistaLogado;
		Mototaxista mototaxista;
		try {
			mototaxista = central.recuperarMototaxistaPeloEmail(mototaxistaLogado.getEmail());
			mototaxista.setCreditosReivindicacao(mototaxista.getCreditosReivindicacao() - 1);
			TelaPadrao.mototaxistaLogado = mototaxista;
		} catch (UsuarioNaoExisteException e) {
		}

	}

	public void actionPerformed(ActionEvent e) {

		Object componente = e.getSource();
		Mototaxista mototaxistaLogado = TelaPadrao.mototaxistaLogado;
		Mototaxista mototaxista = null;
		try {
			mototaxista = central.recuperarMototaxistaPeloEmail(mototaxistaLogado.getEmail());
		} catch (UsuarioNaoExisteException e1) {
		}

		if (componente == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomeMototaxista();
		}

		else if (componente == tela.getBtnOrdenar()) {
			DefaultTableModel modelo = tela.getModelo();
			ArrayList<Corrida> corridas = central.getCorridas();
			Collections.sort(corridas, corridas.get(0));
			modelo.setRowCount(0);
			for (Corrida c : corridas)
				tela.addLinha(modelo, c);
			tela.getScrol().repaint();
		}

		else if (componente == tela.getBtnReivindicarCorrida()) {
			int linhaSelecionada = tela.getTabelaCorridas().getSelectedRow();

			if (linhaSelecionada == -1)
				FabricaJOptionPane.criarMsgAtencao("Selecione uma linha");
			else {
				long idSelecionado = (long) tela.getTabelaCorridas().getValueAt(linhaSelecionada, 3);
				if (mototaxista.getCorridaReivindicada() == null) {
					Corrida corrida = central.recuperarCorridaPeloId(idSelecionado);
					if (mototaxista.getCreditosReivindicacao() > 0) {
						reivindicarCorrida();
						mototaxista.setCorridaReivindicada(corrida);
						corrida.setEmailDoMototaxista(TelaPadrao.mototaxistaLogado.getEmail());
						persistencia.salvarCentral(central, "central");
						tela.dispose();
						TelaReivindicarCorrida tela = new TelaReivindicarCorrida(corrida);
						tela.ocultarCampos();
					} else {
						FabricaJOptionPane.criarMsgErro("Voc� n�o tem cr�ditos de reivindica��o");
					}
				} else
					FabricaJOptionPane.criarMsgErro("Voc� j� reivindicou uma corrida");
			}
		}

		else if (componente == tela.getBtnDetalhes()) {
			int linhaSelecionada = tela.getTabelaCorridas().getSelectedRow();
			if (linhaSelecionada == -1)
				FabricaJOptionPane.criarMsgAtencao("Selecione uma linha");

			if (mototaxista.getCorridaReivindicada() != null) {
				long idSelecionado = (long) tela.getTabelaCorridas().getValueAt(linhaSelecionada, 3);
				Corrida corrida = central.recuperarCorridaPeloId(idSelecionado);
				if (mototaxista.getCorridaReivindicada().equals(corrida)) {
					tela.dispose();
					new TelaReivindicarCorrida(corrida);
				} else
					FabricaJOptionPane.criarMsgErro("Para ver detalhes da corrida voc� deve reivindic�-la");
			} else
				FabricaJOptionPane.criarMsgErro("Voc� s� pode ver detalhes de uma corrida reivindicada");
		}
	}

}
