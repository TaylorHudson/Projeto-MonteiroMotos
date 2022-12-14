package utilidades.validacao;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JCheckBox;

import projeto.excecoes.usuario.CadastroDeCorridaInvalidoException;
import projeto.excecoes.usuario.SexoInvalidoException;
import projeto.excecoes.usuario.StatusDaCorridaInvalidoException;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.excecoes.usuario.ValidacaoException;
import projeto.excecoes.usuario.ValidarCreditoException;
import projeto.modelo.Mototaxista;
import projeto.repositorio.CentralDeInformacoes;
import projeto.servico.ServicoMototaxista;
import projeto.servico.ServicoPassageiro;

public abstract class Validador {

	public static boolean validarCadastro(String nomeCompleto, String email, String senha, LocalDate data)
			throws ValidacaoException {
		boolean nomeValido = validarNome(nomeCompleto);
		boolean emailValido = validarEmail(email);
		boolean senhaValida = validarSenha(senha);
		boolean dataValida = idadeValida(data);

		if (nomeValido && emailValido && senhaValida && dataValida)
			return true;
		return false;
	}

	public static boolean validarCadastro(String nomeCompleto, String email, String senha, LocalDate data,
			JCheckBox cbFeminino, JCheckBox cbMasculino) throws SexoInvalidoException, ValidacaoException {
		boolean nomeValido = validarNome(nomeCompleto);
		boolean emailValido = validarEmail(email);
		boolean senhaValida = validarSenha(senha);
		boolean dataValida = idadeValida(data);
		boolean sexoValido = validarSexo(cbFeminino, cbMasculino);

		if (nomeValido && emailValido && senhaValida && dataValida && sexoValido)
			return true;
		return false;
	}

	public static boolean logarMototaxista(String email, String senha, CentralDeInformacoes central)
			throws ValidacaoException, UsuarioNaoExisteException {

		ServicoMototaxista servicoMototaxista = new ServicoMototaxista(central);

		boolean valido = servicoMototaxista.validarMototaxista(email, senha);
		return valido;
	}

	public static boolean logarPassageiro(String email, String senha, CentralDeInformacoes central)
			throws ValidacaoException {

		ServicoPassageiro servicoPassageiro = new ServicoPassageiro(central);

		boolean valido = servicoPassageiro.validarPassageiro(email, senha);
		return valido;
	}

	public static boolean validarCorrida(String pontoDeEncontro, String localDestino, String complemento)
			throws CadastroDeCorridaInvalidoException {
		if (pontoDeEncontro.isEmpty() || localDestino.isEmpty() || complemento.isEmpty()) {
			throw new CadastroDeCorridaInvalidoException();
		}
		return true;
	}

	public static boolean validarStatusDaCorrida(JCheckBox cbAgora, JCheckBox cbDepois)
			throws StatusDaCorridaInvalidoException {
		boolean selecionouParaAgora = cbAgora.isSelected();
		boolean selecionouParaDepois = cbDepois.isSelected();
		if (selecionouParaAgora && selecionouParaDepois) {
			throw new StatusDaCorridaInvalidoException();
		}
		if (!selecionouParaAgora && !selecionouParaDepois) {
			throw new StatusDaCorridaInvalidoException("Selecione um tipo de status da corrida");
		}
		return true;
	}

	public static boolean validarSexo(JCheckBox cbFeminino, JCheckBox cbMasculino) throws SexoInvalidoException {
		boolean selecionouFeminino = cbFeminino.isSelected();
		boolean selecionouMasculino = cbMasculino.isSelected();
		if (selecionouFeminino && selecionouMasculino) {
			throw new SexoInvalidoException();
		}
		if (!selecionouFeminino && !selecionouMasculino) {
			throw new SexoInvalidoException("Selecione um tipo de sexo");
		}
		return true;
	}

	public static boolean validarNome(String nome) throws ValidacaoException {
		if (nome.isEmpty() || nome.length() < 10)
			throw new ValidacaoException("O nome deve conter pelo menos dez caracteres");
		return true;
	}

	public static boolean validarEmail(String email) throws ValidacaoException {
		if (email.isEmpty())
			throw new ValidacaoException("E-mail nao pode ser vazio");

		String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		boolean valido = matcher.matches() && email.contains("gmail.com");

		if (!valido)
			throw new ValidacaoException("E-mail invalido");
		return true;
	}

	public static boolean validarSenha(String senha) throws ValidacaoException {
		String regex = ".*[@!#$%^&*()/\\\\]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(senha);
		boolean temCaracterEspecial = matcher.matches();

		if (senha.isEmpty() || senha.length() < 6)
			throw new ValidacaoException("Senha invalida");
		else if (!temCaracterEspecial)
			throw new ValidacaoException("A senha deve conter ao menos um caracter especial");
		return true;
	}

	public static boolean idadeValida(LocalDate dataNascimento) throws ValidacaoException {
		LocalDate dataNasc = dataNascimento;
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(dataNasc, dataAtual);
		if (periodo.getYears() >= 18)
			return true;
		throw new ValidacaoException("Data de nascimento invalida");
	}

	public static boolean validarCredito(double credito) throws ValidarCreditoException {
		if (credito == 0.0) {
			throw new ValidarCreditoException("Valor do credito invalido");
		}
		return true;
	}
}
