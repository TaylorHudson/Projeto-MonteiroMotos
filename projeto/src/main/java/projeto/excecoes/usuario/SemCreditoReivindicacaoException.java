package projeto.excecoes.usuario;

public class SemCreditoReivindicacaoException extends Exception {

	public SemCreditoReivindicacaoException() {
		super("Voc� n�o tem cr�ditos para reivindicar corrida");
	}
}
