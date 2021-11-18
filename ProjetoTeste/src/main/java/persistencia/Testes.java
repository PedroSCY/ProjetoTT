package persistencia;



import model.entidades.ClienteMensalista;
import model.entidades.Funcionario;

import model.entidades.RegistroPagamento;


public class Testes {
	
	public static DAORegistroPagamento daoRegistroPagamento = new DAORegistroPagamento();
	public static DAOClienteMensalista daoClienteMensalista = new DAOClienteMensalista();
	public static DAOCentralDoSistema daoCentralDoSistema = new DAOCentralDoSistema();
	public static DAOFuncionario daoFuncionario = new DAOFuncionario();
	
	
	public static void listarClientes() {
		for(ClienteMensalista c : daoClienteMensalista.consultarTodos()) {
			System.out.println(c.getNome() + " Senha: " + c.getSenha());
		}
		System.out.println("----------------------------------------------------------\n");
	}
	
	public static void listarFuncionarios() {
		for(Funcionario f : daoFuncionario.consultarTodos()) {
			System.out.println(f.getNome() + " Senha: " + f.getSenha() + " Gerente: " + f.isGerente());
		}
		System.out.println("----------------------------------------------------------\n");
	}
	
	public static void listarRegistrosPagamentos() {
		for(RegistroPagamento rp : daoRegistroPagamento.consultarTodos()) {
			System.out.println(rp.getFuncionario().getNome() + " Data: " + rp.getData() + "\nPlaca: " + rp.getPlacaVeiculo()
			+ " Valor Pago: "+ rp.getValorPago() + " ID: "+  rp.getId() +   "\n");
		}
		System.out.println("----------------------------------------------------------\n");
		
	}
	

	public static void main(String[] args) {
		
//		ClienteMensalista clienteMensalista1 = new ClienteMensalista("pessoa1N","pessoa1@E","pessoa1S",001, 100);
//		ClienteMensalista clienteMensalista2 = new ClienteMensalista("pessoa2N","pessoa2@E","pessoa2S",002, 100);
//		ClienteMensalista clienteMensalista3 = new ClienteMensalista("pessoa3N","pessoa3@E","pessoa3S",003, 100);
//		
//		Funcionario gerente = new Funcionario("gerente","gerente@G","gerenteS", 000, 0000, true);
//		
//		Funcionario funcionario1 = new Funcionario("funcionario1","funcionario1@E","funcionario1S", 100, 0001, false);
//		Funcionario funcionario2 = new Funcionario("funcionario2","funcionario2@E","funcionario2S", 200, 0002, false);
//		Funcionario funcionario3 = new Funcionario("funcionario3","funcionario3@E","funcionario3S", 300, 0003, false);
//		
////		 CADASTRA CLIENTEMNESALISTA NO XML
//		try {
//			daoClienteMensalista.criar(clienteMensalista1);
//			daoClienteMensalista.criar(clienteMensalista2);
//			daoClienteMensalista.criar(clienteMensalista3);
//			
//		}catch (Exception e){
//			System.out.println(e.getMessage());
//		}
//		
////		 LISTAR CLIENTESMENSALISTAS CADASTRADOS
//		listarClientes();
//
//		
////		ATUALIZA CLIENTEMENSALISTA CADASTRADO
//		ClienteMensalista atualizarCliente = new ClienteMensalista("pessoa3N","pessoa3@E","pessoa3S2",003, 100);
//		daoClienteMensalista.atualizar(003, atualizarCliente);
//		
////		 LISTAR CLIENTESMENSALISTAS CADASTRADOS
//		listarClientes();
//		
//		
////		REMOVE CLIENTEMENSALISTA CADASTRADO
//		try {
//			daoClienteMensalista.remover(001);
//			
//		}catch (Exception e){
//			System.out.println(e.getMessage());
//		}
//		
////		 LISTAR CLIENTESMENSALISTAS CADASTRADOS
//		listarClientes();
//		
//		
//		
////		 CADASTRA funcionario NO XML
//		
//		System.out.println("Criar;\n");
//		
//		try {
//			
//			daoFuncionario.criar(gerente);
//			daoFuncionario.criar(funcionario1);
//			daoFuncionario.criar(funcionario2);
//			daoFuncionario.criar(funcionario3);
//			
//		}catch (Exception e){
//			System.out.println(e.getMessage());
//		}
//		
//		listarFuncionarios();
//
////		ATUALIZA CLIENTEMENSALISTA CADASTRADO
//		System.out.println("Atualizar;\n");
//		
//		Funcionario funcionarioAtualizado = new Funcionario("gerente","gerente@G","gerenteS", 000, 0000, false);
//		daoFuncionario.atualizar(000, funcionarioAtualizado);
//		
//		listarFuncionarios();
//		
//		System.out.println("Remover;\n");
//		
//		try {
//			
//			daoFuncionario.remover(0001);
//		}catch (Exception e){
//			System.out.println(e.getMessage());
//		}
//		
//		listarFuncionarios();
//		
//
////		Criar registros no xml (NÃO MEXA OU MORRA POR ESTRESSE AOS 20)
//		
//		RegistroPagamento registroP1 = new RegistroPagamento();
//		registroP1.setData(LocalDate.now());
//		registroP1.setPlacaVeiculo("AA10");
//		registroP1.setValorPago(100);
//		registroP1.setFuncionario(funcionario1);
//		
//		RegistroPagamento registroP2 = new RegistroPagamento();
//		registroP2.setData(LocalDate.now());
//		registroP2.setPlacaVeiculo("AA20");
//		registroP2.setValorPago(100);
//		registroP2.setFuncionario(funcionario2);
//		
//		RegistroPagamento registroP3 = new RegistroPagamento();
//		registroP3.setData(LocalDate.now());
//		registroP3.setPlacaVeiculo("AA30");
//		registroP3.setValorPago(100);
//		registroP3.setFuncionario(funcionario3);
//		
//		
//		try {
//			
//			daoRegistroPagamento.criar(registroP1);
//			daoRegistroPagamento.criar(registroP2);
//			daoRegistroPagamento.criar(registroP3);
//		
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		listarRegistrosPagamentos();
//		
////		1618946687639
////		1618946700460
////		1618946711050
//		
//		
//		
//		RegistroPagamento rg = null;
//		
//		try {
//			 rg = daoRegistroPagamento.consultarRegistro(1618946687639l);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		rg.setFuncionario(funcionario1);
//		
//		daoRegistroPagamento.atualizar(1618946687639l, rg);
//			
//		listarRegistrosPagamentos();
//		
//		try {
//			daoRegistroPagamento.remover(1618946687639l);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		listarRegistrosPagamentos();
//		
//		
//		CentralDoSistema cds = CentralDoSistema.getInstance();
//		
//	
//		
//		cds.setAgenciaBancaria("Itau");
//		cds.setCNPJ("1001");
//		cds.setNumeroAgencia("01");
//		cds.setNumeroContaEstacionamento("20");
//		cds.setQuantidadeVagasDisponiveis(100);
//		cds.setValorBase(10);
//		cds.setValorPorHoraExtra(5);
//		cds.setVariacao("nenhuma");
//		
//		daoCentralDoSistema.salvarCentral(cds);
		

		
		
		
		
		
		
		
		
		
		
		

			
		
		
		
		
		
	}

}
