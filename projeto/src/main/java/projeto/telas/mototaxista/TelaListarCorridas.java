package projeto.telas.mototaxista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto.telas.mototaxista.ouvintes.OuvinteBotoesTelaListarCorridas;
import utilidades.fabricas.FabricaJButton;
import utilidades.fabricas.FabricaJLabel;
import utilidades.imagens.Imagens;

import java.awt.Font;
import java.awt.Color;

public class TelaListarCorridas extends JFrame {

  private JTable tabelaCorridas;
  private JLabel background;
  private JButton btnOrdenar;
  private JButton btnReivindicarCorrida;
  private JLabel lblSeta;
  
  public TelaListarCorridas() {
    configurarTela();
    configImagemFundo();
    configTabela();

    setVisible(true);
  }

  private void configImagemFundo() {
		background = FabricaJLabel.criarJLabel(0, 0, 900, 800, Imagens.BACKGROUNDHOME);
		add(background);
	}

  private void configTabela() {
    OuvinteBotoesTelaListarCorridas ouvinte = new OuvinteBotoesTelaListarCorridas(this);

    DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "NOME", "STATUS", "DATA", "HORA" });
		tabelaCorridas = new JTable(modelo);
		tabelaCorridas.setFont(new Font("Arial", 1, 15));

    lblSeta = FabricaJLabel.criarJLabel(825, 2, 50, 50, Imagens.SETA);
		lblSeta.addMouseListener(ouvinte);

		JScrollPane scrol = new JScrollPane(tabelaCorridas);
		scrol.getViewport().setBackground(new Color(124, 68, 2));
		scrol.setBounds(2, 240, 885, 400);

    btnOrdenar = FabricaJButton.criarJButton("Ordenar", 660, 180, 180, 50, new Color(28, 28, 20),
    Color.WHITE, 28);
    btnOrdenar.addMouseListener(ouvinte);
   
    btnReivindicarCorrida = FabricaJButton.criarJButton("Reivindicar Corrida", 50, 670, 280, 50, new Color(28, 28, 20),
    Color.WHITE, 28);
    btnReivindicarCorrida.addMouseListener(ouvinte);

    background.add(scrol);
    background.add(btnOrdenar);
    background.add(btnReivindicarCorrida);
    background.add(lblSeta);
  }

  private void configurarTela() {
		setSize(900, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Tela Listar Corridas");
	}

  public static void main(String[] args) {
    new TelaListarCorridas();
  }

  public JTable getTabelaCorridas() {
    return tabelaCorridas;
  }

  public JButton getBtnOrdenar() {
    return btnOrdenar;
  }

  public JButton getBtnReivindicarCorrida() {
    return btnReivindicarCorrida;
  }

  public JLabel getLblSeta() {
    return lblSeta;
  }
  
}
