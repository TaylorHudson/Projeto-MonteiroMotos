package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import projeto.TelaPadrao;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.modelo.Mototaxista;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.mototaxista.TelaComprarCreditos;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.pdf.GeradorDeRelatorios;
import utilidades.persistencia.Persistencia;

public class OuvinteTelaComprarCreditos implements ActionListener {

	private TelaComprarCreditos tela;
	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central = persistencia.recuperarCentral("central");

	public OuvinteTelaComprarCreditos(TelaComprarCreditos tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();

		if (componente == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomeMototaxista();
		} else if (componente == tela.getBtnGerarBoleto()) {
			if (central.getValorDoCredito() == 0) {
				FabricaJOptionPane.criarMsgErro("Não foi possível comprar os créditos no momento");
			} else {
				int qtd = (Integer) tela.getSpinner().getValue();
				if (qtd > 0) {
					String valorString = tela.getTxtPrecoTotal().getText().replace(',', '.');
					double valor = Double.parseDouble(valorString);
					GeradorDeRelatorios.gerarBoleto(qtd, valor);

					String email = TelaPadrao.mototaxistaLogado.getEmail();
					try {
						Mototaxista m = central.recuperarMototaxistaPeloEmail(email);
						m.setCreditosReivindicacao(m.getCreditosReivindicacao() + qtd);
						m.setDataDaUltimaCompra(LocalDate.now());
						persistencia.salvarCentral(central, "central");
					} catch (UsuarioNaoExisteException e1) {
					}

					FabricaJOptionPane.criarMsg("Compra realizada com sucesso");
				}
			}
		}
	}

}
