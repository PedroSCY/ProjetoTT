package controller.projetos;

import facades.casosdeuso.FacadePagamentos;
import model.entidades.RegistroPagamento;

/**
 * 
 * @author NPG
 *
 *Essa classe é o controller como realiza operações do JPanel Tela cadastro Projetos
 */
public class ControllerTelaFuncionario {

	private FacadePagamentos facadePagamentos = new FacadePagamentos();
	private RegistroPagamento[] registroPagamentos;
		
	public void registrarPagamento(String matriculaFuncionarioText, String valor,  int posicao) throws Exception{

		if(posicao < 0) {
			
			throw new Exception("Escolha um registro");
		
		}
		
		validarSeENumero(valor);
		
		float valorPago = Float.parseFloat(valor);
		
		long matricula = Long.parseLong(matriculaFuncionarioText);
		
		facadePagamentos.registrarPagamento(matricula, valorPago, registroPagamentos[posicao].getId());
		
	}
	
	public void descontarDeCredito(long matricula, String valor,int posicao, long cpf) throws Exception{
		
		if(posicao < 0) {
			
			throw new Exception("Escolha um registro");
		
		}
		
		validarSeENumero(valor);
		
		float valorAPagar = Float.parseFloat(valor);
		
		facadePagamentos.descontarDeCredito(matricula, valorAPagar, registroPagamentos[posicao].getId(), cpf);
	}
	
	public void receberVeiculo(String placaVeiculo, long matricula) throws Exception{
		
		facadePagamentos.receberVeiculo(placaVeiculo, matricula);
		
	}
	
	public int getVagasDisponiveis() throws Exception{
		
		return facadePagamentos.verificarVagasDisponiveis();
	}
	
	public float valorAPagar(int posicao) throws Exception{
		
		registroPagamentos = getTodoOsRegistrosDePagamentoDoSistema();
		
		return facadePagamentos.calcularTotalAPagar(registroPagamentos[posicao].getData());
	}
	
		
	public RegistroPagamento[] getTodoOsRegistrosDePagamentoDoSistema() {
		
		registroPagamentos = facadePagamentos.getTodosOsRegstrosDePagamento();
		return registroPagamentos;
	}
	
	private void validarSeENumero(String valor) throws Exception {
		if(!valor.matches("^[0-9]*[.]{0,1}[0-9]*$")) {
			throw new Exception("Valores incorretos");
		}
	}
	
	public long verificarMatricula(String matricula) throws Exception{
		
		try {
			if(matricula.length() == 9) {
				return Long.parseLong(matricula);
			}
			throw new Exception("Matricula inválida");
			
		}catch (Exception e) {
			throw new Exception("Matricula inválida");
		}
		
	}
	
	public long verificarCPF(String cpf) throws Exception{
		
		try {
			if(cpf.length() == 11) {
				return Long.parseLong(cpf);
			}
			throw new Exception("CPF inválido");
			
		}catch (Exception e) {
			throw new Exception("CPF inválido");
		}
		
	}
}
