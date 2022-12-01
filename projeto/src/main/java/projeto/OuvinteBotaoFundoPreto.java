package projeto;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

public class OuvinteBotaoFundoPreto implements MouseListener{

  public void mouseClicked(MouseEvent e) {
    
  }

  public void mouseEntered(MouseEvent e) {
    e.getComponent().setForeground(new Color(66, 65, 65));
		e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
  }

  public void mouseExited(MouseEvent e) {
    e.getComponent().setForeground(Color.BLACK);
		e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
  }
 
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }
}
