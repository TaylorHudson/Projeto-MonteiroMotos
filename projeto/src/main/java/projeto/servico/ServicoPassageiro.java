package projeto.servico;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

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
	    int anoAtual = LocalDate.now().getYear();
	    Date date = passageiro.getDataNascimento();
	    int anoNascimento = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
	    return ((anoAtual - anoNascimento) >= 18);
	  }

	  public CentralDeInformacoes getCentral() {
	    return central;
	  }

	  public ArrayList<Passageiro> getPassageiros() {
	    return passageiros;
	  }
	  
}
