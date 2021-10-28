package controller.autenticacao;

//import facades.casosdeuso.FacadeCasoDeUso2;
import facades.casosdeuso.FacadeLogin;
//import model.autenticacao.RegistradorSessaoLogin;
//import model.autenticacao.TipoProvedorAutenticacao;
import model.entidades.Funcionario;
//import view.projetos.TelaPonto;
import view.projetos.TelaPrincipal;

/**
 * 
 * @author NPG
 * 
 *  Essa classe é o controller que realiza operações do JPanel TelaAutenticacao.
 *
 */
public class ControllerTelaAutenticacao {
	
//	private FacadeCasoDeUso2 facadeCasoDeUso2 = new FacadeCasoDeUso2();
//	private RegistradorSessaoLogin registradorSessaoLogin = RegistradorSessaoLogin.getInstance();
	private FacadeLogin facadeLogin = new FacadeLogin();
	
	private boolean isGerente;
	
	public boolean fazerLogin(String email,String senha) throws Exception {
		
//		TipoProvedorAutenticacao tipoProvedor = TipoProvedorAutenticacao.INTERNO;
		
//		if(!tipoProvedorInterno) {
//			tipoProvedor = TipoProvedorAutenticacao.EMAIL_SMTP;
//		}
		
		Funcionario funcionario = facadeLogin.fazerLogin(email, senha);
		
		if(funcionario == null) {
			return false;
		}else {
			
			if(funcionario.isGerente()) {
				
//				isAdmin = registradorSessaoLogin.getMembroLogado().isAdministrador();
				isGerente = true;
			}
			
			return true;
		}
		
		
	}
	
	public void proximaTela() {

		TelaPrincipal telaPrincipal = new TelaPrincipal();
			
		telaPrincipal.validarAdminGerente(isGerente);
		
		ControllerTelaPrincipalAutenticacao.encerrarJanela();
		
	}
	
}
