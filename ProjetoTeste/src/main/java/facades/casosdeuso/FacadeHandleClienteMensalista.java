package facades.casosdeuso;

import util.ValidadoraFormatoEmail;

import java.util.Set;

//import dao.DAOClienteMensalista;
import model.entidades.ClienteMensalista;
import persistencia.DAOClienteMensalista;

public class FacadeHandleClienteMensalista {

//	private DAOClienteMensalista dAOClienteMensalista;

	private DAOClienteMensalista daoClienteMensalista;
	private ClienteMensalista clienteMensalista;
	
	public FacadeHandleClienteMensalista() {
		
		daoClienteMensalista = new DAOClienteMensalista();
	}
	

	//TODO - atualizar UML
	public void registrarCredito(long matricula, long cpf, float valorCreditado) throws Exception {

		clienteMensalista = daoClienteMensalista.consultarCliente(cpf);

		clienteMensalista.setCreditoDisponivel(valorCreditado);
		
		daoClienteMensalista.atualizar(cpf, clienteMensalista);
		
		
	}

	//TODO -atualizar o UML
	public void cadastrarNovoCliente(String nome, String email, String senha, long cpf) throws Exception {

		if(!validarEmail(email)) {
			throw new Exception("Email inválido");
		}
		
		daoClienteMensalista.ClienteMensalistaNaoExiste(cpf);
		
		ClienteMensalista clienteMensalista = new ClienteMensalista(nome, email, senha, cpf, 0);
		
		daoClienteMensalista.criar(clienteMensalista);
	}

	public ClienteMensalista recuperarCliente(long cpf) throws Exception {
		return daoClienteMensalista.consultarCliente(cpf);
	}

	public Set<ClienteMensalista> listarClientes() {
		return daoClienteMensalista.consultarTodos();
	}
//TODO - atualizar UML
	public void atualizarCadastroDeCliente(String nome, String email, String senha, long cpf) throws Exception {
		
		if(!validarEmail(email)) {
			throw new Exception("Email inválido");
		}
		
		clienteMensalista = daoClienteMensalista.consultarCliente(email);
		
		clienteMensalista.setNome(nome);
		clienteMensalista.setCpf(cpf);
		
		daoClienteMensalista.atualizar(cpf, clienteMensalista);
		
		
	}

	public void removerCliente(long cpf) throws Exception {

		daoClienteMensalista.remover(cpf);
	}

	private boolean validarEmail(String email) {
		return ValidadoraFormatoEmail.validarEmail(email);
	}
	
	public ClienteMensalista[] getTodosOsClientesMensalistas() {
		Set<ClienteMensalista> clientesMensalistasRegistrados = daoClienteMensalista.consultarTodos();
		return clientesMensalistasRegistrados.toArray(new ClienteMensalista[clientesMensalistasRegistrados.size()]);
	}

	public void adicionarCredito(long cpf, float valor) throws Exception{
		
		clienteMensalista = daoClienteMensalista.consultarCliente(cpf);
		clienteMensalista.setCreditoDisponivel(clienteMensalista.getCreditoDisponivel()+valor);
		daoClienteMensalista.atualizar(cpf, clienteMensalista);
		
		
	}
}
