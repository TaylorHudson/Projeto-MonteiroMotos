package projeto.telas.ADM;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.excecoes.usuario.DataInvalidaException;
import projeto.modelo.Corrida;
import projeto.servico.ServicoData;
import projeto.telas.ADM.ouvintes.OuvinteTelaDetalhesDaCorridaADM;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJFormatted;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.fabricas.FabricaJTextArea;
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
	
	
	public TelaDetalhesDaCorridaADM(Corrida c) {
		super("Detalhes da Corrida");
		txtNome.setText(c.getPassageiro().getNome());
		txtPontoDeEncontro.setText(c.getPontoDeEncontro());
		txtLocalDeDestino.setText(c.getLocalDeDestino());
		try {
			txtData.setText(ServicoData.retornarString(c.getData()));
		} catch (DataInvalidaException e) {
		}
		txtHora.setText(c.getHora());
		txtEmailDoMototaxista.setText(c.getEmailDoMototaxista());
		txtAvaliacao.setText(String.valueOf(c.getAvaliacao()));
		txaComentario.setText(c.getComentario());
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
		JLabel menu = FabricaJLabel.criarJLabel(10, 70, 850, 600, Color.BLACK, 4);
		menu.setBackground(Color.BLACK);
		JLabel lblNomeDoPassageiro = FabricaJLabel.criarJLabel("Nome Do Passageiro", 40, 50, 300, 30, Color.black,Color.white, 20);
		JLabel lblPontoDeEncontro = FabricaJLabel.criarJLabel("Ponto de Encontro", 40, 150, 300, 30, Color.black,Color.white, 20);
		JLabel lblLocalDeDestino = FabricaJLabel.criarJLabel("Local de Destino", 40, 250, 300, 30, Color.black,Color.white, 20);
		JLabel lblData = FabricaJLabel.criarJLabel("Data", 40, 350, 300, 30, Color.black,Color.white,20);
		JLabel lblHora = FabricaJLabel.criarJLabel("Hora", 40, 450, 300, 30, Color.black,Color.white, 20);
		JLabel lblEmailDoMototaxista = FabricaJLabel.criarJLabel("E-mail do Mototaxista", 500, 50, 300, 30, Color.black,Color.white, 20);
		JLabel lblAvaliacao = FabricaJLabel.criarJLabel("Avaliação", 500, 150, 300, 30, Color.black,Color.white, 20);
		JLabel lblComentario = FabricaJLabel.criarJLabel("Comentario", 500, 250, 300, 30, Color.black,Color.white, 20);
		
		menu.add(lblNomeDoPassageiro);
		menu.add(lblPontoDeEncontro);
		menu.add(lblLocalDeDestino);
		menu.add(lblData);
		menu.add(lblHora);
		menu.add(lblEmailDoMototaxista);
		menu.add(lblAvaliacao);
		menu.add(lblComentario);
		
		txtNome = FabricaJText.criarJTextField(40, 90, 300, 40, Color.white, Color.black, 16);
		txtPontoDeEncontro = FabricaJText.criarJTextField(40, 190, 300, 40, Color.white, Color.black, 16);
		txtLocalDeDestino = FabricaJText.criarJTextField(40, 290, 300, 40, Color.white, Color.black, 16);
		txtHora = FabricaJText.criarJTextField(40, 490, 300, 40, Color.white, Color.black, 16);
		txtEmailDoMototaxista = FabricaJText.criarJTextField(500, 90, 300, 40, Color.white, Color.black, 16);
		txtAvaliacao = FabricaJText.criarJTextField(500, 190, 300, 40, Color.white, Color.black, 16);
		txaComentario = FabricaJTextArea.criarJTextArea(500, 290, 300, 200, Color.white, Color.black);
		try {
			txtData = FabricaJFormatted.criarJFormatted(40, 390, 300, 40,new MaskFormatter("##/##/####"));
		}catch (Exception e) {
		}
		txtNome.setEditable(false);
		txtPontoDeEncontro.setEditable(false);
		txtLocalDeDestino.setEditable(false);
		txtHora.setEditable(false);
		txtEmailDoMototaxista.setEditable(false);
		txtAvaliacao.setEditable(false);
		txaComentario.setEditable(false);
		txtData.setEditable(false);
		menu.add(txtNome);
		menu.add(txtPontoDeEncontro);
		menu.add(txtLocalDeDestino);
		menu.add(txtData);
		menu.add(txtHora);
		menu.add(txtEmailDoMototaxista);
		menu.add(txtAvaliacao);
		menu.add(txaComentario);
		imagem.add(menu);
		
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


}
