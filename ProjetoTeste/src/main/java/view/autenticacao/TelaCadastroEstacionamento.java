package view.autenticacao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import controller.autenticacao.ControllerTelaCadastroEstacionamento;
import view.projetos.OuvinteFocoJTextField;

public class TelaCadastroEstacionamento extends JFrame{

	private ControllerTelaCadastroEstacionamento controllerTelaCadastroEstacionamento;
	private JTextField valorField, taxaField, cnpjField, nomeAgenciaField, numeroAgenciaField, numeroField, variacaoField, vagasField;
	private Font fonteParaTextos = new Font("Arial", Font.PLAIN, 15);
	private TelaCadastroEstacionamento telaCadastroEstacionamento = this;
	
	public TelaCadastroEstacionamento() {
		
		controllerTelaCadastroEstacionamento = new ControllerTelaCadastroEstacionamento();
		adicionarConfiguracoesBasicas();
		addCamposDeEntradaTelaCadastroEstacionamento();
		addLabelsTelaCadastroEstacionamento();
		addBotoesTelaCadastroEstacionamento();
		preencherCampos();
		setVisible(true);
	}
	
	public class OuvinteCadastrar implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				controllerTelaCadastroEstacionamento.cadastrarInformacoes(valorField.getText(), taxaField.getText(),
						cnpjField.getText(), nomeAgenciaField.getText(), numeroAgenciaField.getText(),
						numeroField.getText(), variacaoField.getText(), vagasField.getText());
				
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
				
				telaCadastroEstacionamento.dispose();
				controllerTelaCadastroEstacionamento.proximaTela();
				
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}

		}
		
	}
	
	private void adicionarConfiguracoesBasicas() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setSize(400,500);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		getContentPane().setBackground(Color.GREEN);
	}
	
	private void addCamposDeEntradaTelaCadastroEstacionamento() {
		valorField = new JTextField();
		valorField.setBounds(150, 70, 200, 30);
		valorField.addFocusListener(new OuvinteFocoJTextField(valorField));
		add(valorField);
		
		taxaField = new JTextField();
		taxaField.setBounds(150,110, 200, 30);
		taxaField.addFocusListener(new OuvinteFocoJTextField(taxaField));
		add(taxaField);
		
		cnpjField = new JTextField();
		cnpjField.setBounds(150,150, 200, 30);
		cnpjField.addFocusListener(new OuvinteFocoJTextField(cnpjField));
		add(cnpjField);
		
		nomeAgenciaField = new JTextField();
		nomeAgenciaField.setBounds(170,190, 180, 30);
		nomeAgenciaField.addFocusListener(new OuvinteFocoJTextField(nomeAgenciaField));
		add(nomeAgenciaField);
		
		numeroAgenciaField = new JTextField();
		numeroAgenciaField.setBounds(170,230, 180, 30);
		numeroAgenciaField.addFocusListener(new OuvinteFocoJTextField(numeroAgenciaField));
		add(numeroAgenciaField);
		
		numeroField = new JTextField();
		numeroField.setBounds(150,270, 200, 30);
		numeroField.addFocusListener(new OuvinteFocoJTextField(numeroField));
		add(numeroField);
		
		variacaoField = new JTextField();
		variacaoField.setBounds(150,310, 200, 30);
		variacaoField.addFocusListener(new OuvinteFocoJTextField(variacaoField));
		add(variacaoField);
		
		vagasField = new JTextField();
		vagasField.setBounds(150,350, 200, 30);
		vagasField.addFocusListener(new OuvinteFocoJTextField(vagasField));
		add(vagasField);
		
	}

	private void addLabelsTelaCadastroEstacionamento() {
		JLabel lblPrincipal = gerarLabel("ESTACIONAMENTO", 0, 25, 400, 30, JLabel.CENTER);
		lblPrincipal.setFont(new Font("Arial Narrow", Font.ITALIC, 23));
		add(lblPrincipal);
		
		add(gerarLabel("Valor/Vaga:", 50, 70, 100, 30, JLabel.LEFT));
		add(gerarLabel("Taxa:", 50, 110, 100, 30, JLabel.LEFT));
		add(gerarLabel("CNPJ:", 50, 150, 100, 30, JLabel.LEFT));
		add(gerarLabel("Nome Agencia:", 50, 190, 100, 30, JLabel.LEFT));
		add(gerarLabel("Número Agencia:", 50, 230, 130, 30, JLabel.LEFT));
		add(gerarLabel("Número:", 50, 270, 100, 30, JLabel.LEFT));
		add(gerarLabel("Variação:", 50, 310, 100, 30, JLabel.LEFT));
		add(gerarLabel("Vagas:", 50, 350, 100, 30, JLabel.LEFT));
//		add(gerarLabel("Já tem uma conta?", 40 , 370, 200, 30, JLabel.LEFT));
	}
	
	private JLabel gerarLabel(String texto, int x , int y, int width, int height, int alinhamento) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, width, height);
		label.setHorizontalAlignment(alinhamento);
		label.setFont(fonteParaTextos);
		return label;
	}
	
	private void addBotoesTelaCadastroEstacionamento() {
		Font fontBotoesComuns = new Font("Arial", Font.PLAIN, 15);
		
		JButton btnCadastrar = gerarBotao("Cadastrar", 130, 400, 150, 30, fontBotoesComuns);
		btnCadastrar.addActionListener(new OuvinteCadastrar());
		add(btnCadastrar);
		
	}

	private JButton gerarBotao(String texto, int x , int y, int width, int height, Font font) {
		JButton button = new JButton(texto);
		button.setBounds(x, y, width, height);
		button.setFont(font);
		return button;
	}
	
	private void preencherCampos() {
		
		String[] informacoes = controllerTelaCadastroEstacionamento.preencherCampos();
		
		valorField.setText(informacoes[0]);
		taxaField.setText(informacoes[1]);
		cnpjField.setText(informacoes[2]);
		nomeAgenciaField.setText(informacoes[3]);
		numeroAgenciaField.setText(informacoes[4]);
		numeroField.setText(informacoes[5]);
		variacaoField.setText(informacoes[6]);
		vagasField.setText(informacoes[7]);
		
	}
	
	
}
