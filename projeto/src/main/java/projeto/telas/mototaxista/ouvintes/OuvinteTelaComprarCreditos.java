package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.mototaxista.TelaComprarCreditos;
import projeto.telas.mototaxista.TelaHomeMototaxista;
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
		}
  }

}
