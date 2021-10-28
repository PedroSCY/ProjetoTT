package view.projetos.relatorios;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import util.FactorySwingComponents;

/**
 * 
 * @author NPG
 * Classe desenvolvida para realizar testes nos montadores concretos da implementacao do padrao builder.
 */
@SuppressWarnings("unused")
public class TesteBuilder {
//	
//	private static DiretorMontagem diretorMontagem;
//	private static final InterfacePartesMontagem montadorFormatoHTML = new MontadorRelatorioHTML();
//	private static final InterfacePartesMontagem montadorFormatoSwing = new MontadorRelatorioSwing();
//	
	public static void main(String[] args) {
		try {			
//			gerarRelatorioHTMLEdital();
//			gerarRelatorioSwingEdital();

//			gerarRelatorioHTMLGrupo();
//			gerarRelatorioSwingGrupo();

//			gerarRelatorioHTMLProjeto();
//			gerarRelatorioSwingProjeto();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

//	private static void gerarRelatorioHTMLEdital() throws Exception {
//		DAOXMLEdital daoxmlEdital = new DAOXMLEdital();
//		Edital edital = daoxmlEdital.consultarPorID(111101111);
//		
//		diretorMontagem = new DiretorMontagem(montadorFormatoHTML);
//		diretorMontagem.gerarRelatorioEdital(edital);
//		
//		try {
//			File relatorio = (File) diretorMontagem.getProduto();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void gerarRelatorioSwingEdital() throws Exception {
//		DAOXMLEdital daoxmlEdital = new DAOXMLEdital();
//		Edital edital = daoxmlEdital.consultarPorID(111101111);
//		
//		diretorMontagem = new DiretorMontagem(montadorFormatoSwing);
//		diretorMontagem.gerarRelatorioEdital(edital);
//		
//		try {
//			JScrollPane pane = (JScrollPane) diretorMontagem.getProduto();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private static void gerarRelatorioHTMLGrupo() throws Exception {
//		DAOXMLGrupo daoxmlGrupo = new DAOXMLGrupo();
//		Grupo grupo = daoxmlGrupo.consultarPorID(111101111);
//		
//		diretorMontagem = new DiretorMontagem(montadorFormatoHTML);
//		diretorMontagem.gerarRelatorioGrupo(grupo);
//
//		try {
//			File relatorio = (File) diretorMontagem.getProduto();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void gerarRelatorioSwingGrupo() throws Exception {
//		DAOXMLGrupo daoxmlGrupo = new DAOXMLGrupo();
//		Grupo grupo = daoxmlGrupo.consultarPorID(111101111);
//		
//		diretorMontagem = new DiretorMontagem(montadorFormatoSwing);
//		diretorMontagem.gerarRelatorioGrupo(grupo);
//		
//		try {
//			JScrollPane pane = (JScrollPane) diretorMontagem.getProduto();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private static void gerarRelatorioHTMLProjeto() throws Exception {
//		DAOXMLProjetoParticipacao daoxmlProjetoParticipacao = new DAOXMLProjetoParticipacao();
//		Projeto projeto = daoxmlProjetoParticipacao.consultarPorID(111101111);
//		
//		diretorMontagem = new DiretorMontagem(montadorFormatoHTML);
//		diretorMontagem.gerarRelatorioProjeto(projeto);
//		
//		try {
//			File relatorio = (File) diretorMontagem.getProduto();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void gerarRelatorioSwingProjeto() throws Exception {
//		DAOXMLProjetoParticipacao daoxmlProjetoParticipacao = new DAOXMLProjetoParticipacao();
//		Projeto projeto = daoxmlProjetoParticipacao.consultarPorID(111101111);
//		
//		diretorMontagem = new DiretorMontagem(montadorFormatoSwing);
//		diretorMontagem.gerarRelatorioProjeto(projeto);
//		
//		try {
//			JScrollPane pane = (JScrollPane) diretorMontagem.getProduto();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
