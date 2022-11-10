package utilidades.fabricas;

import javax.swing.JOptionPane;

public abstract class FabricaJOptionPane {

	public static void criarMsgErro(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void criarMsgAtencao(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Atenção", JOptionPane.WARNING_MESSAGE);
	}
	
}
