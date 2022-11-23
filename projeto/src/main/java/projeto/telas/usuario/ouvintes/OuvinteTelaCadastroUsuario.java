package projeto.telas.usuario.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import projeto.excecoes.usuario.ValidacaoException;
import projeto.modelo.Mototaxista;
import projeto.repositorio.CentralDeInformacoes;
import projeto.servico.ServicoData;
import projeto.telas.usuario.TelaCadastroUsuario;
import projeto.telas.usuario.TelaLogin;
import utilidades.fabricas.FabricaJOptionPane;
import utilidades.persistencia.Persistencia;
import utilidades.validacao.Validador;

public class OuvinteTelaCadastroUsuario implements ActionListener {

	private TelaCadastroUsuario tela;
	private Persistencia persistencia = new Persistencia();
	private CentralDeInformacoes central;

	public OuvinteTelaCadastroUsuario(TelaCadastroUsuario tela) {
		this.tela = tela;
		this.central = persistencia.recuperarCentral("central");
	}

	public void actionPerformed(ActionEvent e) {
		String nome = tela.getTxtNome().getText().trim();
		String email = tela.getTxtEmail().getText().trim();
		String senha = String.valueOf(tela.getTxtSenha().getPassword()).trim();
		String dataDeNascimento = tela.getTxtData().getText();
		String tipo = (String) tela.getBox().getSelectedItem();

		try {
			boolean teste = Validador.validarCadastro(nome, email, senha, ServicoData.retornarData(dataDeNascimento));
			LocalDate data = ServicoData.retornarData(dataDeNascimento);
			if (teste == true && tipo.equals("Mototaxista")) {
				central.adicionarMototaxista(new Mototaxista(nome, email, senha, data, true));
				persistencia.salvarCentral(central, "central");
				tela.dispose();
				new TelaLogin();
			}
		} catch (ValidacaoException erro) {
			FabricaJOptionPane.criarMsgAtencao(erro.getMessage());
		}
	}

}
