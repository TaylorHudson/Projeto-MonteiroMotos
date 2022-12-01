package projeto.telas.ADM;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.ADM.ouvintes.OuvinteTelaFinancasADM;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;

public class TelaFinancasADM extends TelaPadrao {
	
	private JButton btnSeta;
	private JButton btnGerarRelatorio;
	private ImagemDeFundo imagem;
	private JTable tabelaMototaxistas;
	
	public TelaFinancasADM() {
		super("Finanças");	
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
		
		OuvinteTelaFinancasADM ouvinte = new OuvinteTelaFinancasADM(this);
		OuvinteBotaoFundoPreto mouse = new OuvinteBotaoFundoPreto();
		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		btnGerarRelatorio = FabricaJButton.criarJButton("Gerar Relatorio", 270, 650, 300, 40, Color.white, Color.black,28);
		
		btnGerarRelatorio.addActionListener(ouvinte);
		btnSeta.addActionListener(ouvinte);
		
		btnGerarRelatorio.addMouseListener(mouse);
		btnSeta.addMouseListener(mouse);
		
		imagem.add(btnGerarRelatorio);
		imagem.add(btnSeta);
		
	}
	
	
	private void configTabela() {

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "E-MAil", "Quantidade de Creditos", "Data da Compra","Valor de cada Credito" });
		tabelaMototaxistas = new JTable(modelo);
		tabelaMototaxistas.setFont(new Font("Arial", 1, 15));
		modelo.addRow(new String [] {"nguearngu", "456", "10/20/2000","2"});

		JScrollPane scrol = new JScrollPane(tabelaMototaxistas);
		scrol.getViewport().setBackground(Color.orange);
		scrol.setBounds(2, 200, 885, 400);

		imagem.add(scrol);
	}
	public JButton getBtnSeta() {
		return btnSeta;
	}
	
	public JButton getBtnGerarRelatorio() {
		return btnGerarRelatorio;
	}
	public static void main(String[] args) {
		new TelaFinancasADM();
	}

}
