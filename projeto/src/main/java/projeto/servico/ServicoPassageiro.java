package projeto.servico;

import java.time.LocalDate;
import java.util.ArrayList;

import projeto.modelo.Passageiro;
import projeto.repositorio.CentralDeInformacoes;

public class ServicoPassageiro {

	private CentralDeInformacoes central;
	private ArrayList<Passageiro> passageiros;
	  
	  public ServicoPassageiro(CentralDeInformacoes central) {
	    this.central = central;
	    passageiros = this.central.getPassageiros();
	  }

	  public boolean adicionarPassageiro(Passageiro passageiro) {
	    boolean ok = true;
	    for (Passageiro p : passageiros) {
	      if (passageiro.equals(p))
	        ok = false;
	    }

	    if (ok && idadeValida(passageiro)) {
	      passageiros.add(passageiro);
	      return true;
	    }
	    return false;
	  }

	  public Passageiro recuperarPassageiroPeloEmail(String email) {
	    for (Passageiro p : passageiros) {
	      if (p.getEmail().equals(email))
	        return p;
	    }
	    return null;
	  }

	  private boolean idadeValida(Passageiro passageiro) {
			int anoNascimento = passageiro.getDataNascimento().getYear();
			int anoAtual = LocalDate.now().getYear();
			boolean anoValido = (anoAtual - anoNascimento) >= 18;

			int mesNasc = passageiro.getDataNascimento().getMonthValue();
			int mesAtual = LocalDate.now().getMonthValue();
			boolean mesValido = mesAtual >= mesNasc;

			int diaNasc = passageiro.getDataNascimento().getDayOfMonth();
			int diaAtual = LocalDate.now().getDayOfMonth();
			boolean diaValido = diaAtual >= diaNasc;

			if (!mesValido)
				diaValido = false;

			return (anoValido && mesValido && diaValido);
		}

	  public CentralDeInformacoes getCentral() {
	    return central;
	  }

	  public ArrayList<Passageiro> getPassageiros() {
	    return passageiros;
	  }

}
