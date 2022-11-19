//package projeto.telas.passageiro;
//
//import javax.swing.JPanel;
//import javax.swing.JScrollBar;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.DefaultTableModel;
//
//public class Tabela extends JTable{
//	
//	public JTable criarTabela(JPanel jpn, Object[] largura, Object [] pos, Object[] col) throws NullPointerException{
//		JTable tabela = new JTable(new DefaultTableModel());
//		
//		tabela.setVisible(true);
//		JScrollPane jsp = new JScrollPane(tabela);
//		jsp.setBounds(10, 30, 600, 130);
//		jsp.add(jsp);
//		DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
//		
//		
//		
//		for (int i = 0; 1 < col.length; i++) {
//			modeloTabela.addColumn(col[i]);
//		}
//		
//		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
//		DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
//		DefaultTableCellRenderer esqueda = new DefaultTableCellRenderer();
//		
//		for(int i = 0; i < largura.length; i++) {
//			if(pos[i].equals("centro")) {
//				pos[i] = centro;
//			}
//			if(pos[i].equals("direita")) {
//				pos[i] = direita;
//			}
//			if(pos[i].equals("direita")) {
//				pos[i] = direita;
//			}
////			tabela.getColorModel()
//			
//		}
//		
//	}
//}
