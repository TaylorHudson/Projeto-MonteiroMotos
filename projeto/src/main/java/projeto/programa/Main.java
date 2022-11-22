package projeto.programa;

import projeto.repositorio.CentralDeInformacoes;
import utilidades.persistencia.Persistencia;

public class Main {

	public static void main(String[] args) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		
	}
}