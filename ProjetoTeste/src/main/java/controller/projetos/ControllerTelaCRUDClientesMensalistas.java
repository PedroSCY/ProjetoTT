package controller.projetos;

import facades.casosdeuso.FacadeHandleClienteMensalista;
import model.entidades.ClienteMensalista;
import util.ValidadoraFormatoEmail;

/**
 * 
 * @author NPG
 *
 *Essa classe é o controller como realiza operações do JPanel Tela cadastro grupos
 */
public class ControllerTelaCRUDClientesMensalistas {

//	private FacadeCasoDeUso3 facadeCasoDeUso3 = new FacadeCasoDeUso3();
	private FacadeHandleClienteMensalista facadeHandleClienteMensalista = new FacadeHandleClienteMensalista();
	private ClienteMensalista[] clientes;
//	private RegistradorSessaoLogin registradorSessaoLogin = RegistradorSessaoLogin.getInstance();
//	private long matriculaDoAdmin = registradorSessaoLogin.getMembroLogado().getMatricula();
	
	public void adicionarNovoClienteMensalista( String nome, String email, String senha, String cpfText ) throws Exception{
	
//		if(nome.isEmpty() || dataCriacaoDoGrupo.equals("  /  /    ") || linkCNPq.isEmpty() ) {
//			
//			throw new Exception("Informe todos os campos");
//		}
		if(nome.isEmpty() || (!ValidadoraFormatoEmail.validarEmail(email))|| senha.isEmpty() || cpfText.isEmpty() ) {
			
			throw new Exception("Preencha todos os campos");
		}
		
		long cpf = Long.parseLong(cpfText);
		
		facadeHandleClienteMensalista.cadastrarNovoCliente(nome, email, senha, cpf);
	}
	
	public void removerClienteMensalistaExistente(int posicao) throws Exception{
		
		if(posicao < 0) {
			
			throw new Exception("Escolha um Cliente para ser removido");
		}
		
		long ID = clientes[posicao].getCpf();
		
//		if(!facadeCasoDeUso3.remover(matriculaDoAdmin, ID)) {
//			
//			throw new Exception("Grupo não removido. Dados inválidos");
//		}
		facadeHandleClienteMensalista.removerCliente(ID);
		
	}
	
	public void atualizarClienteMensalistaExistente( String nome, String email, String senha, String cpfText, int posicao) throws Exception{
		
		if(posicao < 0) {
			
			throw new Exception("Escolha um Cliente para ser removido");
		}
		
		ClienteMensalista  clienteMensalista = clientes[posicao];
		
		String emailAlterado = clienteMensalista.getEmail();
		String senhaAlterada = clienteMensalista.getSenha();
		
		if(!emailAlterado.equals(email)) {
			emailAlterado = email;
		}
		if(!senhaAlterada.equals(senha)) {
			senhaAlterada = senha;
		}
		
		facadeHandleClienteMensalista.atualizarCadastroDeCliente(nome, emailAlterado, senhaAlterada, Long.parseLong(cpfText));

	}
	
	public void adicionarCredito(int posicao, String valor) throws Exception{
		
		if(posicao < 0) {
			
			throw new Exception("Escolha um Cliente");
		}
		
		validarSeENumero(valor);
		
		facadeHandleClienteMensalista.adicionarCredito(clientes[posicao].getCpf(), Float.parseFloat(valor));
		
	}
	
	public String[] getCamposParaPreencher(int posicao) throws Exception{
		
		/*
		 * Esse método retorna os valores de um Grupo para seus respectivos campos, onde...
		 * posicao 0 = nome do funcionário
		 * posicao 1 = email
		 * posicao 2 = senha 
		 * posicao 3 = CPF
		 * posicao 4 = créditos
		 */
		if(posicao != -1) {
			
			ClienteMensalista clienteMensalista = clientes[posicao];
			
			String[] campos = new String[5];
						
			campos[0] = clienteMensalista.getNome();
			campos[1] = clienteMensalista.getEmail();
			campos[2] = clienteMensalista.getSenha();
			campos[3] = String.valueOf(clienteMensalista.getCpf());
			campos[4] = String.valueOf(clienteMensalista.getCreditoDisponivel());
			
			
			return campos;
			
		}
		
		return  null ;
	}
	
	public ClienteMensalista[] getTodoOsClientesMensalistasDoSistema() {
		
		clientes = facadeHandleClienteMensalista.getTodosOsClientesMensalistas();
		return clientes;
	}
	
	private void validarSeENumero(String valor) throws Exception {
		if(!valor.matches("^[0-9]*[.]{0,1}[0-9]*$")) {
			throw new Exception("Valores incorretos");
		}
	}
	
	
}
