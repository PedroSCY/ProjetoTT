package view.projetos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import controller.projetos.ControllerTelaCRUDFuncionarios;

/**
 * 
 * @author NPG
 * 
 * Essa classe é um produto concreto do padrão abstract factory
 *
 */
public class TelaCRUDFuncionarioSwing extends JPanelTelaCadastroSwing implements TelaCRUDFuncionario{

	private static final long serialVersionUID = 1L;
	private JFormattedTextField campoMatricula;
	
	private ControllerTelaCRUDFuncionarios controllerTelaCRUDFuncionarios;
	
	public TelaCRUDFuncionarioSwing() {	
		controllerTelaCRUDFuncionarios = new ControllerTelaCRUDFuncionarios();
	}
	
	public class OuvinteDoBotaoGerarRelatorio implements ActionListener{

		public void actionPerformed(ActionEvent evento) {
			
			try {
				
				String data = JOptionPane.showInputDialog(null,"Informe a Data");
				
				if(evento.getActionCommand().equals("Gerar Relatório Diário")) {
					
					controllerTelaCRUDFuncionarios.gerarRelatorioDiario(data);
				
				}else {
					
					controllerTelaCRUDFuncionarios.gerarRelatorioMensal(data);
				}
				
				
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			

		}
	}

	public void mostrarFuncionarios() {
		
		adicionarLabels();	
		adicionarTabela();
		adicionarCampos();
		adicionarBotao();
	}
	
	private void adicionarBotao() {
		JButton btnDetalhesHTML = new JButton("Gerar Relatório Diário");
		JButton btnDetalhesSwing = new JButton("Gerar relatório mensal");
		
		btnDetalhesHTML.setBounds(150, 420, 215, 30);
		btnDetalhesSwing.setBounds(150, 460, 215, 30);
		
		btnDetalhesHTML.addActionListener(new OuvinteDoBotaoGerarRelatorio());
		btnDetalhesSwing.addActionListener(new OuvinteDoBotaoGerarRelatorio());
		
		add(btnDetalhesHTML);
		add(btnDetalhesSwing);
	}
	
	private void adicionarCampos() {
		
		super.adicionarCamposSenhas();
		super.adicionarCampos("Informe a matricula ");
		
		MaskFormatter formatoMatricula;
		try {
			formatoMatricula = new MaskFormatter("#########");
			
			campoMatricula = new JFormattedTextField(formatoMatricula);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		campoMatricula.setBounds(70, 380, 380, 25);
		
		add(campoMatricula);

	}
	
	private void adicionarTabela() {
		
		super.adicionarTabela(controllerTelaCRUDFuncionarios.getTodoOsFuncionariosDoSistema());
		
	}

		
	private void adicionarLabels() {
		
		super.adicionarLabels("FUNCIONARIOS");
		super.addLabels();
		
		JLabel matricula = new JLabel("Matrícula");
		matricula.setBounds(10, 380, 80, 20);
		add(matricula);
		
	}
	
	private void atualizarTabela() {
		
		super.atualizarTabela(controllerTelaCRUDFuncionarios.getTodoOsFuncionariosDoSistema()); 
	}
	
	public void preencherCampos() throws Exception{
		
		String[] campos = controllerTelaCRUDFuncionarios.getCamposParaPreencher(getTabela().getSelectedRow());
//				
		campoMatricula.setText(campos[0]);
		super.getCampoNome().setText(campos[1]);
		super.getCampoEmail().setText(campos[2]);
		super.getCampoSenha().setText(campos[3]);
		super.getCampoCPF().setText(campos[4]);
		
	}
	
	public void limparCampos() {
		
		campoMatricula.setText(null);
		super.getCampoNome().setText(null);
		super.getCampoEmail().setText(null);
		super.getCampoSenha().setText(null);
		super.getCampoCPF().setText(null);
	}
	
	public void adicionar() {
		
		
		try {
			
			controllerTelaCRUDFuncionarios.adicionarNovoFuncionario(campoMatricula.getText(), getCampoNome().getText(),
					getCampoEmail().getText(), getCampoSenha().getText(), getCampoCPF().getText());
			
			atualizarTabela();
			
		}catch (Exception e) {
			
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		limparCampos();
	}
	
	public void remover() {
		
		try {
			
			controllerTelaCRUDFuncionarios.removerFuncionarioExistente(super.getTabela().getSelectedRow());
			
			atualizarTabela();
			
		}catch (Exception e) {
			
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}
	
	public void atualizar() {
		
		try {
			
			controllerTelaCRUDFuncionarios.atualizarFuncionarioExistente(campoMatricula.getText(), getCampoNome().getText(),
					getCampoEmail().getText(), getCampoSenha().getText(), getCampoCPF().getText(), getTabela().getSelectedRow());
			atualizarTabela();
			
		}catch (Exception e) {
			
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		limparCampos();
	}

	
}
