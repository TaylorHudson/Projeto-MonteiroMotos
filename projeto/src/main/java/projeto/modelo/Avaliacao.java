package projeto.modelo;

public class Avaliacao {

	private String avaliado;
	private int nota;
	private String comentario;
	private boolean mototaxistaBloqueado;
	
	public Avaliacao(Passageiro autor, String avaliado, int nota, String comentario, boolean mototaxistaBloqueado) {
		this.avaliado = avaliado;
		this.nota = nota;
		this.comentario = comentario;
		this.mototaxistaBloqueado = mototaxistaBloqueado;
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
