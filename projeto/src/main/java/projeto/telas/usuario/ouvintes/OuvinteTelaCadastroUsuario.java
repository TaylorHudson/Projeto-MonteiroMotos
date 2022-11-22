package projeto.telas.usuario.ouvintes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import projeto.excecoes.usuario.ValidacaoException;
import projeto.modelo.Mototaxista;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import projeto.servico.ServicoData;
import projeto.telas.TelaLogin;
import projeto.telas.usuario.TelaCadastroUsuario;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;
import utilidades.validacao.Validador;

public class OuvinteTelaCadastroUsuario implements MouseListener {

	private TelaCadastroUsuario tela;
	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central;

	public OuvinteTelaCadastroUsuario(TelaCadastroUsuario tela) {
		this.tela = tela;
		this.central = persistencia.recuperarCentral("central");
	}

	public void mouseClicked(MouseEvent e) {
		String nome = tela.getTxtNome().getText().trim();
		String email = tela.getTxtEmail().getText().trim();
		String senha = String.valueOf(tela.getTxtSenha().getPassword()).trim();
		String dataDeNascimento = tela.getTxtData().getText();
		String tipo = (String) tela.getBox().getSelectedItem();

		try {
			boolean teste = Validador.validarCadastro(nome, email, senha, ServicoData.retornarData(dataDeNascimento));
			LocalDate data = ServicoData.retornarData(dataDeNascimento);
			if (teste == true && tipo.equals("Mototaxista")) {
				central.adicionarMototaxista(new Mototaxista(nome, email, senha, data, true));
				persistencia.salvarCentral(central, "central");
				tela.dispose();
				new TelaLogin();
			}

		} catch (ValidacaoException erro) {
			FabricaJOptionPane.criarMsgAtencao(erro.getMessage());

		}

	}

	public void mouseEntered(MouseEvent e) {
		e.getComponent().setForeground(new Color(81, 82, 82));
		e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void mouseExited(MouseEvent e) {
		e.getComponent().setForeground(Color.BLACK);
		e.getComponent().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
}
