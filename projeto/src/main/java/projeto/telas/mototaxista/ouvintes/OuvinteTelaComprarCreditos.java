package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.TelaPadrao;
import projeto.modelo.Mototaxista;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.mototaxista.TelaComprarCreditos;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.pdf.GeradorDeRelatorios;
import utilidades.persistencia.Persistencia;

public class OuvinteTelaComprarCreditos implements ActionListener {

	private TelaComprarCreditos tela;

	public OuvinteTelaComprarCreditos(TelaComprarCreditos tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();

		if (componente == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomeMototaxista();
		} else if (componente == tela.getBtnGerarBoleto()) {
			int qtd = (Integer) tela.getSpinner().getValue();
			if (qtd > 0) {
				String valorString = tela.getTxtPrecoTotal().getText().replace(',', '.');
				double valor = Double.parseDouble(valorString);
				GeradorDeRelatorios.gerarBoleto(qtd, valor);
				Mototaxista mototaxista = TelaPadrao.mototaxistaLogado;
				mototaxista.setCreditosReivindicacao(qtd);
				FabricaJOptionPane.criarMsg("Compra realizada com sucesso");
			}
		}
	}

}
