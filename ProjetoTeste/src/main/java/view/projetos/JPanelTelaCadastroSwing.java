package view.projetos;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import model.entidades.Pessoa;
//import model.projetos.ItemProjeto;
import model.entidades.RegistroPagamento;

/**
 * 
 * @author NPG
 *
 * Essa classe é o supertipo padronizador, utilizado pelas outras classes concretas,
 * que são produtos concretos do padrão abstract factory
 * 
 */

public abstract class JPanelTelaCadastroSwing extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField campoNome, campoEmail, campoSenha;
	private JFormattedTextField campoCPF;
	private JTable tabela;
	private JScrollPane tabelaJScrollPane;
	private JPanelTelaCadastroSwing jPanelTelaCadastroSwing;
	
	public JPanelTelaCadastroSwing() {
		
		adicionarPrincipaisConfiguracoes();
		
	}
	
	public class OuvinteDoMouse implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			
			try {
				
				preencherCampos();
				
			}catch (Exception excessao) {
				
				JOptionPane.showMessageDialog(jPanelTelaCadastroSwing, excessao.getMessage());
			}
			
		}

		public void mouseEntered(MouseEvent e) {}

		public void mouseExited(MouseEvent e) {}

		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
		
	}
	
	private void adicionarPrincipaisConfiguracoes() {
		setSize(500, 600);
		setLayout(null);
		this.setBounds(45, 50, 495, 510);
	}
	
	public void adicionarTabela(Pessoa[] pessoas) {	
		
		tabelaJScrollPane = new JScrollPane(criarTabela(pessoas));
		tabelaJScrollPane.setBounds(0, 60, 495, 200);
		
		add(tabelaJScrollPane);
		
	}
	
	public void adicionarTabela(RegistroPagamento[] pagamentos) {	
		
		tabelaJScrollPane = new JScrollPane(criarTabela(pagamentos));
		tabelaJScrollPane.setBounds(0, 60, 495, 200);
		
		add(tabelaJScrollPane);
		
	}
	
	private JTable criarTabela(Pessoa[] pessoas) {
		
		DefaultTableModel modeloDaTabela = new DefaultTableModel();
		
		modeloDaTabela.addColumn("CPF");
		modeloDaTabela.addColumn("Nome");
//		modeloDaTabela.addColumn("Situação");
		
		
		for(Pessoa pessoa : pessoas) {
			
//			String situacao = "ATIVO";
//
//			if(!itemProjeto.isAtivo()) {
//				situacao = "FINALIZADO";
//			}
			
			Object[] linha = new Object[] {pessoa.getCpf(),pessoa.getNome()};
			
			modeloDaTabela.addRow(linha);
		}
		tabela = new JTable(modeloDaTabela);
		tabela.addMouseListener(new OuvinteDoMouse());
		
		return tabela;	
	}
	
	private JTable criarTabela(RegistroPagamento[] pagamentos) {
		
		DefaultTableModel modeloDaTabela = new DefaultTableModel();
		
		modeloDaTabela.addColumn("Placa");
		modeloDaTabela.addColumn("CPF Funcionário");
//		modeloDaTabela.addColumn("Situação");
		
		
		for(RegistroPagamento pagamento : pagamentos) {
			
			if(pagamento.isNoEstacionamento()) {

				Object[] linha = new Object[] {pagamento.getPlacaVeiculo(),pagamento.getFuncionario().getCpf()};
				
				modeloDaTabela.addRow(linha);
				
			}
			
			
		}
		tabela = new JTable(modeloDaTabela);
		tabela.addMouseListener(new OuvinteDoMouse());
		
		return tabela;	
	}
	
	public void adicionarCampos(String textoInformativoDaMatricula) {
		try {
			
			campoNome = new JTextField();
			campoEmail = new JTextField();
			campoSenha = new JTextField();
//			campoCPF = new JTextField();
			
			
			campoNome.setBounds(50, 280, 400, 25);
			campoEmail.setBounds(50, 305, 400, 25);
			campoSenha.setBounds(50, 330, 400, 25);
//			campoCPF.setBounds(50, 355, 400, 25);
			
			add(campoNome);
			add(campoEmail);
			add(campoSenha);
//			add(campoCPF);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void adicionarCamposSenhas() {
		
		try {
			
			MaskFormatter formatoCPF = new MaskFormatter("###########");
			
			campoCPF = new JFormattedTextField(formatoCPF);
			campoCPF = new JFormattedTextField(formatoCPF);
			
			campoCPF.setBounds(50, 355, 400, 25);
			
			add(campoCPF);
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void adicionarLabels(String tituloDoTitulo) {
		
		JLabel titulo = new JLabel(tituloDoTitulo);
		titulo.setBounds(180, 10, 140, 30);
		
		titulo.setFont(new Font("Arial", Font.PLAIN, 15));
		
		add(titulo);
	}
	
	public void addLabels() {
		
		JLabel nome = new JLabel("Nome");
		JLabel email = new JLabel("Email");
		JLabel senha = new JLabel("Senha");
		JLabel cpf = new JLabel("CPF");
		
		nome.setBounds(10, 280, 80, 20);
		email.setBounds(10, 305, 80, 20);
		senha.setBounds(10, 330, 80, 20);
		cpf.setBounds(10, 355, 80, 20);
		
		add(nome);
		add(email);
		add(senha);
		add(cpf);
	}
	
	public void atualizarTabela(Pessoa[] pessoas) {
		
		remove(tabelaJScrollPane);
		adicionarTabela(pessoas);
	}
	
	public void atualizarTabela(RegistroPagamento[] pagamentos) {
		
		remove(tabelaJScrollPane);
		adicionarTabela(pagamentos);
	}
	
	public abstract void preencherCampos() throws Exception;
		
	
	public JTable getTabela() {
		return tabela;
	}

	public JTextField getCampoNome() {
		return campoNome;
	}

	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public JTextField getCampoSenha() {
		return campoSenha;
	}

	public JFormattedTextField getCampoCPF() {
		return campoCPF;
	}
	
	
	
	
	
	
	
}
