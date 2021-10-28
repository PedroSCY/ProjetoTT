package view.autenticacao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.autenticacao.ControllerTelaCriarConta;
import view.projetos.OuvinteFocoJTextField;
/**
 * 
 * @author NPG
 *
 * Essa classe é um produto concreto do padrão abstract factory
 * 
 */
public class TelaCriarContaSwing extends JPanel implements TelaCriarConta{

	
	private static final long serialVersionUID = 1L;

	private ControllerTelaCriarConta controllerTelaCriarConta;
	private JTextField nomeField, emailField;
	private JFormattedTextField matriculaField, cpfField;
	private JPasswordField passwordField;
	private Font fonteParaTextos = new Font("Arial", Font.PLAIN, 15);
	
	public class OuvinteBtnCadastrar implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if(nomeField.getText().isEmpty() || emailField.getText().isEmpty() || String.valueOf(passwordField.getPassword()).isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos", null, JOptionPane.WARNING_MESSAGE);
				
			}else if(matriculaField.getText().trim().length() < 9 ) {
				JOptionPane.showMessageDialog(null, "Matricula deve conter 9 digitos", null, JOptionPane.WARNING_MESSAGE);
			}else if(cpfField.getText().trim().length() < 11) {
				JOptionPane.showMessageDialog(null, "cpf deve conter 11 digitos", null, JOptionPane.WARNING_MESSAGE);
			}else {
				try {
					controllerTelaCriarConta.cadastrarConta(nomeField.getText(), Long.parseLong(matriculaField.getText()),
							emailField.getText(), String.valueOf(passwordField.getPassword()), cpfField.getText());
				
					JOptionPane.showMessageDialog(null, "Conta Cadastrada com Sucesso", null, JOptionPane.WARNING_MESSAGE);
					limparCampos();
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
	}
	
	
	public TelaCriarContaSwing() {
		controllerTelaCriarConta = new ControllerTelaCriarConta();
		adicionarPrincipaisConfiguracoes();
		addCamposDeEntradaTelaCriarConta();
		addLabelsTelaCriarConta();
		addBotoesTelaCriarConta();
		setVisible(true);
	}
	
	
	public void addCamposDeEntradaTelaCriarConta() {
		nomeField = new JTextField();
		nomeField.setToolTipText("digite o seu nome");
		nomeField.setBounds(150, 80, 200, 30);
		nomeField.addFocusListener(new OuvinteFocoJTextField(nomeField));
		add(nomeField);
		
		emailField = new JTextField();
		emailField.setToolTipText("exemplo@exemplo.com");
		emailField.setBounds(150,180, 200, 30);
		emailField.addFocusListener(new OuvinteFocoJTextField(emailField));
		add(emailField);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Sua senha");
		passwordField.setBounds(150, 280, 200, 30);
		passwordField.addFocusListener(new OuvinteFocoJTextField(passwordField));
		add(passwordField);
		
		try {
			
			MaskFormatter formatoMatriculaECodigo = new MaskFormatter("#########");
			MaskFormatter formatoCPF = new MaskFormatter("###########");
			matriculaField = new JFormattedTextField(formatoMatriculaECodigo);
			cpfField = new JFormattedTextField(formatoCPF);
			matriculaField.setToolTipText("000000000");
			cpfField.setToolTipText("00000000000");
			matriculaField.setBounds(150, 130, 200, 30);
			cpfField.setBounds(150, 230, 200, 30);
			add(matriculaField);
			add(cpfField);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addLabelsTelaCriarConta() {
		JLabel lblPrincipal = gerarLabel("CADASTRAR CONTA", 0, 35, 400, 30, JLabel.CENTER);
		lblPrincipal.setFont(new Font("Arial Narrow", Font.ITALIC, 23));
		add(lblPrincipal);
		
		add(gerarLabel("Nome:", 50, 80, 100, 30, JLabel.LEFT));
		add(gerarLabel("Matricula:", 50, 130, 100, 30, JLabel.LEFT));
		add(gerarLabel("E-mail:", 50, 180, 100, 30, JLabel.LEFT));
		add(gerarLabel("CPF:", 50, 230, 100, 30, JLabel.LEFT));
		add(gerarLabel("Senha:", 50, 280, 100, 30, JLabel.LEFT));
		add(gerarLabel("Já tem uma conta?", 40 , 370, 200, 30, JLabel.LEFT));
	}
	
	private JLabel gerarLabel(String texto, int x , int y, int width, int height, int alinhamento) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, width, height);
		label.setHorizontalAlignment(alinhamento);
		label.setFont(fonteParaTextos);
		return label;
	}
	
	public void addBotoesTelaCriarConta() {
		Font fontBotoesComuns = new Font("Arial", Font.PLAIN, 15);
		
		JButton btnCadastrar = gerarBotao("Cadastrar", 210, 320, 150, 30, fontBotoesComuns);
		btnCadastrar.addActionListener(new OuvinteBtnCadastrar());
		add(btnCadastrar);
		
	}

	private JButton gerarBotao(String texto, int x , int y, int width, int height, Font font) {
		JButton button = new JButton(texto);
		button.setBounds(x, y, width, height);
		button.setFont(font);
		return button;
	}
	private void adicionarPrincipaisConfiguracoes() {
		setSize(350,400);
		setLayout(null);
		this.setBounds(0, 0, 385, 490);	
	}
	
	public void limparCampos() {
		
		nomeField.setText(null);
		emailField.setText(null);
		passwordField.setText(null);
		cpfField.setText(null);
		matriculaField.setText(null);
	}
	

}
