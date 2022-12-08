package projeto.telas.ADM;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.modelo.Corrida;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.ADM.ouvintes.OuvinteTelaDadosDosUsuarios;
import projeto.telas.mototaxista.ouvintes.OuvinteBotoesTelaListarCorridas;
import projeto.telas.passageiro.TelaListarCorridas;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;
import utilidades.persistencia.Persistencia;

public class TelaDadosDosUsuarios extends TelaPadrao{


	private JTable tabelaUsuarios;
	private JButton btnSeta;
	private ImagemDeFundo imagem;
	private JButton btnDetalhes;
	private JComboBox<String> box;
	private DefaultTableModel modelo;
	private JScrollPane scrol;
	private JButton btnOrdenar;
	private Persistencia p = new Persistencia();
	private CentralDeInformacoes central = p.recuperarCentral("central");
	private JTextField txtDados;
	
	
	
	
	public TelaDadosDosUsuarios() {
		super("Dados dos Usuarios");
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
		OuvinteTelaDadosDosUsuarios ouvinte = new OuvinteTelaDadosDosUsuarios(this);
		OuvinteBotaoFundoPreto mouse = new OuvinteBotaoFundoPreto();
		btnDetalhes = FabricaJButton.criarJButton("Detalhes", 600, 620, 200, 40, Color.white, Color.black,28);
		btnOrdenar = FabricaJButton.criarJButton("Ordenar", 600, 50, 200, 40, Color.white, Color.black,28);
		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		
		
		box = new JComboBox<String>(new String[] {"Mototaxista","Passageiro"});
		box.setBounds(520, 100, 300, 40);
		box.setFont(new Font("Arial", 1, 20));
		box.setForeground(Color.black);
		box.setBackground(Color.white);
		
		btnDetalhes.addActionListener(ouvinte);
		btnSeta.addActionListener(ouvinte);
		btnOrdenar.addActionListener(ouvinte);
		
		btnDetalhes.addMouseListener(mouse);
		btnSeta.addMouseListener(mouse);
		btnOrdenar.addMouseListener(mouse);
		
		imagem.add(btnDetalhes);
		imagem.add(box);
		imagem.add(btnSeta);
		imagem.add(btnOrdenar);
	}
	private void popularTabela() {
		popularTabelaMototaxista();
		popularTabelaPassageiro();
	}
	public void popularTabelaMototaxista() {
		p = new Persistencia();
		central = p.recuperarCentral("central");
		for (Mototaxista mototaxista: central.getMototaxistas()) {
			Object[] linha = new Object[3];
			linha[0] = mototaxista.getEmail();
			linha[1] = mototaxista.getNome();
			linha[2] = "Mototaxista";
			
			modelo.addRow(linha);
		}

	}
	public void popularTabelaPassageiro() {
		p = new Persistencia();
		central = p.recuperarCentral("central");
		for(Passageiro passageiro: central.getPassageiros()) {
			Object[] linha = new Object[3];
			linha[0] = passageiro.getEmail();
			linha[1] = passageiro.getNome();
			linha[2] = "Passageiro";
			
			modelo.addRow(linha);
		}
	}
	
	private void configTabela() {

		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "E-MAil", "Nome Completo", "Perfil Do Usuario" });
		tabelaUsuarios = new JTable(modelo);
		tabelaUsuarios.setFont(new Font("Arial", 1, 15));


		scrol = new JScrollPane(tabelaUsuarios);
		scrol.getViewport().setBackground(Color.orange);
		scrol.setBounds(2, 200, 885, 400);

		imagem.add(scrol);
	}
	private void configTexto() {
		txtDados = FabricaJText.criarJTextField(100, 100, 300, 40, Color.white, Color.black, 16);
		txtDados.addKeyListener(new OuvinteFiltro());
		imagem.add(txtDados);
		
	}
	
	

	public JButton getBtnSeta() {
		return btnSeta;
	}

	public JButton getBtnDetalhes() {
		return btnDetalhes;
	}
	public JComboBox<String> getBox() {
		return box;
	}
	public DefaultTableModel getModelo() {
		return modelo;
	}
	public JTable getTabelaUsuarios() {
		return tabelaUsuarios;
	}
	public ImagemDeFundo getImagem() {
		return imagem;
	}
	public JScrollPane getScrol() {
		return scrol;
	}
	public JButton getBtnOrdenar() {
		return btnOrdenar;
	}
	
	

	public static void main(String[] args) {
		new TelaDadosDosUsuarios();
	}
	private class OuvinteFiltro implements KeyListener {

		private TelaListarCorridas tela;
		
		
		private ArrayList<Usuario> todosOsUsuarios;
		public void keyTyped(KeyEvent e) {
			todosOsUsuarios = new ArrayList<>();
			p = new Persistencia();
			central = p.recuperarCentral("central");
			for(Passageiro p: central.getPassageiros()) {
				todosOsUsuarios.add(p);
			}
			for(Mototaxista m: central.getMototaxistas()) {
				todosOsUsuarios.add(m);
			}
			

			String filtro = txtDados.getText();
			char var = e.getKeyChar();
			if (Character.isAlphabetic(var) || Character.isWhitespace(var)) {
				filtro += var;
			} else if (Character.isDigit(var)) {
				e.consume();
				return;
			}
			modelo.setRowCount(0);
			for(Usuario u: todosOsUsuarios) {
				if(u.getEmail().contains(filtro))
					addLinha(modelo, u);
			}
			scrol.repaint();
		}


		private void addLinha(DefaultTableModel modelo, Usuario usuario) {
			Object[] linha = new Object[3];
			linha[0] = usuario.getEmail();
			linha[1] = usuario.getNome();
			linha[2] = (usuario instanceof Mototaxista)?"Mototaxista":"Passageiro";
			
			modelo.addRow(linha);
			scrol.repaint();
		}


		public void keyPressed(KeyEvent e) {

		}

		public void keyReleased(KeyEvent e) {

		}

	}
}

