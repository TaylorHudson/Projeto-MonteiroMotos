package projeto.modelo;

import java.time.LocalDate;

public class Mototaxista extends Usuario {

	private int creditosReivindicacao;

	public Mototaxista(String nome, String email, String senha, LocalDate dataNascimento, boolean estaAtivo) {
		super(nome, email, senha, dataNascimento, estaAtivo);
		this.creditosReivindicacao = 0;
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
	
}
