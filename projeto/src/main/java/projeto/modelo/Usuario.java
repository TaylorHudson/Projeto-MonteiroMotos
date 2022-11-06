package projeto.modelo;

public class Usuario {

	private String email;
	private String senha;
	private boolean estaAtivo;
	
	public Usuario() {}

	public Usuario(String email, String senha, boolean estaAtivo) {
		this.email = email;
		this.senha = senha;
		this.estaAtivo = estaAtivo;
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

}
