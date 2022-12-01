package projeto.telas.mototaxista.ouvintes;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.mototaxista.TelaComprarCreditos;
import utilidades.persistencia.Persistencia;

public class OuvinteSpinner implements ChangeListener {

	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central;
	private TelaComprarCreditos tela;

	public OuvinteSpinner(TelaComprarCreditos tela) {
		this.tela = tela;
		central = persistencia.recuperarCentral("central");
	}

	public void stateChanged(ChangeEvent e) {
		int valor = (Integer) tela.getSpinner().getValue();

		if (valor < 0) {
			tela.getSpinner().setValue(0);
		} else {
			double valorTotal = valor * central.getValorDoCredito();
			tela.getTxtPrecoTotal().setText(String.format("%.2f", valorTotal));
		}
	}

}
