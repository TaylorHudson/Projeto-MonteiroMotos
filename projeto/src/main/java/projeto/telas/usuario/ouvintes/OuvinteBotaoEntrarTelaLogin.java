package projeto.telas.usuario.ouvintes;

import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.ADM.TelaHomeADM;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import projeto.telas.passageiro.TelaHomePassageiro;
import projeto.telas.usuario.TelaLogin;
import utilidades.persistencia.Persistencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuvinteBotaoEntrarTelaLogin implements ActionListener {

	private TelaLogin tela;
	private CentralDeInformacoes central;
	private Persistencia persistencia = new Persistencia();

  public OuvinteBotaoEntrarTelaLogin(TelaLogin tela) {
		this.tela = tela;
		central = persistencia.recuperarCentral("central");
	}

  public void actionPerformed(ActionEvent e) {
    String email = tela.getTxtEmail().getText().trim();
    String senha = String.valueOf(tela.getTxtSenha().getPassword()).trim();
    String tipo = "";
    switch (tela.getBox().getSelectedIndex()) {
      case 0:
        tipo = "mototaxista";
        break;
      case 1:
        tipo = "passageiro";
        break;
    }

    Usuario adm = central.getAdministrador();
    if (adm.getEmail().equals(email) && adm.getSenha().equals(senha)) {
      tela.dispose();
      new TelaHomeADM();
    }

    else if (tipo.equals("mototaxista")) {
      Mototaxista mototaxista = central.recuperarMototaxistaPeloEmail(email);
      if (mototaxista != null && mototaxista.getSenha().equals(senha)) {
        tela.dispose();
        new TelaHomeMototaxista();
      }
    }

    else {
      Passageiro passageiro = central.recuperarPassageiroPeloEmail(email);
      if (passageiro != null && passageiro.getSenha().equals(senha)) {
        tela.dispose();
        new TelaHomePassageiro();
      }
    }
  }
  
}
