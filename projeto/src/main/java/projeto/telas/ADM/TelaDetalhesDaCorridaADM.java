package projeto.telas.ADM;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.telas.ADM.ouvintes.OuvinteTelaDetalhesDaCorridaADM;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaDetalhesDaCorridaADM extends TelaPadrao{
	private JTextField txtNome;
	private JTextField txtPontoDeEncontro;
	private JTextField txtLocalDeDestino;
	private JTextField txtData;
	private JTextField txtHora;
	private JTextField txtEmailDoMototaxista;
	private JTextField txtAvaliacao;
	private JTextArea txaComentario;
	private JButton btnSeta;
	private ImagemDeFundo imagem;
	
	public TelaDetalhesDaCorridaADM() {
		super("Detalhes da Corrida");
		setVisible(true);
	}
	
	public void configurarComponentes() {
		configImagemDeFundo();
		configBotoes();
		configTexto();
	}
	
	
	private void configImagemDeFundo() {
		imagem = super.configImagemDeFundo("background_2.jpg");
		add(imagem);
	}
	
	private void configBotoes() {
		OuvinteTelaDetalhesDaCorridaADM ouvinte = new OuvinteTelaDetalhesDaCorridaADM(this);
		OuvinteBotaoFundoPreto mouse = new OuvinteBotaoFundoPreto();
		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		
		btnSeta.addMouseListener(mouse);
		btnSeta.addActionListener(ouvinte);
		
		imagem.add(btnSeta);
	}
	
	private void configTexto() {
		JLabel lblNomeDoPassageiro = FabricaJLabel.criarJLabel("Nome Do Passageiro", 40, 100, 300, 30, Color.orange,Color.black, 20);
		JLabel lblPontoDeEncontro = FabricaJLabel.criarJLabel("Ponto de Encontro", 40, 200, 300, 30, Color.orange,Color.black, 20);
		JLabel lblLocalDeDestino = FabricaJLabel.criarJLabel("Local de Destino", 40, 300, 300, 30, Color.orange,Color.black, 20);
		JLabel lblData = FabricaJLabel.criarJLabel("Data", 40, 400, 300, 30, Color.orange,Color.black, 20);
		JLabel lblHora = FabricaJLabel.criarJLabel("Hora", 40, 500, 300, 30, Color.orange,Color.black, 20);
		JLabel lblEmailDoMototaxista = FabricaJLabel.criarJLabel("E-mail do Mototaxista", 500, 100, 300, 30, Color.orange,Color.black, 20);
		JLabel lblAvaliacao = FabricaJLabel.criarJLabel("Avaliação", 500, 200, 300, 30, Color.orange,Color.black, 20);
		JLabel lblComentario = FabricaJLabel.criarJLabel("Comentario", 500, 300, 300, 30, Color.orange,Color.black, 20);
		
		imagem.add(lblNomeDoPassageiro);
		imagem.add(lblPontoDeEncontro);
		imagem.add(lblLocalDeDestino);
		imagem.add(lblData);
		imagem.add(lblHora);
		imagem.add(lblEmailDoMototaxista);
		imagem.add(lblAvaliacao);
		imagem.add(lblComentario);
		
		txtNome = FabricaJText.criarJTextField(40, 140, 300, 40, Color.orange, Color.black, 16);
		txtPontoDeEncontro = FabricaJText.criarJTextField(40, 240, 300, 40, Color.orange, Color.black, 16);
		txtLocalDeDestino = FabricaJText.criarJTextField(40, 340, 300, 40, Color.orange, Color.black, 16);
		txtData = FabricaJText.criarJTextField(40, 440, 300, 40, Color.orange, Color.black, 16);
		txtHora = FabricaJText.criarJTextField(40, 540, 300, 40, Color.orange, Color.black, 16);
		txtEmailDoMototaxista = FabricaJText.criarJTextField(500, 140, 300, 40, Color.orange, Color.black, 16);
		txtAvaliacao = FabricaJText.criarJTextField(500, 240, 300, 40, Color.orange, Color.black, 16);
		//txaComentario = 
		
		imagem.add(txtNome);
		imagem.add(txtPontoDeEncontro);
		imagem.add(txtLocalDeDestino);
		imagem.add(txtData);
		imagem.add(txtHora);
		imagem.add(txtEmailDoMototaxista);
		imagem.add(txtAvaliacao);
		
	}
	
	
	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextField getTxtPontoDeEncontro() {
		return txtPontoDeEncontro;
	}

	public JTextField getTxtLocalDeDestino() {
		return txtLocalDeDestino;
	}

	public JTextField getTxtData() {
		return txtData;
	}

	public JTextField getTxtHora() {
		return txtHora;
	}

	public JTextField getTxtEmailDoMototaxista() {
		return txtEmailDoMototaxista;
	}

	public JTextField getTxtAvaliacao() {
		return txtAvaliacao;
	}

	public JTextArea getTxaComentario() {
		return txaComentario;
	}

	public JButton getBtnSeta() {
		return btnSeta;
	}

	public static void main(String[] args) {
		new TelaDetalhesDaCorridaADM();
	}
	
	
	

}
