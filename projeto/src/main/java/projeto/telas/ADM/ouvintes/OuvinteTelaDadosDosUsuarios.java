package projeto.telas.ADM.ouvintes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.ADM.TelaDadosDosUsuarios;
import projeto.telas.ADM.TelaDeEdicaoDosDadosDosUsuarios;
import projeto.telas.ADM.TelaHomeADM;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;

public class OuvinteTelaDadosDosUsuarios implements ActionListener {
	private TelaDadosDosUsuarios tela;
	private CentralDeInformacoes central = new Persistencia().recuperarCentral("central");

	public OuvinteTelaDadosDosUsuarios(TelaDadosDosUsuarios tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		String tipo = (String) tela.getBox().getSelectedItem();
		Mototaxista mototaxista = null;
		Passageiro passageiro = null;
		if (btn == tela.getBtnDetalhes()) {
			int var = tela.getTabelaUsuarios().getSelectedRow();
			if (var == -1)
				FabricaJOptionPane.criarMsgErro("Selecione algum usuario");
			else {
				String emailSelecionado = (String) tela.getModelo().getValueAt(var, 0);
				String tipoSelecionado = (String) tela.getModelo().getValueAt(var, 2);
				try {
					if (tipoSelecionado.equals("Mototaxista")) {

						mototaxista = central.recuperarMototaxistaPeloEmail(emailSelecionado);
					} else if(tipoSelecionado.equals("Passageiro")) {
						passageiro = central.recuperarPassageiroPeloEmail(emailSelecionado);
					}
				} catch (UsuarioNaoExisteException e1) {
				}
			}	
			if(mototaxista != null) {
				tela.dispose();
				new TelaDeEdicaoDosDadosDosUsuarios(mototaxista);
			}
			else if(passageiro != null) {
				tela.dispose();
				new TelaDeEdicaoDosDadosDosUsuarios(passageiro);
			}
		} else if (btn == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomeADM();
		} else if (btn == tela.getBtnOrdenar()) {
			if (tipo.equals("Mototaxista")) {
				tela.getModelo().setRowCount(0);
				tela.popularTabelaMototaxista();
				tela.repaint();

			} else if (tipo.equals("Passageiro")) {
				tela.getModelo().setRowCount(0);
				tela.popularTabelaPassageiro();
				tela.repaint();
			}
		}

	}

}
