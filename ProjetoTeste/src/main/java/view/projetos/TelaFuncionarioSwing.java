package view.projetos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import controller.projetos.ControllerTelaFuncionario;

/**
 * 
 * @author NPG
 * 
 * Essa classe é um produto concreto do padrão abstract factory
 *
 */
public class TelaFuncionarioSwing extends JPanelTelaCadastroSwing implements TelaFuncionario {

	private static final long serialVersionUID = 1L;

	private ControllerTelaFuncionario controllerTelaFuncionario;
	private String placa;
	private long matricula;
	private long CPF;
	private String texto = "VAGAS:";
	private String texto2 = "VALOR A PAGAR:";
	private JButton btnAdicionarMembro, btnRemoverMembro, btnReceberVeiculo;
	private TelaFuncionarioSwing telaFuncionarioSwing = this;
	private JLabel vagas, valor;
	
	
	public  TelaFuncionarioSwing() {

		controllerTelaFuncionario = new ControllerTelaFuncionario();
	}
	
	public class OuvinteDosBotoes implements ActionListener{

		public void actionPerformed(ActionEvent evento) {
			
			try {
				
				if(evento.getActionCommand().equals("Registrar pagamento")) {
					
					isSelecionado();
					
					String matricula = JOptionPane.showInputDialog("Insira sua matrícula");
					
					if(matricula != null ) {
						TelaFuncionarioSwing.this.matricula = controllerTelaFuncionario.verificarMatricula(matricula);
						atualizar();
						
					}
					
					
				}else if(evento.getActionCommand().equals("Discontar crédito")){
					
					isSelecionado();

					String matricula = JOptionPane.showInputDialog("Insira sua matrícula");
					
					if(matricula != null ) {
						
						TelaFuncionarioSwing.this.matricula = controllerTelaFuncionario.verificarMatricula(matricula);
						
						String cpfCliente = JOptionPane.showInputDialog("Insira o cpf do cliente");
						
						if(cpfCliente != null ) {
							
							TelaFuncionarioSwing.this.CPF = controllerTelaFuncionario.verificarCPF(cpfCliente);
							remover();
							
						}
					}
					
				
				}else if (evento.getActionCommand().equals("Receber Veículo")) {
					
					String matricula = JOptionPane.showInputDialog("Insira sua matrícula");
					
					if(matricula != null ) {
						
						TelaFuncionarioSwing.this.matricula = controllerTelaFuncionario.verificarMatricula(matricula);
						
						String placa = JOptionPane.showInputDialog("Insira a placa do veículo");
						
						if(placa != null ) {
							TelaFuncionarioSwing.this.placa = placa;
							adicionar();
						}
					}
					
					
				}
				
				atualizarVagas();
				
			}catch (Exception e) {
				
				JOptionPane.showMessageDialog(telaFuncionarioSwing, e.getMessage());
			}

		}
		
	}
	
	public void mostrarTelaFuncionario() {
		
		adicionarLabels();
		adicionarTabela();
		adicionarBotao();
	}
	
	
	private void adicionarBotao() {
		
		btnAdicionarMembro = new JButton("Registrar pagamento");
		btnRemoverMembro = new JButton("Discontar crédito");
		btnReceberVeiculo = new JButton("Receber Veículo");
		
		btnAdicionarMembro.setBounds(30, 300, 150, 50);
		btnRemoverMembro.setBounds(320, 300, 140, 50);
		btnReceberVeiculo.setBounds(180, 400, 140, 50);
		
		btnReceberVeiculo.setBackground(Color.GREEN);
		
		btnAdicionarMembro.addActionListener(new OuvinteDosBotoes());
		btnRemoverMembro.addActionListener(new OuvinteDosBotoes());
		btnReceberVeiculo.addActionListener(new OuvinteDosBotoes());
		
		add(btnAdicionarMembro);
		add(btnRemoverMembro);
		add(btnReceberVeiculo);
		
	}
	
	private void adicionarTabela() {
		
		super.adicionarTabela(controllerTelaFuncionario.getTodoOsRegistrosDePagamentoDoSistema());
	}
	
	private void adicionarLabels() {
		
		super.adicionarLabels("ESTACIONAMENTO");
		vagas = new JLabel();
		valor = new JLabel();
		
		vagas.setBounds(400, 400, 140, 50);
		valor.setBounds(20, 400, 140, 50);
		atualizarVagas();
		
		add(vagas);
		add(valor);
		
		valor.setVisible(false);
		
		
	}
		
	private void isSelecionado() throws Exception{
		
		if(getTabela().getSelectedRow() < 0) {
			
			throw new Exception("Selecione um registro");
		}
		
		
	}
	
	public void atualizarVagas() {
		
		try {
			vagas.setText(texto+controllerTelaFuncionario.getVagasDisponiveis());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void mostrarValor() {
		
		try {
			valor.setText(texto2+controllerTelaFuncionario.valorAPagar(getTabela().getSelectedRow()));
			valor.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void atualizarTabela() {
		
		super.atualizarTabela(controllerTelaFuncionario.getTodoOsRegistrosDePagamentoDoSistema()); 
	}
	
	
	
	public void preencherCampos() throws Exception{
		
		mostrarValor();
	}
		
	
	public void adicionar() {
		
		try {
			
			controllerTelaFuncionario.receberVeiculo(placa, matricula);
			
			atualizarTabela();
			
			JOptionPane.showMessageDialog(telaFuncionarioSwing, "Veículo entrou no estacionamento");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	public void remover() {
		
		String valor;
		try {
			valor = String.valueOf(controllerTelaFuncionario.valorAPagar(getTabela().getSelectedRow()));
			
			controllerTelaFuncionario.descontarDeCredito(matricula, valor, getTabela().getSelectedRow(), CPF);
			
			JOptionPane.showMessageDialog(telaFuncionarioSwing, "Desconto realizado");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(telaFuncionarioSwing, e.getMessage());
			e.printStackTrace();
		}
		atualizarTabela();

	}
	
	public void atualizar() {
		String valor;
		try {
			
			valor = String.valueOf(controllerTelaFuncionario.valorAPagar(getTabela().getSelectedRow()));
			controllerTelaFuncionario.registrarPagamento(String.valueOf(matricula), valor, getTabela().getSelectedRow());
			JOptionPane.showMessageDialog(telaFuncionarioSwing, "Pagamento realizado");
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(telaFuncionarioSwing, e.getMessage());
			e.printStackTrace();
		}
		
		atualizarTabela();
		
	}
	
}
