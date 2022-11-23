package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.mototaxista.TelaComprarCreditos;

public class OuvinteTelaComprarCreditos implements ActionListener {

	private TelaComprarCreditos tela;

	public OuvinteTelaComprarCreditos(TelaComprarCreditos tela) {
		this.tela = tela;
	}

  public void actionPerformed(ActionEvent e) {
    int valor = (Integer) tela.getSpinner().getValue();
    System.out.println(valor);
  }

}
