package projeto.programa;

import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.ADM.TelaCadastroADM;
import utilidades.persistencia.Persistencia;

public class Main {

	public static void main(String[] args) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		
		if (central.getUsuarios().size() != 0)
			new TelaCadastroADM();

	}
}