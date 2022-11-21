package projeto.modelo;

public class Usuario {

	private String nome;
	private String email;
	private String senha;
	private boolean estaAtivo;
	
	public Usuario() {}

	public Usuario(String nome, String email, String senha, boolean estaAtivo) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.estaAtivo = estaAtivo;
	}

	public Usuario(String email) {
		this.email = email;
	}

	public boolean equals(Usuario usuario) {
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

}
