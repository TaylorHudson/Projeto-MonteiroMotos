package projeto.servico;

import java.util.ArrayList;

import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.excecoes.usuario.VerificacaoDeCorridaException;
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

	public void adicionarCorrida(Corrida corrida) throws VerificacaoDeCorridaException {
		for (Corrida c : central.getCorridas()) {
			if (c.equals(corrida))
				throw new VerificacaoDeCorridaException("Corrida já cadastrada");
		}
		central.getCorridas().add(corrida);
	}

	public Corrida recuperarCorridaPeloId(long id) throws VerificacaoDeCorridaException {
		for (Corrida c : corridas) {
			if (c.getId() == id)
				return c;
		}
		throw new VerificacaoDeCorridaException();
	}

	public ArrayList<Corrida> recuperarCorridasDeUmPassageiro(String email) throws UsuarioNaoExisteException {
		ArrayList<Corrida> corridasDoPassageiro = new ArrayList<Corrida>();
		Passageiro passageiro = util.recuperarPassageiroPeloEmail(email);
		for (Corrida c : corridas) {
			if (c.getPassageiro().equals(passageiro))
				corridasDoPassageiro.add(c);
		}
		return corridasDoPassageiro;
	}
}
