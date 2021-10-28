package view.projetos.relatorios;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import model.entidades.RegistroPagamento;
import util.ValidadoraDatas;

/**
 * 
 * @author NPG
 * Esta classe representa o Diretor de montagem na implementacao do padrao builder. 
 */
public class DiretorMontagem {
	private InterfacePartesMontagem montadorFormato;
	private Object produto;
	
	public DiretorMontagem(InterfacePartesMontagem montadorFormato) {
		this.montadorFormato = montadorFormato;
	}
	
	public Object getProduto() throws Exception {
		if(produto == null)
			throw new Exception("Nenhum produto foi gerado.");
		
		return produto;
	}
	
	private void setProduto(Object obj) {
		this.produto = obj;
	}
	
	/**
	 * Forma de montagem 1: Gera um relatorio de um edital com seus projetos.
	 * @param codigo Codigo do edital no arquivo XML.
	 */
	public void gerarRelatorioMensal(Set<RegistroPagamento> pagamentos, int mes, int ano ) {
		try {
			// Para garantir que um relatorio totalmente novo sera gerado, chama-se o metodo reiniciar
			Set<RegistroPagamento> registroPagamentosFiltrados = new LinkedHashSet<RegistroPagamento>();
			montadorFormato.reiniciar();
			
			for(RegistroPagamento pagamento: pagamentos) {
				
				if(pagamento.getData().getMonthValue() == mes && pagamento.getData().getYear() == ano ) {
					
					registroPagamentosFiltrados.add(pagamento);
				}
			}
			
			montadorFormato.gerarRelatorio(registroPagamentosFiltrados);
			
			encerrarEMostrar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void gerarRelatorioDiario(Set<RegistroPagamento> pagamentos, LocalDateTime data) {
		try {
			// Para garantir que um relatorio totalmente novo sera gerado, chama-se o metodo reiniciar
			montadorFormato.reiniciar();
			
			Set<RegistroPagamento> registroPagamentosFiltrados = new LinkedHashSet<RegistroPagamento>();
			montadorFormato.reiniciar();
			
			for(RegistroPagamento pagamento: pagamentos) {
				
				if(ValidadoraDatas.data1IguaData2(pagamento.getData(), data)) {
					
					registroPagamentosFiltrados.add(pagamento);
				}
			}
			
			montadorFormato.gerarRelatorio(registroPagamentosFiltrados);

			encerrarEMostrar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	/**
//	 * Forma de montagem 3: Gera um relatorio de um grupo com seus projetos.
//	 * @param codigo Codigo do grupo no arquivo XML.
//	 */
//	public void gerarRelatorioGrupo(Grupo grupo) {
//		try {
//			// Para garantir que um relatorio totalmente novo sera gerado, chama-se o metodo reiniciar
//			montadorFormato.reiniciar();
//			montadorFormato.gerarRelatorioGrupo(grupo);
//			
//			// Para cada projeto deste edital, haverá um espaço com os dados deste projeto
//			// É responsabilidade do diretor de montagem coordenar este aspecto de montagem.
//			for (int i = 0; i < grupo.getProjetos().size(); i++) {
//				montadorFormato.gerarRelatorioProjeto((Projeto) grupo.getProjetos().get(i));
//			}
//			
//			encerrarEMostrar();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * Forma de montagem 1: Gera um relatorio de um projeto.
//	 * @param codigo Codigo do projeto no arquivo XML.
//	 */
//	public void gerarRelatorioProjeto(Projeto projeto) {
//		try {
//			montadorFormato.gerarRelatorioProjeto(projeto);
//			encerrarEMostrar();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	private void encerrarEMostrar() {
		setProduto(montadorFormato.encerrar());
		montadorFormato.mostrarProduto();
	}
}
