package view.projetos.relatorios;

import java.util.Set;

import model.entidades.RegistroPagamento;

/**
 * 
 * @author NPG
 * Esta interface representa o supertipo para os montadores concretos da implementacao do padrao builder.
 */
public interface InterfacePartesMontagem {
	public void gerarRelatorio(Set<RegistroPagamento> pagamentos) throws Exception;
	public void reiniciar();
	public Object encerrar();
	public void mostrarProduto();
}
