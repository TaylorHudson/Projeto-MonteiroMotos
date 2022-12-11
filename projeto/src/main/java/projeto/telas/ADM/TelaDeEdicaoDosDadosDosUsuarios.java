package projeto.telas.ADM;

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
import projeto.excecoes.usuario.UsuarioNaoExisteException;
import projeto.excecoes.usuario.ValidacaoException;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;
import projeto.servico.ServicoData;
import projeto.servico.ServicoUsuario;
import utilidades.email.Mensageiro;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJFormatted;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;
import utilidades.persistencia.Persistencia;
import utilidades.validacao.Validador;

public class TelaDeEdicaoDosDadosDosUsuarios extends TelaPadrao {
	private ImagemDeFundo imagem;
	private JTextField txtNomeCompleto;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JFormattedTextField txtData;
	private JButton btnSeta;
	private JButton btnEnviarEmail;
	private JButton btnSalvar;
	private Usuario usuario;

	public TelaDeEdicaoDosDadosDosUsuarios(Usuario u) {
		super("Dados do Usuario Selecionado");
		usuario = u;
		configUsuario(u);
		setVisible(true);
	}

	private void configUsuario(Usuario u) {
		txtNomeCompleto.setText(u.getNome());
		txtEmail.setText(u.getEmail());
		try {
			txtData.setText(ServicoData.retornarString(u.getDataNascimento()));
		} catch (DataInvalidaException e) {
		}
		txtSenha.setText(u.getSenha());
	}

	public void configurarComponentes() {
		configImagemDeFundo();
		configMenu();
	}

	private void configImagemDeFundo() {
		imagem = super.configImagemDeFundo("background_2.jpg");
		add(imagem);
	}

	private void configMenu() {
		OuvinteTelaDeEdicaoDosDadosDosUsuarios ouvinte = new OuvinteTelaDeEdicaoDosDadosDosUsuarios(this);
		OuvinteBotaoFundoPreto ouvinteBotao = new OuvinteBotaoFundoPreto();

		btnSeta = FabricaJButton.criarJButton("", Imagens.SETA, 10, 10, 50, 50);
		btnEnviarEmail = FabricaJButton.criarJButton("Enviar E-mail para o Usuario", 20, 550, 300, 30, Color.white,
				Color.black, 18);
		btnSeta.addActionListener(ouvinte);
		btnEnviarEmail.addActionListener(ouvinte);

		btnSeta.addMouseListener(ouvinteBotao);
		btnEnviarEmail.addMouseListener(ouvinteBotao);

		JLabel menu = FabricaJLabel.criarJLabel(80, 80, 700, 620, Color.BLACK, 3);
		menu.setBackground(Color.BLACK);

		JLabel lblNomeCompleto = FabricaJLabel.criarJLabel("Nome Completo", 30, 60, 460, 40, Color.white, 25);
		txtNomeCompleto = FabricaJText.criarJTextField(30, 100, 640, 40, Color.white, Color.BLACK, 16);

		JLabel lblEmail = FabricaJLabel.criarJLabel("Email", 30, 140, 460, 40, Color.white, 25);
		txtEmail = FabricaJText.criarJTextField(30, 180, 640, 40, Color.white, Color.BLACK, 16);
		txtEmail.setEditable(false);

		JLabel lblSenha = FabricaJLabel.criarJLabel("Senha", 30, 220, 460, 40, Color.white, 25);
		txtSenha = FabricaJText.criarJPasswordField(30, 260, 640, 40, Color.white, Color.BLACK, 16);

		JLabel lblDataNascimento = FabricaJLabel.criarJLabel("Data de Nascimento", 30, 300, 460, 40, Color.white, 25);
		try {
			txtData = FabricaJFormatted.criarJFormatted(30, 340, 640, 40, new MaskFormatter("##/##/####"));
			txtData.setEditable(false);
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
		menu.add(btnEnviarEmail);
		imagem.add(menu);
		imagem.add(btnSeta);
		add(imagem);
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
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

	public JButton getBtnEnviarEmail() {
		return btnEnviarEmail;
	}

	public class OuvinteTelaDeEdicaoDosDadosDosUsuarios implements ActionListener {
		private TelaDeEdicaoDosDadosDosUsuarios tela;
		private Persistencia p = new Persistencia();
		private CentralDeInformacoes central = p.recuperarCentral("central");

		public OuvinteTelaDeEdicaoDosDadosDosUsuarios(TelaDeEdicaoDosDadosDosUsuarios tela) {
			this.tela = tela;
		}

		public void enviarEmailParaUsuario() {
			try {
				String nome = tela.getTxtNomeCompleto().getText();
				String senha = String.valueOf(tela.getTxtSenha().getPassword());

				Validador.validarNome(nome);
				Validador.validarSenha(senha);

				if (usuario instanceof Passageiro) {
					Passageiro passageiro = central.recuperarPassageiroPeloEmail(usuario.getEmail());
					passageiro.setNome(nome);
					passageiro.setSenha(senha);
					Mensageiro.enviarDadosAtualizados(passageiro);
				}else if(usuario instanceof Mototaxista) {
					Mototaxista mototaxista = central.recuperarMototaxistaPeloEmail(usuario.getEmail());
					mototaxista.setNome(nome);
					mototaxista.setSenha(senha);
					Mensageiro.enviarDadosAtualizados(mototaxista);
				}

				p.salvarCentral(central, "central");
			} catch (UsuarioNaoExisteException | ValidacaoException e) {
				FabricaJOptionPane.criarMsgErro(e.getMessage());
			}
		}

		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			ServicoUsuario usu = new ServicoUsuario(central);

			if (btn == tela.getBtnEnviarEmail()) {
				enviarEmailParaUsuario();
			} else if (btn == tela.getBtnSeta()) {
				tela.dispose();
				new TelaDadosDosUsuarios();
			} else if (btn == tela.getBtnSalvar()) {
				try {
					Usuario u = usu.atualizarPerfil(usuario, txtEmail.getText(), txtNomeCompleto.getText(),
							txtData.getText(), String.valueOf(tela.getTxtSenha().getPassword()));
					if (u.getEmail() != usuario.getEmail() && u.getNome() != usuario.getNome()) {
						p.salvarCentral(central, "central");
						tela.repaint();
						FabricaJOptionPane.criarMsg("Perfil atualizado");
						tela.dispose();
						new TelaDadosDosUsuarios();
					}
				} catch (ValidacaoException | EmailEmUsoException e1) {
					FabricaJOptionPane.criarMsgErro(e1.getMessage());
				} catch (DataInvalidaException e1) {
				}
			}
		}
	}

}
