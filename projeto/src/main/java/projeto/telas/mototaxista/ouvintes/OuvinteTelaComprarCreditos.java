package projeto.telas.mototaxista.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import projeto.TelaPadrao;
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.modelo.CreditosDeRevindicacao;
import projeto.modelo.Mototaxista;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.mototaxista.TelaComprarCreditos;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.pdf.GeradorDeRelatorios;
import utilidades.persistencia.Persistencia;

public class OuvinteTelaComprarCreditos implements ActionListener {

	private TelaComprarCreditos tela;

	public OuvinteTelaComprarCreditos(TelaComprarCreditos tela) {
		this.tela = tela;
	}

	private void comprarCredito(Persistencia p, CentralDeInformacoes c, int qtd) {
		String email = TelaPadrao.mototaxistaLogado.getEmail();

		try {
			Mototaxista m = c.recuperarMototaxistaPeloEmail(email);
			m.setCreditosReivindicacao(m.getCreditosReivindicacao() + qtd);
			m.setDataDaUltimaCompra(LocalDate.now());

			CreditosDeRevindicacao credito = new CreditosDeRevindicacao(m, LocalDate.now(), qtd, c.getValorDoCredito());
			c.adicionarReivindicacao(credito);

			p.salvarCentral(c, "central");
			FabricaJOptionPane.criarMsg("Compra realizada com sucesso");
			
			tela.dispose();
			new TelaHomeMototaxista();
		} catch (UsuarioNaoExisteException e1) {
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		if (componente == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomeMototaxista();
		} else if (componente == tela.getBtnGerarBoleto()) {
			int qtd = (Integer) tela.getSpinner().getValue();

			if (central.getValorDoCredito() == 0) {
				FabricaJOptionPane.criarMsgErro("Nao foi possivel comprar os creditos no momento");
			} else if (qtd > 0) {
				String valorString = tela.getTxtPrecoTotal().getText().replace(',', '.');
				double valor = Double.parseDouble(valorString);
				GeradorDeRelatorios.gerarBoleto(qtd, valor);

				comprarCredito(persistencia, central, qtd);
			}
		}
	}
}
