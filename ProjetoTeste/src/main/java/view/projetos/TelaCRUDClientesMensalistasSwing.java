package view.projetos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.projetos.ControllerTelaCRUDClientesMensalistas;

/**
 * 
 * @author NPG
 *
 *Essa classe é um produto concreto do padrão abstract factory
 *
 */
public class TelaCRUDClientesMensalistasSwing extends JPanelTelaCadastroSwing implements TelaCRUDClientesMensalistas {

	private static final long serialVersionUID = 1L;
	private ControllerTelaCRUDClientesMensalistas controllerTelaCRUDClientesMensalistas;
	private JTextField campoCredito;
	
	public TelaCRUDClientesMensalistasSwing() {
		
		controllerTelaCRUDClientesMensalistas = new ControllerTelaCRUDClientesMensalistas();
	}
	
	public class OuvintBtnAddCredito implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			String resposta = JOptionPane.showInputDialog(null, "INFORME O VALOR");
		
			
			if(resposta != null ) {
				
				if(JOptionPane.showConfirmDialog(null, "O valor está correto? ") == 0 ) {
					 try {
						controllerTelaCRUDClientesMensalistas.adicionarCredito(getTabela().getSelectedRow(), resposta);
						preencherCampos();
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
						e1.printStackTrace();
					}
				}
				
			}
			
		}
		
	}

	public void mostrarClientes() {
		
		adicionarLabels();
		adicionarTabela();
		adicionarCampos();
		adicionarBotoes();
	}
	


	private void adicionarCampos() {
		
		super.adicionarCampos("Informe a matricula ");
		super.adicionarCamposSenhas();
		
		campoCredito = new JTextField();
		campoCredito.setBounds(70, 400, 150, 25);
		campoCredito.setEditable(false);

		add(campoCredito);
		
		
	}
	
	private void adicionarTabela() {
		
		super.adicionarTabela(controllerTelaCRUDClientesMensalistas.getTodoOsClientesMensalistasDoSistema());
		
	}
	
	private void adicionarLabels() {
		
		super.adicionarLabels("CLIENTES");
		super.addLabels();
		
		JLabel matricula = new JLabel("Créditos");
		matricula.setBounds(10, 400, 80, 20);
		add(matricula);

	}
	private void adicionarBotoes() {

		JButton btnAddCredito = new JButton("Adicionar Crédito");
		
		btnAddCredito.setBounds(300, 400, 150, 25);
		btnAddCredito.addActionListener(new OuvintBtnAddCredito());
		
		add(btnAddCredito);
	}
	
	private void atualizarTabela() {
		
		super.atualizarTabela(controllerTelaCRUDClientesMensalistas.getTodoOsClientesMensalistasDoSistema()); 
	}
	
	public void preencherCampos() throws Exception{

		String[] campos = controllerTelaCRUDClientesMensalistas.getCamposParaPreencher(super.getTabela().getSelectedRow());

		super.getCampoNome().setText(campos[0]);
		super.getCampoEmail().setText(campos[1]);
		super.getCampoSenha().setText(campos[2]);
		super.getCampoCPF().setText(campos[3]);
		campoCredito.setText(campos[4]);

	}	
	
	public void limparCampos() {
		
		campoCredito.setText(null);
		super.getCampoNome().setText(null);
		super.getCampoEmail().setText(null);
		super.getCampoSenha().setText(null);
		super.getCampoCPF().setText(null);
	}
	
	public void adicionar() {
		
		try {
			
			controllerTelaCRUDClientesMensalistas.adicionarNovoClienteMensalista(getCampoNome().getText(),
					getCampoEmail().getText(), getCampoSenha().getText(), getCampoCPF().getText());
		
			atualizarTabela();
			
		}catch (Exception e) {
			
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		limparCampos();
	}
	
	public void remover() {
		
		try {
			
			controllerTelaCRUDClientesMensalistas.removerClienteMensalistaExistente(super.getTabela().getSelectedRow());
		
			atualizarTabela();
			
		}catch (Exception e) {
			
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	public void atualizar() {
		
		try {
			
			controllerTelaCRUDClientesMensalistas.atualizarClienteMensalistaExistente(getCampoNome().getText(),
					getCampoEmail().getText(), getCampoSenha().getText(), getCampoCPF().getText(), getTabela().getSelectedRow());
			
			atualizarTabela();
			
		}catch (Exception e) {
			
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		limparCampos();
	}

}
