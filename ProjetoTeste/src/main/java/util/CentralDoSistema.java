package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import persistencia.DAOCentralDoSistema;

//import persistencia.DAOCentralDoSistema;

public class CentralDoSistema {

	private float valorBase;
	private float valorPorHoraExtra;
	private String CNPJ;
	private String agenciaBancaria;
	private String numeroAgencia;
	private String numeroContaEstacionamento;
	private String variacao;
	private static CentralDoSistema centralDoSistema;
	private int quantidadeVagasDisponiveis;

	//	private static CentralDoSistema arquivoConfiguracao;


	private static File arquivoCentral = new File("Arquivo_de_configuracao.xml");;
	private static XStream xstream = new XStream(new DomDriver("UTF-8"));

	private CentralDoSistema() {
		//		
		//		if (arquivoColecao.exists()) {
		//			carregarXML();
		//		} else {
		//			arquivoConfiguracao = null;
		//		}
	}

	//	public void salvarCentral() {
	//		this.arquivoConfiguracao = central;
	//		salvarXML();
	//	}

	private static CentralDoSistema recuperarCentral() {
		
		try {
			
			if(arquivoCentral.exists()) {
				
				FileInputStream fis = new FileInputStream(arquivoCentral);
				return (CentralDoSistema) xstream.fromXML(fis);
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new CentralDoSistema();
		
		
		//		try {
		//
		//			FileInputStream fis = new FileInputStream(arquivoColecao);
		//			return (CentralDoSistema) xstream.fromXML(fis); // Os dados recuperados são passados ao hashmap persistidos.
		//
		////			return; // Caso nenhuma alteração seja feita, o metodo salvarxml() não será acionado.
		//
		//		} catch (FileNotFoundException e) {
		//			e.printStackTrace();
		//		}

	}

//	private static void carregarXML() {

		//		try {
		//
		//			FileInputStream fis = new FileInputStream(arquivoColecao);
		//			arquivoConfiguracao = (CentralDoSistema) xstream.fromXML(fis); // Os dados recuperados são passados ao hashmap persistidos.
		//
		//			return; // Caso nenhuma alteração seja feita, o metodo salvarxml() não será acionado.
		//
		//		} catch (FileNotFoundException e) {
		//			e.printStackTrace();
		//		}
//	}

	public void salvarCentral() {

		String xmlArquivoConfiguracao = xstream.toXML(centralDoSistema);
//		xstream.alias("map", java.util.Map.class);

		try {

			arquivoCentral.createNewFile();
			PrintWriter gravador = new PrintWriter (arquivoCentral);
			gravador.print(xmlArquivoConfiguracao);
			gravador.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public static CentralDoSistema getInstance() {
		//		DAOCentralDoSistema daoCS = new DAOCentralDoSistema();

		if(centralDoSistema == null) {

			//			centralDoSistema =  new CentralDoSistema();
			//			centralDoSistema = recuperarCentral();

			//			if(daoCS.temConfiguracaoAntiga()) {
			centralDoSistema = recuperarCentral();
			//			}else {
			//				centralDoSistema = new CentralDoSistema();
			//			}

		}
		return centralDoSistema;
	}

	public float getValorBase() {
		return valorBase;
	}

	public void setValorBase(float valorBase) {
		this.valorBase = valorBase;
	}

	public float getValorPorHoraExtra() {
		return valorPorHoraExtra;
	}

	public void setValorPorHoraExtra(float valorPorHoraExtra) {
		this.valorPorHoraExtra = valorPorHoraExtra;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getAgenciaBancaria() {
		return agenciaBancaria;
	}

	public void setAgenciaBancaria(String agenciaBancaria) {
		this.agenciaBancaria = agenciaBancaria;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNumeroContaEstacionamento() {
		return numeroContaEstacionamento;
	}

	public void setNumeroContaEstacionamento(String numeroContaEstacionamento) {
		this.numeroContaEstacionamento = numeroContaEstacionamento;
	}

	public String getVariacao() {
		return variacao;
	}

	public void setVariacao(String variacao) {
		this.variacao = variacao;
	}

	public int getQuantidadeVagasDisponiveis() {
		return quantidadeVagasDisponiveis;
	}

	public void setQuantidadeVagasDisponiveis(int quantidadeVagasDisponiveis) {
		this.quantidadeVagasDisponiveis = quantidadeVagasDisponiveis;
	}
	
}
