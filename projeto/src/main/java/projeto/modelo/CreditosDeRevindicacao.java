package projeto.modelo;

import java.time.LocalDate;

public class CreditosDeRevindicacao {
	private Mototaxista mototaxista;
	private LocalDate dataDaCompra;
	private int quantidadeDeCreditos;
	private double valorDosCreditos;
	
	public CreditosDeRevindicacao(Mototaxista mototaxista, LocalDate dataDaCompra, int quantidadeDeCreditos,
			double valorDosCreditos) {
		super();
		this.mototaxista = mototaxista;
		this.dataDaCompra = dataDaCompra;
		this.quantidadeDeCreditos = quantidadeDeCreditos;
		this.valorDosCreditos = valorDosCreditos;
	}
	
	public Mototaxista getMototaxista() {
		return mototaxista;
	}
	public void setMototaxista(Mototaxista mototaxista) {
		this.mototaxista = mototaxista;
	}
	public LocalDate getDataDaCompra() {
		return dataDaCompra;
	}
	public void setDataDaCompra(LocalDate dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}
	public int getQuantidadeDeCreditos() {
		return quantidadeDeCreditos;
	}
	public void setQuantidadeDeCreditos(int quantidadeDeCreditos) {
		this.quantidadeDeCreditos = quantidadeDeCreditos;
	}
	public double getValorDosCreditos() {
		return valorDosCreditos;
	}
	public void setValorDosCreditos(double valorDosCreditos) {
		this.valorDosCreditos = valorDosCreditos;
	}
	
	

}
