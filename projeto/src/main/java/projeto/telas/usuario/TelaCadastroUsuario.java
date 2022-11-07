package projeto.telas.usuario;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utilidades.Imagens;

public class TelaCadastroUsuario extends JFrame {

  private JTextField txtNome;
  private JTextField txtEmail;
  private JTextField txtLogin;
  private JPasswordField txtSenha;
  private JLabel background;
  private JButton btnCadastrar;

  public TelaCadastroUsuario() {
    configurarTela();
    configImagemFundo();
    configFormLogin();
    setVisible(true);
  }

  private void configurarTela() {
    setSize(900, 800);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(null);
    setResizable(false);
    setLocationRelativeTo(null);
    setTitle("Login");
  }

  private void configImagemFundo() {
    background = new JLabel();
    background.setBounds(0, 0, 900, 800);
    background.setLayout(null);
    background.setIcon(Imagens.BACKGROUND);
    add(background);
  }

  private void configFormLogin() {

    JLabel menu = new JLabel();
    menu.setBounds(180, 200, 500, 400);
    menu.setLayout(null);
    menu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

    JLabel lblNome = new JLabel("Nome");
    lblNome.setBounds(20, 5, 460, 40);
    lblNome.setForeground(new Color(247, 247, 247));
    lblNome.setFont(new Font("Arial", 1, 25));

    JLabel lblEmail = new JLabel("Email");
    lblEmail.setBounds(20, 80, 460, 40);
    lblEmail.setForeground(new Color(247, 247, 247));
    lblEmail.setFont(new Font("Arial", 1, 25));

    JLabel lblLogin = new JLabel("Login");
    lblLogin.setBounds(20, 155, 460, 40);
    lblLogin.setForeground(new Color(247, 247, 247));
    lblLogin.setFont(new Font("Arial", 1, 25));

    JLabel lblSenha = new JLabel("Senha");
    lblSenha.setBounds(20, 230, 460, 40);
    lblSenha.setForeground(new Color(247, 247, 247));
    lblSenha.setFont(new Font("Arial", 1, 25));

    txtNome = new JTextField();
    txtNome.setBounds(20, 40, 460, 40);
    txtNome.setBackground(new Color(28, 28, 30));
    txtNome.setForeground(new Color(179, 177, 177));
    txtNome.setBorder(null);
    txtNome.setFont(new Font("Arial", 1, 16));

    txtEmail = new JTextField();
    txtEmail.setBounds(20, 115, 460, 40);
    txtEmail.setBackground(new Color(28, 28, 30));
    txtEmail.setForeground(new Color(179, 177, 177));
    txtEmail.setBorder(null);
    txtEmail.setFont(new Font("Arial", 1, 16));

    txtLogin = new JTextField();
    txtLogin.setBounds(20, 190, 460, 40);
    txtLogin.setBackground(new Color(28, 28, 30));
    txtLogin.setForeground(new Color(179, 177, 177));
    txtLogin.setBorder(null);
    txtLogin.setFont(new Font("Arial", 1, 16));

    txtSenha = new JPasswordField();
    txtSenha.setBounds(20, 265, 460, 40);
    txtSenha.setBackground(new Color(28, 28, 30));
    txtSenha.setForeground(new Color(179, 177, 177));
    txtSenha.setBorder(null);
    txtSenha.setFont(new Font("Arial", 1, 20));

    btnCadastrar = new JButton("Cadastrar");
    btnCadastrar.setBounds(170, 330, 150, 45);
    btnCadastrar.setFont(new Font("Arial", 1, 30));
    btnCadastrar.setBackground(new Color(28, 28, 20));
    btnCadastrar.setForeground(new Color(179, 177, 177));
    btnCadastrar.setFocusable(false);
    btnCadastrar.setBorder(null);
    btnCadastrar.setOpaque(true);

    menu.add(lblNome);
    menu.add(txtNome);
    menu.add(lblEmail);
    menu.add(txtEmail);
    menu.add(lblLogin);
    menu.add(txtLogin);
    menu.add(lblSenha);
    menu.add(txtSenha);
    menu.add(btnCadastrar);

    background.add(menu);
  }

  public JTextField getTxtNome() {
    return txtNome;
  }

  public JTextField getTxtEmail() {
    return txtEmail;
  }

  public JTextField getTxtLogin() {
    return txtLogin;
  }

  public JPasswordField getTxtSenha() {
    return txtSenha;
  }

  public JButton getBtnCadastrar() {
    return btnCadastrar;
  }

}
