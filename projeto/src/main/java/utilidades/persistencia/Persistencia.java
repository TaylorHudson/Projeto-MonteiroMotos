package utilidades.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import projeto.modelo.Avaliacao;
import projeto.modelo.Corrida;
import projeto.modelo.Mototaxista;
import projeto.modelo.Passageiro;
import projeto.modelo.Usuario;
import projeto.repositorio.CentralDeInformacoes;

/*
 * @author Taylor Hudson
 * 
 * Classe respons�vel por fazer a persist�ncia dos dados.
 *  
*/

public class Persistencia {

	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));

	public Persistencia() {
		configIniciais();
	}
	
	/*
	 * M�todo respons�vel por fazer as configura��es iniciais do arquivo chamado 
	 * central que ainda ser� criado.
	*/
	private void configIniciais() {
		xstream.alias("corrida", Corrida.class);
		xstream.alias("passageiro", Passageiro.class);
		xstream.alias("persistencia", Persistencia.class);
		xstream.alias("usuario", Usuario.class);
		xstream.alias("mototaxista", Mototaxista.class);
		xstream.alias("avaliacao", Avaliacao.class);
		xstream.alias("centralInformacoes", CentralDeInformacoes.class);

		xstream.addPermission(AnyTypePermission.ANY);
	}
	
	/*
	 * M�todo respons�vel por fazer a mudan�a de classes java para arquivo xml, e tamb�m
	 * por criar o arquivo onde ficar�o salvos os dados do sistema. 
	*/
	public void salvarCentral(CentralDeInformacoes central, String nomeDoArquivo) {
		String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n";

		File arquivo = new File(nomeDoArquivo + ".xml");

		try {
			arquivo.createNewFile();

			PrintWriter escreva = new PrintWriter(arquivo);
			xml += xstream.toXML(central);
			escreva.print(xml);
			escreva.flush();
			escreva.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * M�todo respons�vel por recuperar os dados j� salvos na central, e pass�-los de formato 
	 * xml para classes do java.
	*/
	public CentralDeInformacoes recuperarCentral(String nomeDoArquivo) {
		File arquivo = new File(nomeDoArquivo + ".xml");
		try {
			if (arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				return (CentralDeInformacoes) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new CentralDeInformacoes();
	}

}
