package controller.autenticacao;

import facades.casosdeuso.FacadeCRUDFuncionarios;
import model.entidades.Funcionario;
import view.autenticacao.TelaCadastroEstacionamento;
import view.autenticacao.TelaPrincipalAutenticacao;

/**
 * 
 * @author NPG
 *
 *  Essa classe é o controller que realiza operações do JPanel TelaCriarConta.
 *  
 */
public class ControllerTelaCriarConta {

	private static FacadeCRUDFuncionarios facadeCRUDFuncionarios = new FacadeCRUDFuncionarios();
	
	public void cadastrarConta(String nome,long matricula,String login,String senha, String cpf) throws Exception {
		
//		if(!facadeCasoDeUso1.cadastrarConta(nome, matricula, login, senha)) {
//			throw new Exception("Nao foi possivel cadastrar conta");
//		}
		
		facadeCRUDFuncionarios.cadastrarNovoFuncionario( matricula, nome, login, senha, Long.parseLong(cpf),isPrimeiroAcesso());
		
	}
	
	public void atualizarConta(long matricula , String nome, String login, String senha, long cpf) throws Exception {
		
//		if(!facadeCasoDeUso1.atualizar(matricula, nome, login, senha)) {
//			throw new Exception("Nao foi possivel atualizar conta");
//		}
		
		facadeCRUDFuncionarios.atualizarCadastroDeFuncionario(matricula, nome, login, senha, cpf);
		
	}
	
	
	public static boolean isPrimeiroAcesso() {
		Funcionario[] funcionarios = facadeCRUDFuncionarios.getTodosOsFuncionarios();
		
		if(funcionarios.length == 0)
			return true;
		
		return false;
		
	}
	
//	public void proximaTela() {
//		ControllerTelaPrincipalAutenticacao.getTelaPrincipalAutenticacao().dispose();
//		new TelaCadastroEstacionamento();
//	}
	

}
