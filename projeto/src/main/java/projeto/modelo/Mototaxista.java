package projeto.modelo;

import java.time.LocalDate;

import projeto.modelo.enuns.Sexo;

public class Mototaxista extends Usuario {

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

	public boolean equals(Mototaxista mototaxista) {
		return getEmail().equals(mototaxista.getEmail());
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
	
}
