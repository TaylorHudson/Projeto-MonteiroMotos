package projeto.modelo;

import java.time.LocalDate;

public class Usuario{

	private String nome;
	private String email;
	private String senha;
	private LocalDate dataNascimento;
	private boolean estaAtivo;
	
	public Usuario() {}

	public Usuario(String nome, String email, String senha, LocalDate dataNascimento,boolean estaAtivo) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.estaAtivo = estaAtivo;
	}

	public Usuario(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		Usuario usuario = (Usuario) obj;
		return email.equals(usuario.getEmail());
	}

	public String toString() {
		return email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isEstaAtivo() {
		return estaAtivo;
	}

	public void setEstaAtivo(boolean estaAtivo) {
		this.estaAtivo = estaAtivo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
