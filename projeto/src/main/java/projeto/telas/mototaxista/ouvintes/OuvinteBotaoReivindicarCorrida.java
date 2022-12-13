package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.TelaPadrao;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.modelo.Corrida;
import projeto.modelo.Mototaxista;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.mototaxista.TelaListarCorridasMototaxi;
import projeto.telas.mototaxista.TelaReivindicarCorrida;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;

public class OuvinteBotaoReivindicarCorrida implements ActionListener {
	
	private TelaListarCorridasMototaxi tela;
	private CentralDeInformacoes central;
	private Persistencia persistencia = new Persistencia();
	
	public OuvinteBotaoReivindicarCorrida(TelaListarCorridasMototaxi t) {
		central = persistencia.recuperarCentral("central");
		tela = t;
	}

	private void reivindicarCorrida(Corrida corrida) {
		Mototaxista mototaxistaLogado = TelaPadrao.mototaxistaLogado;
		Mototaxista mototaxista;
		try {
			mototaxista = central.recuperarMototaxistaPeloEmail(mototaxistaLogado.getEmail());
			mototaxista.setCreditosReivindicacao(mototaxista.getCreditosReivindicacao() - 1);
			TelaPadrao.mototaxistaLogado = mototaxista;
			
			mototaxista.setCorridaReivindicada(corrida);
			corrida.setEmailDoMototaxista(TelaPadrao.mototaxistaLogado.getEmail());
		} catch (UsuarioNaoExisteException e) {
		}

	}
	
	public void actionPerformed(ActionEvent e) {
		Mototaxista mototaxistaLogado = TelaPadrao.mototaxistaLogado;
		Mototaxista mototaxista = null;
		try {
			mototaxista = central.recuperarMototaxistaPeloEmail(mototaxistaLogado.getEmail());
		} catch (UsuarioNaoExisteException e1) {
		}
		
		int linhaSelecionada = tela.getTabelaCorridas().getSelectedRow();

		if (linhaSelecionada == -1)
			FabricaJOptionPane.criarMsgAtencao("Selecione uma linha");
		else {
			long idSelecionado = (long) tela.getTabelaCorridas().getValueAt(linhaSelecionada, 3);
			if (mototaxista.getCorridaReivindicada() == null) {
				Corrida corrida = central.recuperarCorridaPeloId(idSelecionado);
				if (mototaxista.getCreditosReivindicacao() > 0) {
					reivindicarCorrida(corrida);
					
					persistencia.salvarCentral(central, "central");
					tela.dispose();
					TelaReivindicarCorrida tela = new TelaReivindicarCorrida(corrida);
					tela.ocultarCampos();
				} else FabricaJOptionPane.criarMsgErro("Voce nao tem creditos de reivindicacao");
				
			} else
				FabricaJOptionPane.criarMsgErro("Voce ja reivindicou uma corrida");
		}
	}

}
