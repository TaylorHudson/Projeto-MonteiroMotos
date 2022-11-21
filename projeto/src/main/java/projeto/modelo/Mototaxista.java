package projeto.modelo;

public class Mototaxista extends Usuario {

	private int creditosReivindicacao;

	public Mototaxista(String nome, String email, String senha, boolean estaAtivo) {
		super(nome, email, senha, estaAtivo);
		creditosReivindicacao = 0;
	}

	public int getCreditosReivindicacao() {
		return creditosReivindicacao;
	}

	public void setCreditosReivindicacao(int creditosReivindicacao) {
		this.creditosReivindicacao = creditosReivindicacao;
	}
	
}
