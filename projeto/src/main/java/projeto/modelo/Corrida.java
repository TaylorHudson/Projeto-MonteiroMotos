package projeto.modelo;

import java.time.LocalDate;
import java.util.Comparator;

import projeto.modelo.enuns.AndamentoDaCorrida;
import projeto.modelo.enuns.Sexo;
import projeto.modelo.enuns.StatusDaCorrida;

public class Corrida implements Comparator<Corrida>{

	private long id;
	private StatusDaCorrida status;
	private AndamentoDaCorrida andamento = AndamentoDaCorrida.ESPERA;
	private String pontoDeEncontro;
	private String localDeDestino;
	private String complemento;
	private Passageiro passageiro;
	private String emailDoMototaxista;
	private LocalDate data;
	private String hora;

	public Corrida(StatusDaCorrida status, String pontoDeEncontro, String localDeDestino, String complemento,
			Passageiro passageiro, String emailDoMototaxista, LocalDate data,String hora) {
		this.status = status;
		this.hora = hora;
		this.pontoDeEncontro = pontoDeEncontro;
		this.localDeDestino = localDeDestino;
		this.complemento = complemento;
		this.passageiro = passageiro;
		this.emailDoMototaxista = emailDoMototaxista;
		this.data = data;
		this.id = System.currentTimeMillis();
	}

	public Corrida(StatusDaCorrida status, String pontoDeEncontro, String localDeDestino, String complemento,
			Passageiro passageiro, LocalDate data, String hora) {
		this.status = status;
		this.hora = hora;
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

	public boolean equals(Object obj) {
		Corrida corrida = (Corrida) obj;
		return (id == corrida.getId());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AndamentoDaCorrida getAndamento() {
		return andamento;
	}

	public void setAndamento(AndamentoDaCorrida andamento) {
		this.andamento = andamento;
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

	public StatusDaCorrida getStatus() {
		return status;
	}

	public void setStatus(StatusDaCorrida status) {
		this.status = status;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public int compare(Corrida c1, Corrida c2) {
		return c1.getData()
				.compareTo(c2.getData());
	}


}
