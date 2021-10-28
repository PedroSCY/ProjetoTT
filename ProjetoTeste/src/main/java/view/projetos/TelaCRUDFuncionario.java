package view.projetos;

/**
 * 
 * @author NPG
 *
 * Essa interface é o supertipo de um produto do padrao abstract factory
 */
public interface TelaCRUDFuncionario  {
	/**
	 * 
	 */
	static final long serialVersionUID = 1L;

	public void mostrarFuncionarios();
	public void adicionar();
	public void remover();
	public void atualizar();
}
