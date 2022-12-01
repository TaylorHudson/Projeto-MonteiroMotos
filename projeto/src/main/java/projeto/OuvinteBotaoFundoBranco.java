package projeto;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OuvinteBotaoFundoBranco implements MouseListener{

  public void mouseClicked(MouseEvent e) {
    
  }

  public void mouseEntered(MouseEvent e) {
	  e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
	e.getComponent().setForeground(new Color(179, 177, 177));
  }

  public void mouseExited(MouseEvent e) {
	  e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		e.getComponent().setForeground(Color.WHITE);
  }
 
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }
}
