package utilidades.email;

import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.MultiPartEmail;

import projeto.modelo.Corrida;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import utilidades.persistencia.Persistencia;

public class Mensageiro {

	public static void enviarHistoricoDeCorridas(Passageiro passageiro) {
		String remetente = "pooprojeto824@gmail.com";
		String senha = "rehjpckvmjwhvkpu";

		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");
		ArrayList<Corrida> corridas = central.recuperarCorridasDeUmPassageiro(passageiro.getEmail());

		String resposta = "";
		for (Corrida c : corridas) {
			resposta += c + "\n";
		}

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(remetente, senha));
		email.setSSLOnConnect(true);
		try {
			email.setFrom(remetente);
			email.setSubject("Rela��o das Corridas do Passageiro " + passageiro.getNome());
			email.setMsg(resposta);
			email.addTo(passageiro.getEmail());

			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int enviarEmailComCodigoDeVerificacao(String emailDeCodigo) {
		String remetente = "pooprojeto824@gmail.com";
		String senha = "rehjpckvmjwhvkpu";

		int min = 1234;
		int max = 9999;

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(remetente, senha));
		email.setSSLOnConnect(true);
		try {
			email.setFrom(remetente);
			email.setSubject("C�digo para mudan�a de senha.");
			int codigo = new Random().nextInt((max - min) + 1) + min;
			email.setMsg("Seu c�digo: " + codigo);
			email.addTo(emailDeCodigo);
			email.send();

			return codigo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}


