package projeto.telas.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

import projeto.telas.TelaLogin;
import projeto.telas.ADM.TelaCadastroADM;

public class OuvintesTelaDeCadastroADM implements ActionListener {
	
	private TelaCadastroADM tela;
	
	public OuvintesTelaDeCadastroADM(TelaCadastroADM tela) {
		this.tela = tela;
	}
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == tela.getBtnCadastrar()){
			new TelaLogin();			
			
		}
		
		
	}

}
