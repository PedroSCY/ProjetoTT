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

import model.entidades.RegistroPagamento;

public class DAORegistroPagamento {
	
	private HashMap<Long, RegistroPagamento> persistidos;
	private File arquivoColecao;
	private XStream xstream = new XStream(new DomDriver("UTF-8"));

	// Neste construtor, foi instanciado o file arquivoColecao e o XStream, tambem é setado as suas restriçoes de permissões.
	// Caso o aquivo XML exista, é usado o método carregarXml(), caso contrario, um novo HashMap<> é criado.
	public DAORegistroPagamento() {
		arquivoColecao = new File("registros_pagamentos.xml");

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
			persistidos = new HashMap<Long, RegistroPagamento>();
		}
	}

	public void criar(RegistroPagamento registroPagamento) throws Exception {
		if(verificar(registroPagamento)) {			
			persistidos.put(registroPagamento.getId(), registroPagamento);
			salvarXML();
			return;
		}
		throw new Exception("Não foi possível salvar o registro.");
	}

	public RegistroPagamento consultarRegistro(long id) throws Exception {
		for(long key: persistidos.keySet()) {
			if(id == key) {
				return persistidos.get(key);
			}
		}
		throw new Exception("Registro não encontrado");
	}

	public Set<RegistroPagamento> consultarTodos() {
		Set<RegistroPagamento> registros = new LinkedHashSet<RegistroPagamento>();

		for(long key : persistidos.keySet()) {
			RegistroPagamento registro = persistidos.get(key);
			registros.add(registro);
		}
		
		return registros;
	}

	public boolean atualizar(long id, RegistroPagamento registroPagamento) {
		for(long key : persistidos.keySet()){
			if(key == id) {
				persistidos.replace(key, registroPagamento);
				salvarXML();  // Toda vez que esta função for utilizada, o aquivo xml é atualizado.
				return true;
			}
		}

		System.out.println("Registro " + id + " inexistente");
		return false;
	}

	public void remover(long id) throws Exception {
		for(long key : persistidos.keySet()){
			if(key == id) {
				persistidos.remove(key);
				salvarXML(); // Toda vez que esta função for utilizada, o aquivo xml é atualizado.
				return;
			}
		}
		throw new Exception("Registro " + id + " inexistente");
	}

	// TODO [UML] add method
		// O método verificar() verifica se existe algum funcionario com a mesma matricula já registrado.
		public boolean verificar(RegistroPagamento registroPagamento) throws Exception {
			for(long key: persistidos.keySet()) {
				if(registroPagamento.getId() == key) {
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
				e.printStackTrace();
			}
		}

		// TODO [UML] add method
		// O método carregarXml() recupera os dados armazenados no arquivo xml no endereço descrito por arquivoColecao.
		@SuppressWarnings("unchecked")
		private void carregarXML() {

			try {

				FileInputStream fis = new FileInputStream(arquivoColecao);
				persistidos = (HashMap<Long, RegistroPagamento>) xstream.fromXML(fis); // Os dados recuperados são passados ao hashmap persistidos.

				return; // Caso nenhuma alteração seja feita, o metodo salvarxml() não será acionado.

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
}
