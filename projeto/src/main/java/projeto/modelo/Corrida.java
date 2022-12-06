package projeto.modelo;

import java.time.LocalDate;

import projeto.modelo.enuns.Sexo;
import projeto.modelo.enuns.StatusDaCorrida;

public class Corrida {

	private long id;
	private StatusDaCorrida status;
	private String pontoDeEncontro;
	private String localDeDestino;
	private String complemento;
	private Passageiro passageiro;
	private String emailDoMototaxista;
	private LocalDate data;

	public Corrida(StatusDaCorrida status, String pontoDeEncontro, String localDeDestino, String complemento,
			Passageiro passageiro, String emailDoMototaxista, LocalDate data) {
		this.status = status;
		this.pontoDeEncontro = pontoDeEncontro;
		this.localDeDestino = localDeDestino;
		this.complemento = complemento;
		this.passageiro = passageiro;
		this.emailDoMototaxista = emailDoMototaxista;
		this.data = data;
		this.id = System.currentTimeMillis();
	}

	public Corrida(StatusDaCorrida status, String pontoDeEncontro, String localDeDestino, String complemento,
			Passageiro passageiro, LocalDate data) {
		this.status = status;
		this.pontoDeEncontro = pontoDeEncontro;
		this.localDeDestino = localDeDestino;
		this.complemento = complemento;
		this.passageiro = passageiro;
		this.data = data;
		this.id = System.currentTimeMillis();
	}

	public String toString() {
		String pegar = "pega-lo";
		String nome = passageiro.getNome();
		if (passageiro.getSexo() == Sexo.FEMININO)
			pegar = "pega-la";
		return "<" + nome + "> pede para " + pegar + " em <" + pontoDeEncontro + ">";
	}

	public boolean equals(Corrida corrida) {
		return (id == corrida.getId());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public StatusDaCorrida getStatus() {
		return status;
	}

	public void setStatus(StatusDaCorrida status) {
		this.status = status;
	}

	public String getPontoDeEncontro() {
		return pontoDeEncontro;
	}

	public void setPontoDeEncontro(String pontoDeEncontro) {
		this.pontoDeEncontro = pontoDeEncontro;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getLocalDeDestino() {
		return localDeDestino;
	}

	public void setLocalDeDestino(String localDeDestino) {
		this.localDeDestino = localDeDestino;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public String getEmailDoMototaxista() {
		return emailDoMototaxista;
	}

	public void setEmailDoMototaxista(String emailDoMototaxista) {
		this.emailDoMototaxista = emailDoMototaxista;
	}

}
