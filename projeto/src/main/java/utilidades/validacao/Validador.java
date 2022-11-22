package utilidades.validacao;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import projeto.excecoes.usuario.EmailInvalidoException;
import projeto.excecoes.usuario.EmailSemCaracterException;
import projeto.excecoes.usuario.LoginInvalidoException;
import projeto.excecoes.usuario.NomeInvalidoException;
import projeto.excecoes.usuario.SenhaInvalidaException;
import projeto.modelo.Usuario;

public abstract class Validador {

	public static boolean validarCadastroUsuario(String nome, String email, String senha) {
		validarNome(nome);
		validarEmail(email);
		validarSenha(senha);
		return true;
	}

	public static boolean validarNome(String nome) {
		if (nome.isEmpty() || nome.length() < 6) {
			throw new NomeInvalidoException();
		}
		return true;
	}

	public static boolean validarEmail(String email) {
		if (email.equals(null) || email.isEmpty()) {
			throw new EmailSemCaracterException();
		}
		String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		boolean valido = matcher.matches() && email.contains("gmail.com");

		if (!valido)
			throw new EmailInvalidoException();
		return true;
	}

	public static boolean validarSenha(String senha) {
		String regex = ".*[@!#$%^&*()/\\\\]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(senha);
		boolean temCaracterEspecial = matcher.matches();

		if (senha.equals(null) || senha.isEmpty())
			throw new SenhaInvalidaException("A senha n�o pode ser vazia");
		else if (senha.length() < 6)
			throw new SenhaInvalidaException();
		else if (!temCaracterEspecial)
			throw new SenhaInvalidaException("A senha deve conter ao menos um caracter especial");
		return true;
	}

	public static boolean validarLogin(String login) {
		if (login.equals(null) || login.length() < 6)
			throw new LoginInvalidoException();
		return true;
	}

	public static boolean idadeValida(Usuario usuario) {
		LocalDate dataNasc = usuario.getDataNascimento();
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(dataNasc, dataAtual);
		if (periodo.getYears() >= 18)
			return true;
		return false;
	}
}
