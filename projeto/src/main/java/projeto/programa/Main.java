package projeto.programa;

import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.TelaLogin;
import projeto.telas.usuario.TelaCadastroUsuario;
import utilidades.persistencia.Persistencia;

public class Main {

	public static void main(String[] args) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		
		if (central.getUsuarios().size() != 0)
			new TelaLogin();
		else
			new TelaCadastroUsuario();
	}
	
}
