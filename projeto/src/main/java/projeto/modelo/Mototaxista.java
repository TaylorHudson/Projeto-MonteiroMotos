package projeto.modelo;

import java.time.LocalDate;

import projeto.modelo.enuns.Sexo;

public class Mototaxista extends Usuario {

	private Corrida corridaReivindicada = null;
	private LocalDate dataDaUltimaCompra;
	private int creditosReivindicacao;
	private Sexo sexo;

	public Mototaxista(String nome,Sexo sexo, String email, String senha, LocalDate dataNascimento, boolean estaAtivo) {
		super(nome, email, senha, dataNascimento, estaAtivo);
		this.creditosReivindicacao = 0;
		this.sexo = sexo;
	}

	public Mototaxista(String email) {
		super(email);
		this.creditosReivindicacao = 0;
	}

	public int getCreditosReivindicacao() {
		return creditosReivindicacao;
	}

	public void setCreditosReivindicacao(int creditosReivindicacao) {
		this.creditosReivindicacao = creditosReivindicacao;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataDaUltimaCompra() {
		return dataDaUltimaCompra;
	}

	public void setDataDaUltimaCompra(LocalDate dataDaUltimaCompra) {
		this.dataDaUltimaCompra = dataDaUltimaCompra;
	}

	public Corrida getCorridaReivindicada() {
		return corridaReivindicada;
	}

	public void setCorridaReivindicada(Corrida corridaReivindicada) {
		this.corridaReivindicada = corridaReivindicada;
	}

}
