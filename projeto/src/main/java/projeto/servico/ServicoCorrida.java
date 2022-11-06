package projeto.servico;

import java.util.ArrayList;

import projeto.modelo.Corrida;
import projeto.modelo.Passageiro;
import projeto.repositorio.CentralDeInformacoes;

public class ServicoCorrida {

	private CentralDeInformacoes central;
	private ArrayList<Corrida> corridas;
	private ServicoPassageiro util;
	
	public ServicoCorrida(CentralDeInformacoes central, ServicoPassageiro util) {
		this.central = central;
		corridas = this.central.getCorridas();
		this.util = util;
	}

	public boolean adicionarCorrida(Corrida corrida) {
		boolean ok = true;

		for (Corrida c : corridas) {
			if (corrida.equals(c))
				ok = false;
		}
		if (ok) {
			corridas.add(corrida);
			return true;
		}
		return false;
	}

	public Corrida recuperarCorridaPeloId(long id) {
		for (Corrida c : corridas) {
			if (c.getId() == id)
				return c;
		}
		return null;
	}

	public ArrayList<Corrida> recuperarCorridasDeUmPassageiro(String email) {
		ArrayList<Corrida> corridasDoPassageiro = new ArrayList<Corrida>();
		Passageiro passageiro = util.recuperarPassageiroPeloEmail(email);
		if (passageiro != null) {
			for (Corrida c : corridas) {
				if (c.getPassageiro().equals(passageiro))
					corridasDoPassageiro.add(c);
			}
			return corridasDoPassageiro;
		}
		return null;
	}

	public int recuperarNumeroCorridasDeUmPassageiro(String email) {
		int numeroCorridas = 0;
		Passageiro passageiro = util.recuperarPassageiroPeloEmail(email);
		if (passageiro != null && corridas != null) {
			for (Corrida c : corridas) {
				if (c.getPassageiro().equals(passageiro))
					numeroCorridas++;
			}
			return numeroCorridas;
		}
		return 0;
	}
}
