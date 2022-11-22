package projeto.servico;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import utilidades.validacao.Validador;

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

		if (ok && Validador.idadeValida(passageiro)) {
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

	public boolean validarPassageiro(String email, String senha) {
		Usuario usuario = central.recuperarPassageiroPeloEmail(email);
		if (usuario != null && usuario.getSenha().equals(senha))
			return true;
		return false;
	}

	public CentralDeInformacoes getCentral() {
		return central;
	}

	public ArrayList<Passageiro> getPassageiros() {
		return passageiros;
	}

}
