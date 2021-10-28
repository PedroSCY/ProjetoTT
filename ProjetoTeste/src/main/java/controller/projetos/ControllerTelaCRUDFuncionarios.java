package controller.projetos;


import java.time.LocalDate;
import java.time.LocalDateTime;

import facades.casosdeuso.FacadeCRUDFuncionarios;
import facades.casosdeuso.FacadeGerarRelatorios;
//import model.autenticacao.RegistradorSessaoLogin;
import model.entidades.Funcionario;
import util.ValidadoraDatas;
//import model.projetos.Edital;
//import model.projetos.TiposItemProjeto;
import util.ValidadoraFormatoEmail;


/**
 * 
 * @author NPG
 *
 *Essa classe é o controller como realiza operações do JPanel Tela cadastro Editais
 */
public class ControllerTelaCRUDFuncionarios {

	
	private FacadeCRUDFuncionarios facadeCRUDFuncionarios = new FacadeCRUDFuncionarios();
	private FacadeGerarRelatorios facadeGerarRelatorios = new FacadeGerarRelatorios();
	
	private Funcionario[] funcionarios;
	
	public void adicionarNovoFuncionario(String matriculaFuncionarioText, String nome, String email, String senha, String cpfText) throws Exception{
		
		System.out.println(nome.isEmpty());
		System.out.println(ValidadoraFormatoEmail.validarEmail(email));
		System.out.println(senha.isEmpty());
		System.out.println(matriculaFuncionarioText.isEmpty());
		System.out.println(cpfText.isEmpty() );
		
		if(nome.isEmpty() || (!ValidadoraFormatoEmail.validarEmail(email))|| senha.isEmpty() || matriculaFuncionarioText.isEmpty() || cpfText.isEmpty() ) {
			
			throw new Exception("Preencha todos os campos");
		}
		
		long matriculaFuncionario = Long.parseLong(matriculaFuncionarioText);
		long cpf = Long.parseLong(cpfText);
		
		
		facadeCRUDFuncionarios.cadastrarNovoFuncionario(matriculaFuncionario, nome, email, senha, cpf, false);
		
	}
	
	public void removerFuncionarioExistente(int posicao)  throws Exception{
		
		if(posicao < 0) {
			
			throw new Exception("Escolha um Funcionário para ser removido");
		
		}

		long id = funcionarios[posicao].getMatricula();
		
		
		facadeCRUDFuncionarios.removerFuncionario(id);
	}
	
	public void atualizarFuncionarioExistente(String matriculaFuncionarioText, String nome, String email, String senha, String cpfText, int posicao) throws Exception{
		
		if(posicao < 0) {
			
			throw new Exception("Escolha um Funcionário para atualizar");
			
		}
		
		Funcionario funcionario = funcionarios[posicao];
				
		
		String nomeAlterado = funcionario.getNome();
		String emailAlterado = funcionario.getEmail();
		String senhaAlterada = funcionario.getSenha();
		
		if(!nomeAlterado.equals(nome)) {
			nomeAlterado = nome;
		}
		if(!emailAlterado.equals(email)) {
			emailAlterado = email;
		}
		if(!senhaAlterada.equals(senha)) {
			senhaAlterada = senha;
		}
		
		
		facadeCRUDFuncionarios.atualizarCadastroDeFuncionario(funcionario.getMatricula(), nomeAlterado, emailAlterado,
				senhaAlterada, funcionario.getCpf());
		
	}
	
	public String[] getCamposParaPreencher(int posicao) throws Exception{
		
		/*
		 * Esse método retorna os valores de um Edital para seus respectivos campos, onde...
		 * posicao 0 = matrícula do funcionário
		 * posicao 1 = nome do funcionário
		 * posicao 2 = email
		 * posicao 3 = senha 
		 * posicao 4 = CPF
		 */
		if(posicao != -1) {
			
			Funcionario funcionario = funcionarios[posicao];
			
			String[] campos = new String[5];
			
			
			campos[0] = String.valueOf(funcionario.getMatricula());
			campos[1] = funcionario.getNome();
			campos[2] = funcionario.getEmail();
			campos[3] = funcionario.getSenha();
			campos[4] = String.valueOf(funcionario.getCpf());
			
			return campos;
			
		}
		
		return  null ;
	}
	
	public Funcionario[] getTodoOsFuncionariosDoSistema() {
		
		funcionarios = facadeCRUDFuncionarios.getTodosOsFuncionarios();
		
		return funcionarios;
	}
	
	public void gerarRelatorioDiario(String data) throws Exception{
		
		LocalDateTime dataRetornada = ValidadoraDatas.criarDataTime(data);
		
		if(!dataRetornada.isAfter(LocalDateTime.now())) {
			
			facadeGerarRelatorios.criarRelatorioDiario(dataRetornada);
		}else {
			throw new Exception("Data inválida");
		}
		

	}
	
	public void gerarRelatorioMensal(String data) throws Exception{
		
//		String data = String.valueOf(LocalDate.now().getDayOfMonth()) + "/" + mes + "/"+ano;
		
		LocalDate dataRetornada = ValidadoraDatas.criarData(data);
		
		if(!dataRetornada.isAfter(LocalDate.now())) {
			
			facadeGerarRelatorios.criarRelatorioMensal(dataRetornada.getDayOfMonth(), dataRetornada.getYear());
		}else {
			throw new Exception("Data inválida");
		}
		

	}
	

	
	
}


