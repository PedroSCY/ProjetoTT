package controller.autenticacao;

import facades.casosdeuso.FacadeCadastroEstacionamento;
import view.autenticacao.TelaPrincipalAutenticacao;

public class ControllerTelaCadastroEstacionamento {

	private FacadeCadastroEstacionamento facadeCadastroEstacionamento;
	
	public ControllerTelaCadastroEstacionamento() {
		
		facadeCadastroEstacionamento = new FacadeCadastroEstacionamento();
	}
	
	public void cadastrarInformacoes(String valorBaseText, String valorTaxaText, String CNPJ, String agencia,
			String numeroAgencia, String numeroConta, String variacao, String totalVagasText) throws Exception{
		
		if(valorBaseText.isEmpty() || valorTaxaText.isEmpty() || CNPJ.isEmpty() || agencia.isEmpty() || numeroAgencia.isEmpty() ||
				numeroConta.isEmpty() || variacao.isEmpty() || totalVagasText.isEmpty()) {
			throw new Exception("Preencha todos os campos");
		}
		
		validarSeENumero(valorBaseText);
		validarSeENumero(valorTaxaText);
		validarSeENumero(totalVagasText);
		
		float valorBase = Float.parseFloat(valorBaseText);
		float valorTaxa = Float.parseFloat(valorTaxaText);
		int totalVagas = Integer.parseInt(totalVagasText);
//		
		facadeCadastroEstacionamento.cadastrarInformacoesDoEstacionamento(valorBase, valorTaxa, CNPJ, agencia, numeroAgencia, 
				numeroConta, variacao, totalVagas);
		
	}
	
	public String[] preencherCampos() {
		
		return facadeCadastroEstacionamento.getInformacoes();
	}
	
	public void proximaTela() {
		new TelaPrincipalAutenticacao();
		
	}
	 
	
	
	
	private void validarSeENumero(String valor) throws Exception {
		if(!valor.matches("^[0-9]*[.]{0,1}[0-9]*$")) {
			throw new Exception("Valores incorretos");
		}
	}
}
