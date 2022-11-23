package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.telas.mototaxista.TelaEdicaoPerfil;
import projeto.telas.mototaxista.TelaHomeMototaxista;

public class OuvinteBotoesTelaEdicao implements ActionListener {

  private TelaEdicaoPerfil tela;

  public OuvinteBotoesTelaEdicao(TelaEdicaoPerfil t) {
    tela = t;
  }

  public void actionPerformed(ActionEvent e) {

    if(e.getSource() == tela.getBtnSeta()) {
      tela.dispose();
      new TelaHomeMototaxista();
    }

    String nomeCompleto = tela.getTxtNomeCompleto().getText();
    String email = tela.getTxtEmail().getText();
    String senha = String.valueOf(tela.getTxtSenha().getPassword());
    String dataNascimento = tela.getTxtData().getText();

  }
}
