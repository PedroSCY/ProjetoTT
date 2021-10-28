package facades.casosdeuso;

import java.time.LocalDate;
import java.time.LocalDateTime;

//import javax.activity.InvalidActivityException;
//
//import model.projetos.Edital;
//import model.projetos.Grupo;
//import model.projetos.Projeto;
//import model.projetos.TiposItemProjeto;
//import persistencia.DAOXMLEdital;
//import persistencia.DAOXMLGrupo;
//import persistencia.DAOXMLProjetoParticipacao;
//import ponto.model.projetos.DiaSemana;
//import util.CentralAtualizacaoItemProjeto;

/**
 * @author NPG
 * Classe desenvolvida para testar as fachadas da etapa 2 e 3.
 */
@SuppressWarnings("unused")
public class Teste {
	
	public static void main(String[] args) {
//		criarMembros();
//		criarProjetos();
//		setarParticipantes();
//		criarEditais();
//		criarGrupos();
		
//		gerarRelatorios();

//		setarHorariosPrevistos();
//		justificarPonto();
		
		System.out.println("OK");
	}
	
//	private static void gerarRelatorios() {
//		FacadeCasoDeUso8 uso8 = new FacadeCasoDeUso8();
//		try {
//			// TODO Resolver meses pagos de participações negativos
//			
////			uso8.gerarRelatorioHTML(111101111, TiposItemProjeto.PROJETO); // OK
////			uso8.gerarRelatorioSwing(111101111, TiposItemProjeto.PROJETO); // OK
////			uso8.gerarRelatorioHTML(222202222, TiposItemProjeto.PROJETO); // OK
////			uso8.gerarRelatorioSwing(222202222, TiposItemProjeto.PROJETO); // OK
//			
////			uso8.gerarRelatorioHTML(111101111, TiposItemProjeto.EDITAL); // OK
////			uso8.gerarRelatorioSwing(111101111, TiposItemProjeto.EDITAL); // OK
////			uso8.gerarRelatorioHTML(222202222, TiposItemProjeto.EDITAL); // OK
////			uso8.gerarRelatorioSwing(222202222, TiposItemProjeto.EDITAL); // OK
////
////			uso8.gerarRelatorioHTML(111101111, TiposItemProjeto.GRUPO); // OK
////			uso8.gerarRelatorioSwing(111101111, TiposItemProjeto.GRUPO); // OK
////			uso8.gerarRelatorioHTML(222202222, TiposItemProjeto.GRUPO); // OK
////			uso8.gerarRelatorioSwing(222202222, TiposItemProjeto.GRUPO); // OK
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void criarGrupos() throws Exception{
//		FacadeCasoDeUso3 uso3 = new FacadeCasoDeUso3();
//		uso3.adicionar(111101111, "Grupo 1", LocalDate.now(), "Link CNPQ - Grupo 1", 111101111);
//		uso3.adicionar(111101111, "Grupo 2", LocalDate.now(), "Link CNPQ - Grupo 2", 222202222);
//		
//		DAOXMLGrupo daoxmlGrupo = new DAOXMLGrupo();
//		DAOXMLProjetoParticipacao daoxmlProjetoParticipacao = new DAOXMLProjetoParticipacao();
//		try {
//			Projeto projeto1 = daoxmlProjetoParticipacao.consultarPorID(111101111);
//			Grupo grupo1 = daoxmlGrupo.consultarPorID(111101111);
//			grupo1.adicionarItemProjeto(projeto1);
//			
//			Projeto projeto2 = daoxmlProjetoParticipacao.consultarPorID(222202222);
//			Grupo grupo2 = daoxmlGrupo.consultarPorID(222202222);
//			grupo2.adicionarItemProjeto(projeto2);
//			
//			CentralAtualizacaoItemProjeto.atualizarProjeto(111101111, projeto1);
//			CentralAtualizacaoItemProjeto.atualizarProjeto(222202222, projeto2);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void criarEditais() throws Exception{
//		FacadeCasoDeUso4 uso4 = new FacadeCasoDeUso4();
//		uso4.adicionarEdital(111101111, "Edital 1", LocalDate.of(2020, 11, 10), LocalDate.of(2020, 12, 20), 111101111);
//		uso4.adicionarEdital(111101111, "Edital 2", LocalDate.of(2020, 11, 10), LocalDate.of(2020, 12, 20), 222202222);
//		
//		DAOXMLEdital daoxmlEdital = new DAOXMLEdital();
//		DAOXMLProjetoParticipacao daoxmlProjetoParticipacao = new DAOXMLProjetoParticipacao();
//		try {
//			Projeto projeto1 = daoxmlProjetoParticipacao.consultarPorID(111101111);
//			Edital edital1 = daoxmlEdital.consultarPorID(111101111);
//			edital1.adicionarItemProjeto(projeto1);
//			
//			Projeto projeto2 = daoxmlProjetoParticipacao.consultarPorID(222202222);
//			Edital edital2 = daoxmlEdital.consultarPorID(222202222);
//			edital2.adicionarItemProjeto(projeto2);
//			
//			CentralAtualizacaoItemProjeto.atualizarProjeto(111101111, projeto1);
//			CentralAtualizacaoItemProjeto.atualizarProjeto(222202222, projeto2);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void criarMembros() {
//		FacadeCasoDeUso1 uso1 = new FacadeCasoDeUso1();
//		
//		uso1.cadastrarConta("User 1", 111101111, "user1@user.com", "senha1"); // Coordenador do Projeto 1
//		// Membros do Projeto 1
//		uso1.cadastrarConta("User 11", 111111111, "user11@user.com", "senha11");
//		uso1.cadastrarConta("User 12", 111121111, "user12@user.com", "senha12"); 
//		uso1.cadastrarConta("User 13", 111131111, "user13@user.com", "senha13");
//		uso1.cadastrarConta("User 14", 111141111, "user14@user.com", "senha14");
//		
//		uso1.cadastrarConta("User 2", 222202222, "user2@user.com", "senha2"); // Coordenador do Projeto 2
//		// Membros do Projeto 2
//		uso1.cadastrarConta("User 21", 222212222, "user21@user.com", "senha21");
//		uso1.cadastrarConta("User 22", 222222222, "user22@user.com", "senha22");
//		uso1.cadastrarConta("User 23", 222232222, "user23@user.com", "senha23");		
//	}
//	
//	private static void criarProjetos() throws Exception{
//		FacadeCasoDeUso5 uso5 = new FacadeCasoDeUso5();
//		uso5.criarProjeto(111101111, 111101111, "Projeto 1", 15000, 10000, LocalDate.of(2021, 1, 10), LocalDate.of(2021, 2, 20), 100);
//		uso5.criarProjeto(222202222, 222202222, "Projeto 2", 25000, 20000, LocalDate.of(2021, 1, 20), LocalDate.of(2021, 2, 20), 200);
//	}
//	
//	private static void setarParticipantes() {
//		FacadeCasoDeUso6 uso6 = new FacadeCasoDeUso6();
//		
//		try {
//			uso6.adicionarParticipante(111101111, 111111111, 111101111, LocalDate.of(2021, 01, 01), LocalDate.of(2021, 02, 02), 25);
//			uso6.adicionarParticipante(111101111, 111121111, 111101111, LocalDate.of(2021, 01, 01), LocalDate.of(2021, 02, 02), 50);
//			uso6.adicionarParticipante(111101111, 111131111, 111101111, LocalDate.of(2021, 01, 01), LocalDate.of(2021, 02, 02), 75);
//			uso6.adicionarParticipante(111101111, 111131111, 111101111, LocalDate.of(2021, 01, 01), LocalDate.of(2021, 02, 02), 15);
//
//			uso6.adicionarParticipante(222202222, 222212222, 222202222, LocalDate.of(2021, 03, 03), LocalDate.of(2021, 04, 04), 125);
//			uso6.adicionarParticipante(222202222, 222222222, 222202222, LocalDate.of(2021, 03, 03), LocalDate.of(2021, 04, 04), 150);
//			uso6.adicionarParticipante(222202222, 222232222, 222202222, LocalDate.of(2021, 03, 03), LocalDate.of(2021, 04, 04), 175);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private static void setarHorariosPrevistos() {
//		FacadeCasoDeUso10 uso10 = new FacadeCasoDeUso10();
//
//		try {
//			
//			uso10.adicionarNovoHoararioPrevisto(11, 1, 1, LocalDateTime.of(2021, 01, 04, 8, 0), LocalDateTime.of(2021, 01, 04, 12, 0), DiaSemana.SEG, (short) 20);
//			uso10.adicionarNovoHoararioPrevisto(11, 1, 1, LocalDateTime.of(2021, 01, 04, 13, 0), LocalDateTime.of(2021, 01, 04, 17, 0), DiaSemana.SEG, (short) 20);
//			uso10.adicionarNovoHoararioPrevisto(11, 1, 1, LocalDateTime.of(2021, 01, 04, 18, 0), LocalDateTime.of(2021, 01, 04, 22, 0), DiaSemana.SEG, (short) 20);
//			uso10.adicionarNovoHoararioPrevisto(11, 1, 1, LocalDateTime.of(2021, 01, 05, 9, 0), LocalDateTime.of(2021, 01, 05, 13, 0), DiaSemana.TER, (short) 20);
//			uso10.adicionarNovoHoararioPrevisto(11, 1, 1, LocalDateTime.of(2021, 01, 05, 14, 0), LocalDateTime.of(2021, 01, 05, 18, 0), DiaSemana.TER, (short) 20);
//						
//			uso10.adicionarNovoHoararioPrevisto(12, 1, 1, LocalDateTime.of(2021, 01, 06, 8, 0), LocalDateTime.of(2021, 01, 06, 12, 0), DiaSemana.QUA, (short) 20);
//			
//			uso10.adicionarNovoHoararioPrevisto(13, 1, 1, LocalDateTime.of(2021, 01, 07, 8, 0), LocalDateTime.of(2021, 01, 07, 12, 0), DiaSemana.QUI, (short) 20);
//			uso10.adicionarNovoHoararioPrevisto(13, 1, 1, LocalDateTime.of(2021, 01, 8, 13, 0), LocalDateTime.of(2021, 01, 8, 17, 0), DiaSemana.SEX, (short) 20);
//			
//			uso10.adicionarNovoHoararioPrevisto(14, 1, 1, LocalDateTime.of(2020, 11, 23, 8, 0), LocalDateTime.of(2020, 11, 23, 12, 0), DiaSemana.SEG, (short) 20);
//			uso10.adicionarNovoHoararioPrevisto(14, 1, 1, LocalDateTime.of(2020, 11, 24, 8, 0), LocalDateTime.of(2020, 11, 24, 12, 0), DiaSemana.TER, (short) 20);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private static void justificarPonto() {
//		try {
//			FacadeCasoDeUso12 uso12 = new FacadeCasoDeUso12();
//			uso12.justificarPontoInvalido(2, "user11@user.com", "Estava cansado eu não quis vir", 1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
//	}
}