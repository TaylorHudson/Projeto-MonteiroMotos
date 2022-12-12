package projeto.telas.passageiro.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import projeto.TelaPadrao;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.passageiro.TelaHomePassageiro;
import projeto.telas.usuario.TelaEdicaoPerfil;
import projeto.telas.usuario.TelaLogin;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;

public class OuvinteDoMenuDaTelaHomePassageiro implements ActionListener {

	private TelaHomePassageiro tela;

	public OuvinteDoMenuDaTelaHomePassageiro(TelaHomePassageiro tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent evento) {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");

		JMenuItem item = (JMenuItem) evento.getSource();

		if (item == tela.getItemSair()) {
			int opcSair = FabricaJOptionPane.criarMsgDeOpcao("Escolha", "Deseja sair?");
			if (opcSair == JOptionPane.YES_OPTION) {
				tela.dispose();
				new TelaLogin();
				TelaPadrao.mototaxistaLogado = null;
			}
		} else if (item == tela.getItemDeletar()) {
			int opcDeletar = FabricaJOptionPane.criarMsgDeOpcao("Escolha", "Deseja deletar sua conta?");
			if (opcDeletar == JOptionPane.YES_OPTION)
				try {
					Passageiro passageiro = central
							.recuperarPassageiroPeloEmail(TelaPadrao.passageiroLogado.getEmail());
					passageiro.setEstaAtivo(false);
					p.salvarCentral(central, "central");
					tela.dispose();
					new TelaLogin();
				} catch (UsuarioNaoExisteException e1) {
				}
		} else if (item == tela.getItemEditar()) {
			tela.dispose();
			new TelaEdicaoPerfil();
		}
	}
}
