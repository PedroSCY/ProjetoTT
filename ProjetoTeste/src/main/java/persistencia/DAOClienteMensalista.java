package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.NoTypePermission;

import model.entidades.ClienteMensalista;

public class DAOClienteMensalista {

	private HashMap<Long, ClienteMensalista> persistidos;
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("UTF-8"));

	// Neste construtor, foi instanciado o file arquivoColecao e o XStream, tambem é setado as suas restriçoes de permissões.
	// Caso o aquivo XML exista, é usado o método carregarXml(), caso contrario, um novo HashMap<> é criado.
	public DAOClienteMensalista() {
		arquivoColecao = new File("clientes_mensalistas.xml");

		// Restringindo permissões
		xstream.addPermission(NoTypePermission.NONE);
		xstream.allowTypesByRegExp(new String[] { 
				"model.*",
				"persistencia.*",
				"java.util.*",
				"java.lang.Long",
		}
				);

		if (arquivoColecao.exists()) {
			carregarXML();
		} else {
			persistidos = new HashMap<Long, ClienteMensalista>();
		}
	}

	public void criar(ClienteMensalista clienteMensalista) throws Exception {
		if(verificar(clienteMensalista)) {			
			persistidos.put(clienteMensalista.getCpf(), clienteMensalista);
			salvarXML();
			return;
		}
		throw new Exception("Não foi possível salvar o cliente " + clienteMensalista.getNome());
	}

	public ClienteMensalista consultarCliente(long cpf) throws Exception  {
		for(long key: persistidos.keySet()) {
			if(cpf == key) {
				return persistidos.get(key);
			}
		}
		throw new Exception("Cliente não encontrado.");
	}
	
	public ClienteMensalista consultarCliente(String email) throws Exception  {
		for(long key: persistidos.keySet()) {
			if(persistidos.get(key).getEmail().equals(email)) {
				return persistidos.get(key);
			}
		}
		throw new Exception("Cliente não encontrado.");
	}
	
	public void ClienteMensalistaNaoExiste(long cpf) throws Exception {
		for(long key: persistidos.keySet()) {
			if(persistidos.get(key).getCpf() == cpf) {
				throw new Exception("Cliente Mensalista existente");
			}
		}
		
	}

	public Set<ClienteMensalista> consultarTodos() {
		Set<ClienteMensalista> clientes = new LinkedHashSet<ClienteMensalista>();

		for(long key : persistidos.keySet()) {
			ClienteMensalista cliente = persistidos.get(key);
			clientes.add(cliente);
		}

		return clientes;
	}

	public boolean atualizar(long cpf, ClienteMensalista clienteMensalista) {
		for(long key : persistidos.keySet()){
			if(cpf == key) {
				persistidos.replace(key, clienteMensalista);
				salvarXML();  // Toda vez que esta função for utilizada, o aquivo xml é atualizado.
				return true;
			}
		}

		System.out.println("CPF " + cpf + " inexistente");
		return false;
	}

	public void remover(long cpf) throws Exception {
		for(long key : persistidos.keySet()){
			if(cpf == key) {
				persistidos.remove(key);
				salvarXML(); // Toda vez que esta função for utilizada, o aquivo xml é atualizado.
				return;
			}
		}
		throw new Exception("CPF " + cpf + " inexistente");
	}

	// TODO [UML] add method
	// O método verificar() verifica se existe algum ClienteMensalista com o mesmo CPF já registrado.
	public boolean verificar(ClienteMensalista clienteMensalista) throws Exception {
		for(long key: persistidos.keySet()) {
			if(clienteMensalista.getCpf() == key) {
				return false;
			}
		}
		return true;
	}

	// TODO [UML] add method
	// O método salvarxml() cria um xml que cotem o hashmap persistidos.
	// Logo após, cria um arquivo contendo este xml e o armazena no endereco de arquivoColecao.
	private void salvarXML() {

		String xmlPersistidos = xstream.toXML(persistidos);
		xstream.alias("map", java.util.Map.class);

		try {

			arquivoColecao.createNewFile();
			PrintWriter gravador = new PrintWriter (arquivoColecao);
			gravador.print(xmlPersistidos);
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
			
			persistidos = (HashMap<Long, ClienteMensalista>) xstream.fromXML(fis); // Os dados recuperados são passados ao hashmap persistidos.

			return; // Caso nenhuma alteração seja feita, o metodo salvarxml() não será acionado.

		} catch (FileNotFoundException e) {
			System.out.println((e.getMessage ()));
		}
	}
	
}
