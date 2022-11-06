package projeto.modelo;

import projeto.modelo.enuns.Sexo;
import projeto.modelo.enuns.StatusCorrida;

public class Corrida {

	private long id;
	private StatusCorrida status;
	private Avaliacao avaliacao;
	private String enderecoDePartida;
	private String enderecoDeDestino;
	private Passageiro passageiro;
	private Mototaxista mototaxista;

	public Corrida(long id, StatusCorrida status, Avaliacao avaliacao, String enderecoDePartida,
			String enderecoDeDestino, Passageiro passageiro, Mototaxista mototaxista) {
		this.id = id;
		this.status = status;
		this.avaliacao = avaliacao;
		this.enderecoDePartida = enderecoDePartida;
		this.enderecoDeDestino = enderecoDeDestino;
		this.passageiro = passageiro;
		this.mototaxista = mototaxista;
	}

	public Corrida() {
		this.id = System.currentTimeMillis();
	}

	public String toString() {
		String pegar = "pega-lo";
		String nome = passageiro.getNome();
		if (passageiro.getSexo() == Sexo.FEMININO)
			pegar = "pega-la";
		return "<" + nome + "> pede para " + pegar + " em <" + enderecoDePartida + ">";
	}

	public boolean equals(Corrida corrida) {
		return (id == corrida.getId());
	}

	public long getId() {
		return id;
	}

	public String getEnderecoDePartida() {
		return enderecoDePartida;
	}

	public void setEnderecoDePartida(String enderecoDePartida) {
		this.enderecoDePartida = enderecoDePartida;
	}

	public String getEnderecoDeDestino() {
		return enderecoDeDestino;
	}

	public void setEnderecoDeDestino(String enderecoDeDestino) {
		this.enderecoDeDestino = enderecoDeDestino;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Mototaxista getMototaxista() {
		return mototaxista;
	}

	public void setMototaxista(Mototaxista mototaxista) {
		this.mototaxista = mototaxista;
	}

	public StatusCorrida getStatus() {
		return status;
	}

	public void setStatus(StatusCorrida status) {
		this.status = status;
	}

}
