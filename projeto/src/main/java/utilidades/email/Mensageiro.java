package utilidades.email;

import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.MultiPartEmail;

import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.modelo.Corrida;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;

public class Mensageiro {
	
	public static void enviarHistoricoDeCorridas(Passageiro passageiro) throws UsuarioNaoExisteException {
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
			email.setSubject("Relatorio das Corridas do Passageiro " + passageiro.getNome());
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

			System.out.println(codigo);
			return codigo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void enviarEmailConfirmacaoCorrida(String emailDoPassageiro, Mototaxista mototaxista) {
		String remetente = "pooprojeto824@gmail.com";
		String senha = "rehjpckvmjwhvkpu";

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(remetente, senha));
		email.setSSLOnConnect(true);
		try {
			email.setFrom(remetente);
			email.setSubject("Informa��es da corrida.");
			email.setMsg("Nome do mototaxista: " + mototaxista.getNome());
			email.setMsg("Email do mototaxista: " + mototaxista.getEmail());
			email.setMsg("Sexo do mototaxista: " + mototaxista.getSexo());
			email.addTo(emailDoPassageiro);
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enviarDadosAtualizados(Usuario usuario) {
		String remetente = "pooprojeto824@gmail.com";
		String senha = "rehjpckvmjwhvkpu";
		String mensagen = FabricaJOptionPane.criarInput("Mensagem para o usuario");

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(remetente, senha));
		email.setSSLOnConnect(true);
		try {
			email.setFrom(remetente);
			email.setSubject("Dados atualizados do usu�rio");
			email.setMsg(mensagen + "\n" +
						"Nome do usu�rio: " + usuario.getNome() + "\n" +
						"Email do usu�rio: " + usuario.getEmail() + "\n" +
						"Senha: " + usuario.getSenha() + "\n" +
						"Data de nascimento " + usuario.getDataNascimento());
			email.addTo(usuario.getEmail());
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


