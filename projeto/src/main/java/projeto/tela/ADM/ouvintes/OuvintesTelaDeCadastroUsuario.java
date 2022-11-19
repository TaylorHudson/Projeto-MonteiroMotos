package projeto.tela.ADM.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

import projeto.tela.ADM.TelaCadastroADM;
import projeto.telas.TelaCadastroUsuario;

public class OuvintesTelaDeCadastroUsuario implements ActionListener {
	
	private TelaCadastroADM tela;
	
	public OuvintesTelaDeCadastroUsuario(TelaCadastroADM tela) {
		this.tela = tela;
	}
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == tela.getBtnCadastrar()){
			new TelaCadastroUsuario();			
			
		}
		
		
	}

}
