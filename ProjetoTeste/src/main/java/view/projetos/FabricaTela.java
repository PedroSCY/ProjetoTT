package view.projetos;

import view.autenticacao.TelaAutenticacao;
//import view.autenticacao.TelaConfiguracaoAdmin;
import view.autenticacao.TelaCriarConta;

/**
 * 
 * @author NPG
 *
 *Essa classe representa o super tipo fabrica do padrão abstract factory
 *
 */
public interface FabricaTela {

	public TelaFuncionario fabricarTelaFuncionario();
	public TelaCRUDClientesMensalistas fabricarTelaCRUDClientesMensalistas();
	public TelaCRUDFuncionario fabricarTelaCRUDFuncionarios();
//	public TelaJustificarPonto fabricaTelaJustificarPonto();
	public TelaAutenticacao fabricarTelaAutenticacao();
	public TelaCriarConta fabricarTelaCriarConta();
	
//	public TelaConfiguracaoAdmin fabricarTelaConfiguracaoAdmin();
	
}
