package projeto.servico;

import java.util.ArrayList;

import projeto.modelo.Mototaxista;
import projeto.repositorio.CentralDeInformacoes;
import utilidades.validacao.Validador;

public class ServicoMototaxista {

  private CentralDeInformacoes central;
  private ArrayList<Mototaxista> mototaxistas;

  public ServicoMototaxista(CentralDeInformacoes central) {
    this.central = central;
    mototaxistas = this.central.getMototaxistas();
  }

  public boolean adicionarMototaxista(Mototaxista mototaxista) {
    boolean ok = true;
    for (Mototaxista m : mototaxistas) {
      if (mototaxista.equals(m))
        ok = false;
    }

    if (ok && Validador.idadeValida(mototaxista.getDataNascimento())) {
      mototaxistas.add(mototaxista);
      return true;
    }
    return false;
  }

  public Mototaxista recuperarMototaxistaPeloEmail(String email) {
		for (Mototaxista m : mototaxistas) {
			if (m.getEmail().equals(email))
				return m;
		}
		return null;
	}

}
