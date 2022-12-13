package projeto.telas.ADM;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.excecoes.usuario.DataInvalidaException;
import projeto.modelo.Corrida;
import projeto.modelo.Usuario;
import projeto.modelo.enuns.AndamentoDaCorrida;
import projeto.modelo.enuns.StatusDaCorrida;
import projeto.repositorio.CentralDeInformacoes;
import projeto.servico.ServicoData;
import projeto.telas.ADM.ouvintes.OuvinteTelaListarCorridasADM;
import projeto.telas.passageiro.TelaListarCorridas;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;
import utilidades.persistencia.Persistencia;

public class TelaListarCorridasADM extends TelaPadrao {
	private JButton btnDetalhes;
	private JButton btnOrdenar;
	private ImagemDeFundo imagem;
	private JTable tabelaListarCorridas;
	private JButton btnSeta;
	private JComboBox<String> box;
	private DefaultTableModel modelo;
	private JScrollPane scrol;
	private Persistencia p = new Persistencia();
	private CentralDeInformacoes central = p.recuperarCentral("central");
	private JTextField txtDados;
	
	public TelaListarCorridasADM() {
		super("Lista de Corridas");
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
	private void configTexto() {
		txtDados = FabricaJText.criarJTextField(50, 100, 200, 40, Color.white, Color.black, 16);
		txtDados.addKeyListener(new OuvinteFiltro());
		imagem.add(txtDados);
	}
	private void popularTabela() {
		popularTabelaEspera();
		popularTabelaFinalizada();
		
	}
	public void popularTabelaEspera() {
		p = new Persistencia();
		central = p.recuperarCentral("central");
		Object[] linha = new Object[4];
		for (Corrida c : central.getCorridas()) {
			if(c.getAndamento() == AndamentoDaCorrida.ESPERA ) {
				
				linha[0] = c.getPassageiro().getNome();
				try {
					linha[1] = ServicoData.retornarString(c.getData());
				} catch (DataInvalidaException e) {
				}
				linha[2] = ("Espera");
				linha[3] = c.getId();

				modelo.addRow(linha);
			}
		}
	}
	public void popularTabelaFinalizada() {
		p = new Persistencia();
		central = p.recuperarCentral("central");
		for (Corrida c : central.getCorridas()) {
			if(c.getAndamento() == AndamentoDaCorrida.FINALIZADA) {
				Object[] linha = new Object[4];
				linha[0] = c.getPassageiro().getNome();
				try {
					linha[1] = ServicoData.retornarString(c.getData());
				} catch (DataInvalidaException e) {
				}
				linha[2] = ("Finalizada");
				linha[3] = c.getId();
				modelo.addRow(linha);
			}
		}
	}
	private void configTabela() {

		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "Nome do Passageiro", "Data", "Status","ID" });
		tabelaListarCorridas = new JTable(modelo);
		tabelaListarCorridas.setFont(new Font("Arial", 1, 15));


		scrol = new JScrollPane(tabelaListarCorridas);
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
	
	public JComboBox<String> getBox() {
		return box;
	}
	
	public DefaultTableModel getModelo() {
		return modelo;
	}
	public JScrollPane getScrol() {
		return scrol;
	}
	
	public JTable getTabelaListarCorridas() {
		return tabelaListarCorridas;
	}
	private class OuvinteFiltro implements KeyListener {


		
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
			for(Corrida c: central.getCorridas()) {
				if(c.getPassageiro().getNome().contains(filtro))
					addLinha(modelo, c);
			}
			scrol.repaint();
			
		}
		public void addLinha(DefaultTableModel modelo, Corrida corrida) {
			Object[] linha = new Object[4];
			linha[0] = corrida.getPassageiro().getNome();
			try {
				linha[1] = ServicoData.retornarString(corrida.getData());
			} catch (DataInvalidaException e) {
			}
			linha[2] = (corrida.getAndamento() == AndamentoDaCorrida.ESPERA) ? "Espera" : "Finalizada";
			linha[3] = corrida.getId();
			
			modelo.addRow(linha);
		}
		public void keyPressed(KeyEvent e) {
		}
		public void keyReleased(KeyEvent e) {		
		}
	}
}
