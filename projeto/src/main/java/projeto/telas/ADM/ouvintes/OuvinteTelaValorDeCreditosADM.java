package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import projeto.excecoes.usuario.ValidarCreditoException;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.ADM.TelaHomeADM;
import projeto.telas.ADM.TelaValorDeCreditosADM;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.fabricas.FabricaJPanel;
import utilidades.persistencia.Persistencia;
import utilidades.validacao.Validador;

public class OuvinteTelaValorDeCreditosADM implements ActionListener{
	private TelaValorDeCreditosADM tela;
	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central = persistencia.recuperarCentral("central");
	public OuvinteTelaValorDeCreditosADM(TelaValorDeCreditosADM tela) {
		this.tela = tela;
	}
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		String credito = tela.getTxtCreditos().getText().trim();
		credito = credito.replace(',','.');
		if(btn == tela.getBtnSalvar()) {
			double valorCredito = Double.parseDouble(credito);
			try{
				boolean valido = Validador.validarCredito(valorCredito);
				if(valido) {
					central.setValorDoCredito(valorCredito);
					persistencia.salvarCentral(central, "central");
					FabricaJOptionPane.criarMsg("Valor Salvo");
				}
				
			}catch (ValidarCreditoException erro) {
				FabricaJOptionPane.criarMsgErro(erro.getMessage());
			}
		}else if(btn == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomeADM();
		}
		
	}

}
