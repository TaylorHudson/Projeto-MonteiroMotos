package projeto.telas.mototaxista;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import projeto.OuvinteBotaoPadrao;
import projeto.telas.mototaxista.ouvintes.OuvinteSpinner;
import projeto.telas.mototaxista.ouvintes.OuvinteTelaComprarCreditos;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.fabricas.FabricaJText;
import utilidades.imagens.Imagens;

public class TelaComprarCreditos extends JFrame {

  private JTextField txtPrecoTotal;
  private JSpinner spinner;

  public TelaComprarCreditos() {
    configurarTela();
    configMenu();
    setVisible(true);
  }

  private void configurarTela() {
    setSize(900, 800);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(null);
    setResizable(false);
    setLocationRelativeTo(null);
    setTitle("Tela Comprar Créditos");
  }

  private void configMenu() {
    OuvinteTelaComprarCreditos ouvinte = new OuvinteTelaComprarCreditos(this);

    JLabel background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUND_2);

    JLabel menu = FabricaJLabel.criarJLabel(150, 150, 550, 450, Color.BLACK, 0);
    menu.setBackground(Color.BLACK);

    JLabel lblQuantidade = FabricaJLabel.criarJLabel("Quantidade de Créditos", 10,80,350, 26, Color.BLACK, Color.WHITE, 26);
    
    spinner = new JSpinner();
    spinner.setBounds(10, 120, 100, 35);
    spinner.setFont(new Font("Arial", 1, 20));
    spinner.addChangeListener(new OuvinteSpinner(this));

    JLabel lblPrecoTotal = FabricaJLabel.criarJLabel("Preço Total", 10,180,350, 30, Color.BLACK, Color.WHITE, 26);

    txtPrecoTotal = FabricaJText.criarJTextField(10,220,300, 30, Color.WHITE, Color.BLACK, 24);
    txtPrecoTotal.setEditable(false);

    JButton btnGerarBoleto = FabricaJButton.criarJButton("Gerar Boleto", 180,350,180, 40, Color.WHITE, Color.BLACK, 24);
    btnGerarBoleto.addMouseListener(new OuvinteBotaoPadrao());
    btnGerarBoleto.addActionListener(ouvinte);

    menu.add(lblQuantidade);
    menu.add(spinner);
    menu.add(lblPrecoTotal);
    menu.add(txtPrecoTotal);
    menu.add(btnGerarBoleto);

    background.add(menu);
    add(background);
  }
  
  public JTextField getTxtPrecoTotal() {
    return txtPrecoTotal;
  }

  public JSpinner getSpinner() {
    return spinner;
  }

  public static void main(String[] args) {
    new TelaComprarCreditos();
  }
}
