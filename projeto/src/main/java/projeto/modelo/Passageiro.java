package projeto.modelo;

import java.time.LocalDate;

import projeto.modelo.enuns.Sexo;

public class Passageiro extends Usuario {

	private Sexo sexo;

	public Passageiro(String nome, Sexo sexo, LocalDate dataNascimento, String email,
			String senha, boolean estaAtivo) {
		super(nome, email, senha, dataNascimento, estaAtivo);
		this.sexo = sexo;
	}

	public Passageiro(String email) {
		super(email);
	}

	public String toString() {
		return getNome();
	}

	public boolean equals(Passageiro passageiro) {
		return getEmail().equals(passageiro.getEmail());
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

}
