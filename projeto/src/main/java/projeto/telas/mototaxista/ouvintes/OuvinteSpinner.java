package projeto.telas.mototaxista.ouvintes;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import projeto.telas.mototaxista.TelaComprarCreditos;

public class OuvinteSpinner implements ChangeListener {

  private TelaComprarCreditos tela;

  public OuvinteSpinner(TelaComprarCreditos tela) {
    this.tela = tela;
  }

  public void stateChanged(ChangeEvent e) {
    int valor = (Integer) tela.getSpinner().getValue();

    if (valor < 0) {
      tela.getSpinner().setValue(0);
    } else {
    Float valorTotal = valor * 0.5f;
    tela.getTxtPrecoTotal().setText(String.valueOf(valorTotal));
    }
  }

}
