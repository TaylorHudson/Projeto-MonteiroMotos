package projeto.telas.passageiro.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import projeto.excecoes.usuario.CadastroDeCorridaInvalidoException;
import projeto.excecoes.usuario.StatusDaCorridaInvalidoException;
import projeto.modelo.Corrida;
import projeto.modelo.enuns.StatusDaCorrida;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.passageiro.TelaDeCadastrarCorrida;
import projeto.telas.passageiro.TelaHomePassageiro;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;
import utilidades.validacao.Validador;

public class OuvinteBotaoTelaDeCadastrarCorrida implements ActionListener {

	private TelaDeCadastrarCorrida tela;
	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central = persistencia.recuperarCentral("central");

	public OuvinteBotaoTelaDeCadastrarCorrida(TelaDeCadastrarCorrida tela) {
		this.tela = tela;

	}

	public void actionPerformed(ActionEvent evento) {
		
		String pontoDeEncontro = tela.getTxtPontoDeEncontro().getText().trim();
		String localDeDestino = tela.getTxtLocalDestino().getText().trim();
		String complemento = tela.getTxtComplemento().getText().trim();
		boolean paraAgora = tela.getCheckBoxParaAgora().isSelected();
		StatusDaCorrida status = (paraAgora ? StatusDaCorrida.PARAAGORA : StatusDaCorrida.PARADEPOIS);
		JCheckBox cbAgora = tela.getCheckBoxParaAgora();
		JCheckBox cbDepois = tela.getCheckBoxParaDepois();

		JButton item = (JButton) evento.getSource();
		SimpleDateFormat sPDF = new SimpleDateFormat("dd/MM/yyyy");

		try {
			String data = sPDF.format(tela.getChooser().getDate());
			boolean valido = Validador.validarCorrida(pontoDeEncontro, localDeDestino, complemento);
			boolean validarCheckBox = Validador.validarStatusDaCorrida(cbAgora, cbDepois);
			if (valido && validarCheckBox) {
				central.adicionarCorrida(new Corrida(pontoDeEncontro, localDeDestino, complemento, status, true));
				persistencia.salvarCentral(central, "central");
				System.out.println("salvo");

			} else if(tela.getTxtHora() == null) {
				FabricaJOptionPane.criarMsgErro("Os campos de hora devem estar preenchido");
			}

		} catch (CadastroDeCorridaInvalidoException | StatusDaCorridaInvalidoException e) {
			FabricaJOptionPane.criarMsgErro(e.getMessage());
			tela.getTxtHora().setText("");

		}
		if (item == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomePassageiro();

		} else if (item == tela.getBtnSalvar()) {

		}

	}

}
