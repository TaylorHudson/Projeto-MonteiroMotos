package projeto.telas.usuario.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JCheckBox;

import projeto.excecoes.usuario.DataInvalidaException;
import projeto.excecoes.usuario.SexoInvalidoException;
import projeto.excecoes.usuario.ValidacaoException;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.modelo.enuns.Sexo;
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
		boolean selecionouFeminino = tela.getCheckBoxFeminino().isSelected();
		Sexo sexo = (selecionouFeminino ? Sexo.FEMININO : Sexo.MASCULINO);
		JCheckBox cbFeminino = tela.getCheckBoxFeminino();
		JCheckBox cbMasculino = tela.getCheckBoxMasculino();
		
		try {
			boolean valido = Validador.validarCadastro(nome, email, senha, ServicoData.retornarData(dataDeNascimento), cbFeminino, cbMasculino);
			LocalDate data = ServicoData.retornarData(dataDeNascimento);
			if (valido) {
				if (tipo.equals("Mototaxista")) {
					central.adicionarMototaxista(new Mototaxista(nome, sexo, email, senha, data, true));
					persistencia.salvarCentral(central, "central");
				} else {
					central.adicionarPassageiro(new Passageiro(nome, sexo, data, email, senha, true));
					persistencia.salvarCentral(central, "central");
				}
				tela.dispose();
				new TelaLogin();
			}
		} catch (ValidacaoException | SexoInvalidoException | DataInvalidaException erro) {
			FabricaJOptionPane.criarMsgAtencao(erro.getMessage());
		}
	}

}
