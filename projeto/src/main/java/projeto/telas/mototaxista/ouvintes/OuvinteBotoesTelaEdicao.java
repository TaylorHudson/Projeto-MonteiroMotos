package projeto.telas.mototaxista.ouvintes;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import projeto.telas.mototaxista.TelaEdicaoPerfil;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import utilidades.fabricas.FabricaJOptionPane;

public class OuvinteBotoesTelaEdicao implements MouseListener {

  private TelaEdicaoPerfil tela;

  public OuvinteBotoesTelaEdicao(TelaEdicaoPerfil t) {
    tela = t;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if(e.getSource() == tela.getLblSeta()) {
      int opc = FabricaJOptionPane.criarInput("Escolha uma opção", "Deseja sair realmente?");
      if (opc == 0) {
        tela.dispose();
        new TelaHomeMototaxista();
      }  
    }

    String nomeCompleto = tela.getTxtNomeCompleto().getText();
    String email = tela.getTxtEmail().getText();
    String senha = String.valueOf(tela.getTxtSenha().getPassword());
    String dataNascimento = tela.getTxtData().getText();
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
