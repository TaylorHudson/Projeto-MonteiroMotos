package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import projeto.telas.ADM.TelaFinancasADM;
import projeto.telas.ADM.TelaHomeADM;
import utilidades.pdf.GeradorDeRelatorios;

public class OuvinteTelaFinancasADM implements ActionListener{
	
	private TelaFinancasADM tela;
	
	public OuvinteTelaFinancasADM(TelaFinancasADM tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if(btn == tela.getBtnGerarRelatorio()) {
			GeradorDeRelatorios.obterRelatorioDeCreditos();
		}else if(btn == tela.getBtnSeta()) {
			tela.dispose();
			new TelaHomeADM();
		}
	}
}
