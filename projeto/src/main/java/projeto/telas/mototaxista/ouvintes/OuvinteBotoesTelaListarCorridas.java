package projeto.telas.mototaxista.ouvintes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import projeto.telas.mototaxista.TelaHomeMototaxista;
import projeto.telas.mototaxista.TelaListarCorridas;

public class OuvinteBotoesTelaListarCorridas implements MouseListener {

  private TelaListarCorridas tela;

  public OuvinteBotoesTelaListarCorridas(TelaListarCorridas t) {
    tela = t;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getSource() == tela.getLblSeta()) {
      tela.dispose();
      new TelaHomeMototaxista();
    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
    e.getComponent().setForeground(new Color(179, 177, 177));
  }

  @Override
  public void mouseExited(MouseEvent e) {
    e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    e.getComponent().setForeground(Color.WHITE);
  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }
}
