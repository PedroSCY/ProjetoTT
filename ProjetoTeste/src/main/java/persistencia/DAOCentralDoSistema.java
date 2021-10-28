package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.NoTypePermission;

import model.entidades.ClienteMensalista;
import util.CentralDoSistema;

public class DAOCentralDoSistema {
	
	
	private CentralDoSistema arquivoConfiguracao;
	
	
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("UTF-8"));

	// Neste construtor, foi instanciado o file arquivoColecao e o XStream, tambem é setado as suas restriçoes de permissões.
	// Caso o aquivo XML exista, é usado o método carregarXml(), caso contrario, um novo HashMap<> é criado.
	public DAOCentralDoSistema() {
		arquivoColecao = new File("Arquivo_de_configuracao.xml");

//		// Restringindo permissões
//		xstream.addPermission(NoTypePermission.NONE);
//		xstream.allowTypesByRegExp(new String[] { 
//				"model.*",
//				"persistencia.*",
//				"java.util.*",
//				"java.lang.Long",
//		}
//				);

		if (arquivoColecao.exists()) {
			carregarXML();
		} else {
			arquivoConfiguracao = null;
		}
	}
	
	public boolean temConfiguracaoAntiga() {
		boolean var = arquivoColecao != null;
		return var;
	}

	public void salvarCentral(CentralDoSistema central) {
		this.arquivoConfiguracao = central;
		salvarXML();
	}

	public CentralDoSistema recuperarCentral() {
		carregarXML();
		return arquivoConfiguracao;
	}
	
	
	private void salvarXML() {

		String xmlArquivoConfiguracao = xstream.toXML(arquivoConfiguracao);
		xstream.alias("map", java.util.Map.class);

		try {

			arquivoColecao.createNewFile();
			PrintWriter gravador = new PrintWriter (arquivoColecao);
			gravador.print(xmlArquivoConfiguracao);
			gravador.close();

		} catch (IOException e) {
			System.out.println((e.getMessage ()));
		}
	}

	// TODO [UML] add method
	// O método carregarXml() recupera os dados armazenados no arquivo xml no endereço descrito por arquivoColecao.
	@SuppressWarnings("unchecked")
	private void carregarXML() {

		try {

			FileInputStream fis = new FileInputStream(arquivoColecao);
			arquivoConfiguracao = (CentralDoSistema) xstream.fromXML(fis); // Os dados recuperados são passados ao hashmap persistidos.

			return; // Caso nenhuma alteração seja feita, o metodo salvarxml() não será acionado.

		} catch (FileNotFoundException e) {
			System.out.println((e.getMessage ()));
		}
	}

//	Class<?>[] classes = new Class[] {CentralDoSistema.class , DAOCentralDoSistema.class};
//	XStream xstream = new XStream();
//	xstream.setupDefaultSecurity(xstream);
	
}
