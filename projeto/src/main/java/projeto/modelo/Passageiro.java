package projeto.modelo;

import java.time.LocalDate;

import projeto.modelo.enuns.Sexo;

public class Passageiro extends Usuario {

	private String nome;
	private Sexo sexo;
	private LocalDate dataNascimento;

	public Passageiro(String nome, Sexo sexo, LocalDate dataNascimento, String email,
			String senha,boolean estaAtivo) {
		super(email, senha, estaAtivo);
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}

	public Passageiro() {
	}

	public String toString() {
		return nome;
	}

	public boolean equals(Passageiro passageiro) {
		return getEmail().equals(passageiro.getEmail());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
