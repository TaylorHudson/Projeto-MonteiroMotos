package projeto.telas.passageiro.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import projeto.TelaPadrao;
import projeto.excecoes.usuario.CadastroDeCorridaInvalidoException;
import projeto.excecoes.usuario.DataInvalidaException;
import projeto.excecoes.usuario.StatusDaCorridaInvalidoException;
import projeto.excecoes.usuario.ValidacaoDaHoraException;
import projeto.excecoes.usuario.VerificacaoDeCorridaException;
import projeto.modelo.Corrida;
import projeto.modelo.enuns.StatusDaCorrida;
import projeto.repositorio.CentralDeInformacoes;
import projeto.servico.ServicoData;
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

		if (item == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomePassageiro();

		} else if (item == tela.getBtnSalvar()) {
			try {
				String data = sPDF.format(tela.getChooser().getDate());
				boolean valido = Validador.validarCorrida(pontoDeEncontro, localDeDestino, complemento);
				boolean validarCheckBox = Validador.validarStatusDaCorrida(cbAgora, cbDepois);
				if (valido && validarCheckBox) {
					if (tela.getTxtHora().getText().isBlank()) {
						throw new ValidacaoDaHoraException();

					} else {
						central.adicionarCorrida(new Corrida(status, pontoDeEncontro, localDeDestino, complemento,
								TelaPadrao.passageiroLogado, ServicoData.retornarData(data)));
						persistencia.salvarCentral(central, "central");
						tela.dispose();
						new TelaHomePassageiro();
					}
				}

			} catch (CadastroDeCorridaInvalidoException | StatusDaCorridaInvalidoException | DataInvalidaException
					| VerificacaoDeCorridaException | ValidacaoDaHoraException e) {
				FabricaJOptionPane.criarMsgErro(e.getMessage());
				tela.getTxtHora().setText("");
			}
		}

	}

}
