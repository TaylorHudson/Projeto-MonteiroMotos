package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import projeto.TelaPadrao;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.modelo.Mototaxista;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.mototaxista.TelaEdicaoPerfil;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import projeto.telas.usuario.TelaLogin;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;

public class OuvinteMenuTelaHome implements ActionListener {

	private TelaHomeMototaxista tela;

	public OuvinteMenuTelaHome(TelaHomeMototaxista tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");
		
		JMenuItem item = (JMenuItem) e.getSource();

		if (item == tela.getItemEditar()) {
			tela.dispose();
			new TelaEdicaoPerfil();

		} else if (item == tela.getItemDeletar()) {
			int opc = FabricaJOptionPane.criarMsgDeOpcao("Escolha", "Deseja deletar sua conta?");
			if (opc == JOptionPane.YES_OPTION) {
				try {
					Mototaxista mototaxi = central.recuperarMototaxistaPeloEmail(TelaPadrao.mototaxistaLogado.getEmail());
					mototaxi.setEstaAtivo(false);
					p.salvarCentral(central, "central");
					tela.dispose();
					new TelaLogin();
				} catch (UsuarioNaoExisteException e1) {}
			}

		} else {
			int opc = FabricaJOptionPane.criarMsgDeOpcao("Escolha", "Deseja sair?");
			if (opc == JOptionPane.YES_OPTION) {
				tela.dispose();
				new TelaLogin();
				TelaPadrao.mototaxistaLogado = null;
			}

		}
	}

}
