package utilidades.validacao;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import projeto.excecoes.usuario.ValidacaoException;

public abstract class Validador {

	public static boolean validarCadastro(String nomeCompleto, String email, String senha, LocalDate data) {
		boolean nomeValido = validarNome(nomeCompleto);
		boolean emailValido = validarEmail(email);
		boolean senhaValida = validarSenha(senha);
		boolean dataValida = idadeValida(data);

		if (nomeValido && emailValido && senhaValida && dataValida)
			return true;
		return false;
	}

	public static boolean validarNome(String nome) {
		if (nome.isEmpty() || nome.length() < 10)
			throw new ValidacaoException("O nome deve conter pelo menos dez caracteres");
		return true;
	}

	public static boolean validarEmail(String email) {
		if (email.isEmpty())
			throw new ValidacaoException("E-mail não pode ser vazio");

		String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		boolean valido = matcher.matches() && email.contains("gmail.com");

		if (!valido)
			throw new ValidacaoException("E-mail inválido");
		return true;
	}

	public static boolean validarSenha(String senha) {
		String regex = ".*[@!#$%^&*()/\\\\]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(senha);
		boolean temCaracterEspecial = matcher.matches();

		if (senha.isEmpty() || senha.length() < 6)
			throw new ValidacaoException("Senha inválida");
		else if (!temCaracterEspecial)
			throw new ValidacaoException("A senha deve conter ao menos um caracter especial");
		return true;
	}

	public static boolean idadeValida(LocalDate dataNascimento) {
		LocalDate dataNasc = dataNascimento;
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(dataNasc, dataAtual);
		if (periodo.getYears() >= 18)
			return true;
		throw new ValidacaoException("Data de nascimento inválida");
	}
}
