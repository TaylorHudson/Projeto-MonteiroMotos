package projeto.telas.ADM;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.ADM.ouvintes.OuvinteTelaListarCorridasADM;
import utilidades.fabricas.FabricaJButton;
import utilidades.imagens.Imagens;

public class TelaListarCorridasADM extends TelaPadrao {
	private JButton btnDetalhes;
	private JButton btnOrdenar;
	private ImagemDeFundo imagem;
	private JTable tabelaListarCorridas;
	private JButton btnSeta;
	private JComboBox<String> box;
	
	
	public TelaListarCorridasADM() {
		super("Lista de Corridas");
		setVisible(true);
	}
	public void configurarComponentes() {
		configImagemDeFundo();
		configBotoes();
		configTabela();
		
	}
	
	private void configImagemDeFundo() {
		imagem = super.configImagemDeFundo("background_2.jpg");
		add(imagem);
	}
	private void configBotoes() {
		OuvinteTelaListarCorridasADM ouvinte = new OuvinteTelaListarCorridasADM(this);
		OuvinteBotaoFundoPreto mouse = new OuvinteBotaoFundoPreto();
		btnDetalhes = FabricaJButton.criarJButton("Detalhes", 600, 620, 200, 40, Color.white, Color.black,28);
		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		btnOrdenar = FabricaJButton.criarJButton("Ordenar", 600, 100, 200, 40, Color.white, Color.black,28);
		
		box = new JComboBox<String>(new String[] {"Finalizada","Espera"});
		box.setBounds(350, 100, 200, 40);
		box.setFont(new Font("Arial", 1, 20));
		box.setForeground(Color.black);
		box.setBackground(Color.white);
		
		btnDetalhes.addActionListener(ouvinte);
		btnOrdenar.addActionListener(ouvinte);
		btnSeta.addActionListener(ouvinte);
		
		btnSeta.addMouseListener(mouse);
		btnDetalhes.addMouseListener(mouse);
		btnOrdenar.addMouseListener(mouse);
		box.addMouseListener(mouse);
		
		imagem.add(btnDetalhes);
		imagem.add(box);
		imagem.add(btnOrdenar);
		imagem.add(btnSeta);
		
	}
	private void configTabela() {

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "Nome do Passageiro", "Data", "Status" });
		tabelaListarCorridas = new JTable(modelo);
		tabelaListarCorridas.setFont(new Font("Arial", 1, 15));


		JScrollPane scrol = new JScrollPane(tabelaListarCorridas);
		scrol.getViewport().setBackground(Color.orange);
		scrol.setBounds(2, 200, 885, 400);

		imagem.add(scrol);
	}
	
	
	public JButton getBtnDetalhes() {
		return btnDetalhes;
	}
	public JButton getBtnOrdenar() {
		return btnOrdenar;
	}
	public JButton getBtnSeta() {
		return btnSeta;
	}
	public static void main(String[] args) {
		new TelaListarCorridasADM();
	}

}
