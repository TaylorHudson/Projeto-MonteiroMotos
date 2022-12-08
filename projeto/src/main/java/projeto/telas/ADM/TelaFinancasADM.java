package projeto.telas.ADM;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.excecoes.usuario.DataInvalidaException;
import projeto.modelo.Mototaxista;
import projeto.repositorio.CentralDeInformacoes;
import projeto.servico.ServicoData;
import projeto.telas.ADM.ouvintes.OuvinteTelaFinancasADM;
import utilidades.fabricas.FabricaJButton;
import utilidades.imagens.Imagens;
import utilidades.persistencia.Persistencia;

public class TelaFinancasADM extends TelaPadrao {
	
	private JButton btnSeta;
	private JButton btnGerarRelatorio;
	private ImagemDeFundo imagem;
	private JTable tabelaFinancas;
	private DefaultTableModel modelo;
	private JScrollPane scrol;
	private Persistencia p = new Persistencia();
	private CentralDeInformacoes central = p.recuperarCentral("central");
	
	public TelaFinancasADM() {
		super("Finanças");	
		setVisible(true);
	}
	public void configurarComponentes() {
		configImagemDeFundo();
		configBotoes();
		configTabela();
		popularTabela();
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
	private void popularTabela() {
		p = new Persistencia();
		central = p.recuperarCentral("central");
		for(Mototaxista mototaxista: central.getMototaxistas()) {
			Object[] linha = new Object[4];
			linha[0] = mototaxista.getEmail();
			linha[1] = mototaxista.getCreditosReivindicacao();
			linha[3] = central.getValorDoCredito();
			try {
				linha[2] = ServicoData.retornarString(mototaxista.getDataDaUltimaCompra());
			} catch (DataInvalidaException e) {}
			
			modelo.addRow(linha);
		}
	}
	
	
	
	
	private void configTabela() {

		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "Email", "Quantidade de Creditos", "Data da Compra","Valor de cada Credito" });
		tabelaFinancas = new JTable(modelo);
		tabelaFinancas.setFont(new Font("Arial", 1, 15));

		scrol = new JScrollPane(tabelaFinancas);
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
