package projeto.modelo;

public class Avaliacao {

	private Passageiro autor;
	private String avaliado;
	private int nota;
	private String comentario;
	private boolean mototaxistaBloqueado;
	public Passageiro getAutor() {
		return autor;
	}
	public void setAutor(Passageiro autor) {
		this.autor = autor;
	}
	public String getAvaliado() {
		return avaliado;
	}
	public void setAvaliado(String avaliado) {
		this.avaliado = avaliado;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public boolean isMototaxistaBloqueado() {
		return mototaxistaBloqueado;
	}
	public void setMototaxistaBloqueado(boolean mototaxistaBloqueado) {
		this.mototaxistaBloqueado = mototaxistaBloqueado;
	}
	
}
