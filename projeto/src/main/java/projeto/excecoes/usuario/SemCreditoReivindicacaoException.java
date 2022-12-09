package projeto.excecoes.usuario;

public class SemCreditoReivindicacaoException extends Exception {

	public SemCreditoReivindicacaoException() {
		super("Você não tem créditos para reivindicar corrida");
	}
}
