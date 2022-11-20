package projeto.telas.mototaxista.ouvintes;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OuvinteBotaoSalvar implements MouseListener {

  @Override
  public void mouseClicked(MouseEvent e) {
    
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
  }

  @Override
  public void mouseExited(MouseEvent e) {
    e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }
  
  @Override
  public void mousePressed(MouseEvent e) {
    
  }

  @Override
  public void mouseReleased(MouseEvent e) {
   
  }
}
