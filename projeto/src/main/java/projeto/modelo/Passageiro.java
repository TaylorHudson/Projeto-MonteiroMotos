package projeto.modelo;

import java.time.LocalDate;

import projeto.modelo.enuns.Sexo;

public class Passageiro extends Usuario {

	private Sexo sexo;
	private LocalDate dataNascimento;

	public Passageiro(String nome ,Sexo sexo, LocalDate dataNascimento, String email,
			String senha,boolean estaAtivo) {
		super(nome, email, senha, estaAtivo);
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
