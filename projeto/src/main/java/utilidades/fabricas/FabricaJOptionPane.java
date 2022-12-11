package utilidades.fabricas;

import javax.swing.JOptionPane;

public abstract class FabricaJOptionPane {

	public static void criarMsgErro(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void criarMsgAtencao(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Atenção", JOptionPane.WARNING_MESSAGE);
	}
	
	public static int criarMsgDeOpcao(String titulo, String msg) {
		int opc = JOptionPane.showConfirmDialog(null, msg, titulo,JOptionPane.YES_NO_OPTION);
		return opc;
	}
	public static String criarInput(String msg) {
		String codigo = JOptionPane.showInputDialog(msg);
		return codigo;
	}
	public static void criarMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Informaçao", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
