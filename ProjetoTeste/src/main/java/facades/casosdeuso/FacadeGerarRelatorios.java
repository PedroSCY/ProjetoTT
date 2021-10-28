package facades.casosdeuso;

//import relatorios.DiretorMontagemRelatorio;
import java.time.LocalDateTime;

import persistencia.DAORegistroPagamento;
import view.projetos.relatorios.DiretorMontagem;
import view.projetos.relatorios.MontadorRelatorioSwing;;

public class FacadeGerarRelatorios {

	private DiretorMontagem diretorMontagemRelatorio; 
	private DAORegistroPagamento daoRegistroPagamento;
	
	public FacadeGerarRelatorios() {

		daoRegistroPagamento = new DAORegistroPagamento();
		diretorMontagemRelatorio = new DiretorMontagem(new MontadorRelatorioSwing());
	}

	public void criarRelatorioMensal(int mes, int ano) {
		
		diretorMontagemRelatorio.gerarRelatorioMensal(daoRegistroPagamento.consultarTodos(), mes, ano);
		
		
	}

	public void criarRelatorioDiario(LocalDateTime data) {

		diretorMontagemRelatorio.gerarRelatorioDiario(daoRegistroPagamento.consultarTodos(), data);
	}

}
