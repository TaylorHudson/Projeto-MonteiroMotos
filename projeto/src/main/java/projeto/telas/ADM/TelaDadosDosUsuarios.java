package projeto.telas.ADM;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import projeto.telas.ADM.ouvintes.OuvinteTelaDadosDosUsuarios;
import projeto.telas.mototaxista.ouvintes.OuvinteBotoesTelaListarCorridas;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;
import utilidades.persistencia.Persistencia;

public class TelaDadosDosUsuarios extends TelaPadrao{


	private JTable tabelaUsuarios;
	private JButton btnSeta;
	private ImagemDeFundo imagem;
	private JButton btnDetalhes;
	private JComboBox<String> box;
	private DefaultTableModel modelo;
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

	private JScrollPane scrol;
	private JButton btnOrdenar;
	
	
	public TelaDadosDosUsuarios() {
		super("Dados dos Usuarios");
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
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");
		for (Mototaxista mototaxista: central.getMototaxistas()) {
			Object[] linha = new Object[3];
			linha[0] = mototaxista.getEmail();
			linha[1] = mototaxista.getNome();
			linha[2] = "Mototaxista";
			
			modelo.addRow(linha);
		}

	}
	public DefaultTableModel getModelo() {
		return modelo;
	}
	public void popularTabelaPassageiro() {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");
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
	
	

	public JButton getBtnSeta() {
		return btnSeta;
	}

	public JButton getBtnDetalhes() {
		return btnDetalhes;
	}
	public JComboBox<String> getBox() {
		return box;
	}

	public static void main(String[] args) {
		new TelaDadosDosUsuarios();
	}
}
