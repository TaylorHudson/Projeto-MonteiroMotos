package utilidades.pdf;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import projeto.modelo.CreditosDeRevindicacao;
import projeto.modelo.Passageiro;
import projeto.repositorio.CentralDeInformacoes;
import projeto.servico.ServicoData;
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
	
	public static void obterRelatorioDeCreditos() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		Document doc = new Document(PageSize.A4, 72, 72, 72, 72);

		try {
			PdfWriter.getInstance(doc, new FileOutputStream("relatorioDeCreditos.pdf"));
			doc.open();

			PdfPTable tabela = new PdfPTable(4);

			Paragraph titulo = new Paragraph("Finanças do Sistema");
			titulo.setAlignment(Element.ALIGN_CENTER);

			Paragraph linhaEmBranco = new Paragraph("                                     ");

			doc.add(titulo);
			doc.add(linhaEmBranco);

			tabela.addCell("Email do Mototaxista");
			tabela.addCell("Quantidade de Creditos");
			tabela.addCell("Data da Compra");
			tabela.addCell("Valor de cada Credito");

			for (CreditosDeRevindicacao c : central.getCreditosDoSistema()) {
				tabela.addCell(c.getMototaxista().getEmail());
				tabela.addCell(String.valueOf(c.getQuantidadeDeCreditos()));
				tabela.addCell(ServicoData.retornarString(c.getDataDaCompra()));
				tabela.addCell(String.valueOf(c.getValorDosCreditos()));
			}

			doc.add(tabela);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			doc.close();
		}
	}

	public static void gerarBoleto(int quantidadeCreditos, double valor) {
		Document doc = new Document(PageSize.A4, 72, 72, 72, 72);
		
		try {
			
			Paragraph linhaEmBranco = new Paragraph("                                     ");
			
			PdfWriter.getInstance(doc, new FileOutputStream("relatorio.pdf"));
			doc.open();
			
			Paragraph nome = new Paragraph("Monteiro Motos");
			nome.setAlignment(Element.ALIGN_LEFT);
			
			Paragraph agencia = new Paragraph("00000.00000 00000.00000 00000.00000 0 0000");
			agencia.setAlignment(Element.ALIGN_RIGHT);
			
			LocalDate dataAtual = LocalDate.now();
			Paragraph textoData = new Paragraph("Data da compra");
			Paragraph data = new Paragraph(dataAtual.getDayOfMonth()+"/"+dataAtual.getMonthValue()+"/"+dataAtual.getYear());
			
			Paragraph textoQuantidade = new Paragraph("Quantidade de créditos");
			Paragraph quantidade = new Paragraph(""+quantidadeCreditos);
			
			Paragraph textoValor = new Paragraph("Valor total");
			Paragraph valorTotal = new Paragraph(""+valor);
			
			doc.add(nome);
			doc.add(agencia);
			doc.add(linhaEmBranco);
			doc.add(linhaEmBranco);
			doc.add(textoData);
			doc.add(data);
			doc.add(textoQuantidade);
			doc.add(quantidade);
			doc.add(textoValor);
			doc.add(valorTotal);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			doc.close();
		}
		
	}

	public static void main(String[] args) {
		GeradorDeRelatorios.gerarBoleto(10, 10);
	}
}