package projeto.telas.usuario.ouvintes;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import projeto.excecoes.usuario.EmailInvalidoException;
import projeto.excecoes.usuario.EmailSemCaracterException;
import projeto.excecoes.usuario.LoginInvalidoException;
import projeto.excecoes.usuario.NomeInvalidoException;
import projeto.excecoes.usuario.SenhaInvalidaException;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.usuario.TelaCadastroUsuario;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;
import utilidades.validacao.Validador;

public class OuvinteTelaCadastroUsuario implements MouseListener{

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
		
		try {
			Validador.validarCadastroUsuario(nome, email, senha);
			Usuario usuario = new Usuario(nome, email, senha, true);
			central.adicionarUsuario(usuario);
			tela.dispose();
		} catch (NomeInvalidoException | EmailSemCaracterException |
				EmailInvalidoException | SenhaInvalidaException    |
				LoginInvalidoException erro) {
			FabricaJOptionPane.criarMsgErro(erro.getMessage());
		}
	}

	public void mouseEntered(MouseEvent e) {
		tela.getBtnCadastrar().setForeground(new Color(255, 255, 255));
	}
	public void mouseExited(MouseEvent e) {
		tela.getBtnCadastrar().setForeground(new Color(179, 177, 177));
	}

	
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
