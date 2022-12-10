package projeto.telas.ADM;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.excecoes.usuario.DataInvalidaException;
import projeto.modelo.Corrida;
import projeto.modelo.CreditosDeRevindicacao;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import projeto.servico.ServicoData;
import projeto.telas.ADM.ouvintes.OuvinteTelaFinancasADM;
import projeto.telas.passageiro.TelaListarCorridas;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;
import utilidades.persistencia.Persistencia;

public class TelaFinancasADM extends TelaPadrao {
	
	private JButton btnSeta;
	private JButton btnGerarRelatorio;
	private JButton btnOrdenar;
	private ImagemDeFundo imagem;
	private JTable tabelaFinancas;
	private DefaultTableModel modelo;
	private JScrollPane scrol;
	private Persistencia p = new Persistencia();
	private CentralDeInformacoes central = p.recuperarCentral("central");
	private JTextField txtDados;
	
	public TelaFinancasADM() {
		super("Finanças");	
		setVisible(true);
	}
	public void configurarComponentes() {
		configImagemDeFundo();
		configBotoes();
		configTabela();
		popularTabela();
		configTexto();
	}
	private void configImagemDeFundo() {
		imagem = super.configImagemDeFundo("background_2.jpg");
		add(imagem);
	}
	private void configTexto() {
		txtDados = FabricaJText.criarJTextField(100, 100, 300, 40, Color.white, Color.black, 16);
		txtDados.addKeyListener(new OuvinteFiltro());
		imagem.add(txtDados);
	}
	
	
	private void configBotoes() {
		
		OuvinteTelaFinancasADM ouvinte = new OuvinteTelaFinancasADM(this);
		OuvinteBotaoFundoPreto mouse = new OuvinteBotaoFundoPreto();
		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		btnGerarRelatorio = FabricaJButton.criarJButton("Gerar Relatorio", 270, 650, 300, 40, Color.white, Color.black,28);
		btnOrdenar = FabricaJButton.criarJButton("Ordenar", 600, 100, 150, 40, Color.white, Color.black, 28);
		
		btnGerarRelatorio.addActionListener(ouvinte);
		btnSeta.addActionListener(ouvinte);
		btnOrdenar.addActionListener(ouvinte);
		
		btnGerarRelatorio.addMouseListener(mouse);
		btnSeta.addMouseListener(mouse);
		btnOrdenar.addMouseListener(mouse);
		
		imagem.add(btnGerarRelatorio);
		imagem.add(btnSeta);
		imagem.add(btnOrdenar);
		
	}
	private void popularTabela() {
		p = new Persistencia();
		central = p.recuperarCentral("central");
		for(CreditosDeRevindicacao c: central.getCreditosDoSistema()) {
			Object[] linha = new Object[4];
			linha[0] = c.getMototaxista().getEmail();
			linha[1] = c.getQuantidadeDeCreditos();
			linha[3] = c.getValorDosCreditos();
			try {
				linha[2] = ServicoData.retornarString(c.getDataDaCompra());
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
	
	public JButton getBtnOrdenar() {
		return btnOrdenar;
	}
	public static void main(String[] args) {
		new TelaFinancasADM();
	}
	private class OuvinteFiltro implements KeyListener {

		private TelaListarCorridas tela;
		
		
		
		public void keyTyped(KeyEvent e) {
			String filtro = txtDados.getText();
			char var = e.getKeyChar();
			if (Character.isAlphabetic(var) || Character.isDigit(var)) {
				filtro += var;
			} 
			else if(Character.isWhitespace(var)) {
				e.consume();
				return;
			}
			modelo.setRowCount(0);
			for(Mototaxista m : central.getMototaxistas()) {
				if(m.getEmail().contains(filtro))
					addLinha(modelo,m);
			}
			scrol.repaint();
		}


		private void addLinha(DefaultTableModel modelo, Mototaxista m) {
			Object[] linha = new Object[4];
			linha[0] = m.getEmail();
			linha[1] = m.getCreditosReivindicacao();
			linha[3] = central.getValorDoCredito();
			try {
				linha[2] = ServicoData.retornarString(m.getDataDaUltimaCompra());
			} catch (DataInvalidaException e) {}
			modelo.addRow(linha);
			scrol.repaint();
		}


		
		public void keyPressed(KeyEvent e) {	
		}
		public void keyReleased(KeyEvent e) {		
		}
	}
}
