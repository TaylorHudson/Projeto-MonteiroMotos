package projeto.telas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utilidades.Imagens;

public class TelaLogin extends JFrame {

  private JTextField txtLogin;
  private JPasswordField txtSenha;
  private JLabel background;
  private JButton btnResetSenha;
  private JButton btnEntrar;

  public TelaLogin() {
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

    JLabel lblLogin = new JLabel("Login");
    lblLogin.setBounds(20, 60, 460, 40);
    lblLogin.setForeground(new Color(247, 247, 247));
    lblLogin.setFont(new Font("Arial", 1, 25));

    JLabel lblSenha = new JLabel("Senha");
    lblSenha.setBounds(20, 160, 460, 40);
    lblSenha.setForeground(new Color(247, 247, 247));
    lblSenha.setFont(new Font("Arial", 1, 25));

    txtLogin = new JTextField();
    txtLogin.setBounds(20, 95, 460, 40);
    txtLogin.setBackground(new Color(28, 28, 30));
    txtLogin.setForeground(new Color(179, 177, 177));
    txtLogin.setBorder(null);
    txtLogin.setFont(new Font("Arial", 1, 16));

    txtSenha = new JPasswordField();
    txtSenha.setBounds(20, 195, 460, 40);
    txtSenha.setBackground(new Color(28, 28, 30));
    txtSenha.setForeground(new Color(179, 177, 177));
    txtSenha.setBorder(null);
    txtSenha.setFont(new Font("Arial", 1, 20));

    btnResetSenha = new JButton("Esqueceu a senha?");
    btnResetSenha.setBounds(10, 360, 120, 30);
    btnResetSenha.setFont(new Font("Arial", 1, 12));
    btnResetSenha.setBackground(new Color(28, 28, 20));
    btnResetSenha.setForeground(new Color(179, 177, 177));
    btnResetSenha.setFocusable(false);
    btnResetSenha.setBorder(null);

    btnEntrar = new JButton("Entrar");
    btnEntrar.setBounds(180, 270, 120, 45);
    btnEntrar.setFont(new Font("Arial", 1, 30));
    btnEntrar.setBackground(new Color(28, 28, 20));
    btnEntrar.setForeground(new Color(179, 177, 177));
    btnEntrar.setFocusable(false);
    btnEntrar.setBorder(null);
    btnEntrar.setOpaque(true);

    menu.add(txtLogin);
    menu.add(lblLogin);
    menu.add(txtSenha);
    menu.add(lblSenha);
    menu.add(btnEntrar);
    menu.add(btnResetSenha);

    background.add(menu);
  }

  public JTextField getTxtLogin() {
    return txtLogin;
  }

  public JPasswordField getTxtSenha() {
    return txtSenha;
  }

  public JButton getBtnResetSenha() {
    return btnResetSenha;
  }

  public JButton getBtnEntrar() {
    return btnEntrar;
  }

  public static void main(String[] args) {
	new TelaLogin();
}
}
