package view.projetos;

/**
 * 
 * @author NPG
 * 
 * Essa interface é o supertipo de um produto do padrão abstract factory
 *
 */
public interface TelaFuncionario  {
	/**
	 * 
	 */
	static final long serialVersionUID = 1L;

	public void mostrarTelaFuncionario();
	public void adicionar();
	public void remover();
	public void atualizar();
}
