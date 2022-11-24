package projeto.telas.ADM.ouvintes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import projeto.excecoes.usuario.DataInvalidaException;
import projeto.excecoes.usuario.ValidacaoException;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import projeto.servico.ServicoData;
import projeto.telas.ADM.TelaCadastroADM;
import projeto.telas.usuario.TelaLogin;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;
import utilidades.validacao.Validador;

public class OuvintesTelaDeCadastroADM implements MouseListener {

	private TelaCadastroADM tela;
	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central = persistencia.recuperarCentral("central");

	public OuvintesTelaDeCadastroADM(TelaCadastroADM tela) {
		this.tela = tela;
	}

	public void mouseClicked(MouseEvent e) {
		String nomeCompleto = tela.getTxtNomeCompleto().getText();
		String senha = String.valueOf(tela.getTxtSenha().getPassword());
		String email = tela.getTxtEmail().getText();
		String dataNascimento = tela.getTxtData().getText();
		
		try {
			if (central.getAdministrador() == null) {
				LocalDate data = ServicoData.retornarData(dataNascimento);
				boolean valido = Validador.validarCadastro(nomeCompleto, email, senha, data);
				if (valido) {
					central.setAdministrador(new Usuario(nomeCompleto, email, senha, data, true));
					persistencia.salvarCentral(central, "central");
					tela.dispose();
					new TelaLogin();
				}
			}
		} catch (ValidacaoException | DataInvalidaException erro) {
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
