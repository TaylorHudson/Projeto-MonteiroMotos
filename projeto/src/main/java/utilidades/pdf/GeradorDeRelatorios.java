package utilidades.pdf;

import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import projeto.modelo.Passageiro;
import projeto.repositorio.CentralDeInformacoes;
import utilidades.persistencia.Persistencia;

public class GeradorDeRelatorios {

  public static void obterSolicitacoesDeCorrida() {
    Persistencia persistencia = new Persistencia();
    CentralDeInformacoes central = persistencia.recuperarCentral("central");

    Document doc = new Document(PageSize.A4, 72, 72, 72, 72);

    try {
      PdfWriter.getInstance(doc, new FileOutputStream("relatorio.pdf"));
      doc.open();

      PdfPTable tabela = new PdfPTable(2);

      Paragraph titulo = new Paragraph("SOLICITACOES DE CORRIDAS DOS PASSAGEIROS");
      titulo.setAlignment(Element.ALIGN_CENTER);
      
      Paragraph linhaEmBranco = new Paragraph("                                     ");

      doc.add(titulo);
      doc.add(linhaEmBranco);

      ArrayList<Passageiro> passageiros = central.getPassageiros();

      tabela.addCell("Passageiro");
      tabela.addCell("Numero de Corridas");

      for (Passageiro p : passageiros) {
        tabela.addCell(p.getNome());
        int numeroCorridas = central.recuperarNumeroCorridasDeUmPassageiro(p.getEmail());
        tabela.addCell(String.valueOf(numeroCorridas));
      }

      doc.add(tabela);

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      doc.close();
    }
  }

}
