package projeto.telas.usuario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import projeto.ImagemDeFundo;
import projeto.OuvinteBotaoFundoPreto;
import projeto.TelaPadrao;
import projeto.excecoes.usuario.DataInvalidaException;
import projeto.excecoes.usuario.EmailEmUsoException;
import projeto.excecoes.usuario.ValidacaoException;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import projeto.servico.ServicoData;
import projeto.telas.ADM.TelaHomeADM;
import projeto.telas.mototaxista.TelaHomeMototaxista;
import projeto.telas.passageiro.TelaHomePassageiro;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJFormatted;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;
import utilidades.persistencia.Persistencia;

public class TelaEdicaoPerfil extends TelaPadrao {

	private JTextField txtNomeCompleto;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JFormattedTextField txtData;
	private JButton btnSeta;
	private ImagemDeFundo background;
	private JButton btnSalvar;

	public TelaEdicaoPerfil() {
		super("Tela para editar perfil");
		setVisible(true);
	}

	@Override
	public void configurarComponentes() {
		configImagemFundo();
		configMenu();
		carregarDados();
	}

	private void carregarDados() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		Mototaxista mototaxi = TelaPadrao.mototaxistaLogado;
		Passageiro passageiro = TelaPadrao.passageiroLogado;
		Usuario adm = central.getAdministrador();

		if (mototaxi != null)
			carregarDadosDoUsuario(mototaxi);
		else if (passageiro != null)
			carregarDadosDoUsuario(passageiro);
		else
			carregarDadosDoUsuario(adm);
	}

	private void carregarDadosDoUsuario(Usuario usuario) {
		txtNomeCompleto.setText(usuario.getNome());
		txtEmail.setText(usuario.getEmail());
		txtSenha.setText(usuario.getSenha());
		try {
			txtData.setText(ServicoData.retornarString(usuario.getDataNascimento()));
		} catch (DataInvalidaException e) {
		}
	}

	private void configImagemFundo() {
		background = super.configImagemDeFundo("background_2.jpg");
		add(background);
	}

	private void configMenu() {
		OuvinteBotoesTelaEdicao ouvinte = new OuvinteBotoesTelaEdicao(this);
		OuvinteBotaoFundoPreto ouvinteBotao = new OuvinteBotaoFundoPreto();

		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		btnSeta.addMouseListener(new OuvinteBotaoFundoPreto());
		btnSeta.addActionListener(ouvinte);

		JLabel menu = FabricaJLabel.criarJLabel(80, 80, 700, 620, Color.BLACK, 3);
		menu.setBackground(Color.BLACK);

		JLabel lblNomeCompleto = FabricaJLabel.criarJLabel("Nome Completo", 30, 60, 460, 40, Color.white, 25);
		txtNomeCompleto = FabricaJText.criarJTextField(30, 100, 640, 40, Color.white, Color.BLACK, 16);

		JLabel lblEmail = FabricaJLabel.criarJLabel("Email", 30, 140, 460, 40, Color.white, 25);
		txtEmail = FabricaJText.criarJTextField(30, 180, 640, 40, Color.white, Color.BLACK, 16);

		JLabel lblSenha = FabricaJLabel.criarJLabel("Senha", 30, 220, 460, 40, Color.white, 25);
		txtSenha = FabricaJText.criarJPasswordField(30, 260, 640, 40, Color.white, Color.BLACK, 16);
		txtSenha.setEditable(false);

		JLabel lblDataNascimento = FabricaJLabel.criarJLabel("Data de Nascimento", 30, 300, 460, 40, Color.white, 25);
		try {
			txtData = FabricaJFormatted.criarJFormatted(30, 340, 640, 40, new MaskFormatter("##/##/####"));
		} catch (Exception e) {
		}

		btnSalvar = FabricaJButton.criarJButton("Salvar", 270, 470, 150, 50, Color.WHITE, Color.BLACK, 25);
		btnSalvar.addActionListener(ouvinte);
		btnSalvar.addMouseListener(ouvinteBotao);

		menu.add(lblNomeCompleto);
		menu.add(txtNomeCompleto);
		menu.add(lblEmail);
		menu.add(txtEmail);
		menu.add(lblSenha);
		menu.add(txtSenha);
		menu.add(lblDataNascimento);
		menu.add(txtData);
		menu.add(btnSalvar);
		background.add(menu);
		background.add(btnSeta);
		add(background);
	}

	/*
	 * ------------------------------------------------ Refatorar essa classe
	 */
	public class OuvinteBotoesTelaEdicao implements ActionListener {

		private TelaEdicaoPerfil tela;
		private Persistencia persistencia = new Persistencia();
		private CentralDeInformacoes central;

		public OuvinteBotoesTelaEdicao(TelaEdicaoPerfil t) {
			tela = t;
			central = persistencia.recuperarCentral("central");
		}

		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();

			if (btn == tela.getBtnSeta()) {
				tela.dispose();
				if (TelaPadrao.mototaxistaLogado != null)
					new TelaHomeMototaxista();
				else if (TelaPadrao.passageiroLogado != null)
					new TelaHomePassageiro();
				else
					new TelaHomeADM();
			}

			else if (btn == tela.getBtnSalvar()) {
				String nomeCompleto = tela.getTxtNomeCompleto().getText();
				String email = tela.getTxtEmail().getText();
				String dataNascimento = tela.getTxtData().getText();

				try {
					Usuario usuario = null;
					if (TelaPadrao.mototaxistaLogado != null) {
						usuario = central.atualizarPerfil(TelaPadrao.mototaxistaLogado, email, nomeCompleto,
								dataNascimento, String.valueOf(txtSenha.getPassword()));
						persistencia.salvarCentral(central, "central");
						FabricaJOptionPane.criarMsg("Perfil atualizado com sucesso");
						tela.carregarDados();
						tela.dispose();
						new TelaHomeMototaxista();
					} else if (TelaPadrao.passageiroLogado != null) {
						usuario = central.atualizarPerfil(TelaPadrao.passageiroLogado, email, nomeCompleto,
								dataNascimento, String.valueOf(txtSenha.getPassword()));
						persistencia.salvarCentral(central, "central");
						FabricaJOptionPane.criarMsg("Perfil atualizado com sucesso");
						tela.carregarDados();
						tela.dispose();
						new TelaHomePassageiro();
					} else {
						usuario = central.atualizarPerfil(central.getAdministrador(), email, nomeCompleto,
								dataNascimento, String.valueOf(txtSenha.getPassword()));
						central.setAdministrador(usuario);
						persistencia.salvarCentral(central, "central");
						FabricaJOptionPane.criarMsg("Perfil atualizado com sucesso");
						tela.carregarDados();
						tela.dispose();
						new TelaHomeADM();
					}
					
				} catch (ValidacaoException | EmailEmUsoException erro) {
					FabricaJOptionPane.criarMsgErro(erro.getMessage());
				} catch (DataInvalidaException e1) {
				}
			}
		}
	}

	public JTextField getTxtNomeCompleto() {
		return txtNomeCompleto;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

	public JFormattedTextField getTxtData() {
		return txtData;
	}

	public JButton getBtnSeta() {
		return btnSeta;
	}

	public static void main(String[] args) {
		new TelaEdicaoPerfil();
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

}
