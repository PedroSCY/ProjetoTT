package view.projetos;


/**
 * 
 * @author NPG
 *
 *Essa interface é o supertipo de um produto do padrão abstract factory
 *
 */
public interface TelaCRUDClientesMensalistas {

	/**
	 * 
	 */
	static final long serialVersionUID = 1L;

	public void mostrarClientes();
	public void adicionar();
	public void remover();
	public void atualizar();
}
