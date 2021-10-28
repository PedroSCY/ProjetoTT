package view.projetos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import controller.projetos.ControllerTelaPrincipal;
import view.autenticacao.TelaCadastroEstacionamento;
/**
 * 
 * @author NPG
 * 
 * Essa é a tela principal do projeto, que ficará visível apenas para um membro
 * administrador, possibilitando o cadastro de membros, grupos, editais e projetos.
 * No entanto, a equipe descidiu possibilitar a qualquer usuário a possibilidade
 * dele criar um projeto caso ele queira, sem necessariamente ele ser um administrador,
 * dessa forma posiibilitando a esse usuário acesso a uma parte da tela principal.
 *
 */
public class TelaPrincipal extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ControllerTelaPrincipal controllerTelaPrincipal;
	private TelaPrincipal telaPrincipal = this;
	private JButton btnFazerLogoff,btnAtualizarEstacionamento, btnCadastrarEdital, btnCadastrarProjeto, btnCadastrarGrupo, btnVoltar, btnAdicionar, btnRemover, btnAtualizar;
	private FabricaTela fabricaTela;
	private TelaCRUDFuncionario telaCRUDFuncionario;
	private TelaFuncionario telaFuncionario;
	private TelaCRUDClientesMensalistas telaCRUDClientesMensalistas;
	private boolean isAdmin;
	
	public TelaPrincipal() {
		controllerTelaPrincipal = new ControllerTelaPrincipal(telaPrincipal);
		adicionarConfiguracoesBasicas();
		adicionarBotoes();
		setVisible(true);
	}
	
	public class OuvinteFazerLogoff implements ActionListener {
		
		public void actionPerformed(ActionEvent evento) {
			controllerTelaPrincipal.fazerLogoff();
	
		}
	}
	
	public class OuvinteAdicionar implements ActionListener {
		
		public void actionPerformed(ActionEvent evento) {
			
			if(telaCRUDFuncionario != null) {
				
				telaCRUDFuncionario.adicionar();

			
			}else if(telaFuncionario != null) {
				
				telaFuncionario.adicionar();
				
			}else {
				
				telaCRUDClientesMensalistas.adicionar();
			}
		}
	}
	
	public class OuvinteRemover implements ActionListener{
		
		public void actionPerformed(ActionEvent evento) {
			
			if(telaCRUDFuncionario != null) {
				
				telaCRUDFuncionario.remover();
			
			}else if(telaFuncionario != null) {
				
				telaFuncionario.remover();
				
			}else {
				
				telaCRUDClientesMensalistas.remover();
			}
			
		}
	}
	
	public class OuvinteAtualizar implements ActionListener{
		
		public void actionPerformed(ActionEvent evento) {
			
			if(telaCRUDFuncionario != null) {
				
				telaCRUDFuncionario.atualizar();
			
			}else if(telaFuncionario != null) {
				
				telaFuncionario.atualizar();
				
			}else {
				
				telaCRUDClientesMensalistas.atualizar();
			}
			
			
			
		}
	}
	
	
	public class OuvinteDosBotoes implements ActionListener{

		public void actionPerformed(ActionEvent evento) {

			if(evento.getActionCommand().equals("VOLTAR")) {
				
				if(!isAdmin) {
					
					telaPrincipal.dispose();
					controllerTelaPrincipal.fazerLogoff();
					
				}else {
					modificarTamanho(300, 450);
					mostrarBotoes(true, false, false);
	
					if(telaCRUDFuncionario != null) {
						removerJPanel(telaCRUDFuncionario);
						
					} else if(telaFuncionario != null) {
						removerJPanel(telaFuncionario);
						
					} else if(telaCRUDClientesMensalistas != null) {	
						removerJPanel(telaCRUDClientesMensalistas);
					}
				}
				
			} else {

				fabricaTela = new FabricaTelaSwing();
				
				if(evento.getActionCommand().equals("GERENCIAR FUNCIONARIO")) {
					
					telaCRUDFuncionario = (fabricaTela.fabricarTelaCRUDFuncionarios());
					telaCRUDFuncionario.mostrarFuncionarios();
					
					adicionarJPanel(telaCRUDFuncionario);
					mostrarBotoes(false, true, true);
					
					
				} else if(evento.getActionCommand().equals("GERENCIAR CLIENTE")){
					
					telaCRUDClientesMensalistas = fabricaTela.fabricarTelaCRUDClientesMensalistas();
					telaCRUDClientesMensalistas.mostrarClientes();
					
					adicionarJPanel(telaCRUDClientesMensalistas);
					mostrarBotoes(false, true, true);
					
					
				} else if(evento.getActionCommand().equals("ESTACIONAMENTO")){
					
					criarTelaCadastroProjetos();
					
					
					
				}else if(evento.getActionCommand().equals("ATUALIZAR ESTACIONAMENTO")){
					
					telaPrincipal.dispose();
					new TelaCadastroEstacionamento();
				}

				modificarTamanho(600, 700);

			}
		}
	}
	
	public void validarAdminGerente(boolean isAdmin) {
		
		this.isAdmin = isAdmin;
		
		if(!isAdmin) {
			criarTelaCadastroProjetos();
//			mostrarBotoes(false, false, true);
		}
		
		setVisible(true);	
	}
	
	private void criarTelaCadastroProjetos() {
		
		fabricaTela = new FabricaTelaSwing();
		telaFuncionario = fabricaTela.fabricarTelaFuncionario();
		telaFuncionario.mostrarTelaFuncionario();
		
		adicionarJPanel(telaFuncionario);
		
		modificarTamanho(600, 700);
		mostrarBotoes(false, false, true);
		
	}
	
	private void adicionarBotoes() {
		
		btnCadastrarEdital = new JButton("GERENCIAR FUNCIONARIO");
		btnCadastrarProjeto = new JButton("GERENCIAR CLIENTE");
		btnCadastrarGrupo = new JButton("ESTACIONAMENTO");
//		btnGerenciarMembro = new JButton("GERENCIAR MEMBRO");
		btnFazerLogoff = new JButton("Fazer Logoff");
		btnAtualizarEstacionamento = new JButton("ATUALIZAR ESTACIONAMENTO");
		btnVoltar = new JButton("VOLTAR");
		btnAdicionar = new JButton("ADICIONAR");
		btnRemover = new JButton("REMOVER");
		btnAtualizar = new JButton("ATUALIZAR");
		
		btnCadastrarEdital.setBounds(50, 50, 190, 50);
		btnCadastrarProjeto.setBounds(60, 130, 170, 50);
		btnCadastrarGrupo.setBounds(60, 210, 170, 50);
//		btnGerenciarMembro.setBounds(60, 290, 170, 50);
		btnFazerLogoff.setBounds(160, 375, 120, 30);
		btnAtualizarEstacionamento.setBounds(40, 290, 210, 50);
		btnVoltar.setBounds(440,590,90,35);
		btnAdicionar.setBounds(50,590,100,35);
		btnRemover.setBounds(180,590,100,35);
		btnAtualizar.setBounds(310,590,100,35);
		
		btnCadastrarEdital.addActionListener(new OuvinteDosBotoes());
		btnCadastrarProjeto.addActionListener(new OuvinteDosBotoes());
		btnCadastrarGrupo.addActionListener(new OuvinteDosBotoes());
//		btnGerenciarMembro.addActionListener(new OuvinteGerenciarMembro());
		btnFazerLogoff.addActionListener(new OuvinteFazerLogoff());
		btnAtualizarEstacionamento.addActionListener(new OuvinteDosBotoes());
		btnVoltar.addActionListener(new OuvinteDosBotoes());
		btnAdicionar.addActionListener(new OuvinteAdicionar());
		btnRemover.addActionListener(new OuvinteRemover());
		btnAtualizar.addActionListener(new OuvinteAtualizar());
		
		add(btnCadastrarEdital);
		add(btnCadastrarProjeto);
		add(btnCadastrarGrupo);
		add(btnAtualizarEstacionamento);
		add(btnFazerLogoff);
		add(btnVoltar);
		add(btnAdicionar);
		add(btnRemover);
		add(btnAtualizar);
//		add(btnBaterPonto);
		
		btnVoltar.setVisible(false);
		btnAdicionar.setVisible(false);
		btnRemover.setVisible(false);
		btnAtualizar.setVisible(false);
	}
	
	private void mostrarBotoes(boolean primarios, boolean secundarios, boolean voltar) {
		
		btnCadastrarEdital.setVisible(primarios);
		btnCadastrarProjeto.setVisible(primarios);
		btnCadastrarGrupo.setVisible(primarios);
		btnFazerLogoff.setVisible(primarios);
		btnAtualizarEstacionamento.setVisible(primarios);
		
		btnAdicionar.setVisible(secundarios);
		btnRemover.setVisible(secundarios);
		btnAtualizar.setVisible(secundarios);
		
		btnVoltar.setVisible(voltar);
	}
	
	private void modificarTamanho(int x, int y) {
		
		setSize(x, y);
		setLocationRelativeTo(null);
	}
	
	private void adicionarJPanel(Object jpanel) {
		
		add((JPanel)jpanel);
	}
	
	private void removerJPanel(Object jpanel) {
		
		this.remove((JPanel)jpanel);
		telaCRUDFuncionario = null;
		telaFuncionario = null;
		telaCRUDClientesMensalistas = null;
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
		
		modificarTamanho(300, 450);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.DARK_GRAY);
	}
	
		
}
