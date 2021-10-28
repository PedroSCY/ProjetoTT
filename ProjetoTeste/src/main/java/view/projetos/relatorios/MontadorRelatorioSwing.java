package view.projetos.relatorios;

import java.awt.Color;
import java.awt.Font;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.entidades.RegistroPagamento;
import util.FactorySwingComponents;

/**
 * 
 * @author NPG
 * Esta classe eh de um montador concreto (monta relatorios em JPanels com barra de rolagem) na implementacao do padrao builder.
 */
public class MontadorRelatorioSwing implements InterfacePartesMontagem {

	private FactorySwingComponents factory = new FactorySwingComponents();
	private JPanel panel;
	
	private Font fonte = new Font("Arial", Font.PLAIN, 16);
	private Color color = new Color(230, 230, 230);
	
	
	public void gerarRelatorio( Set<RegistroPagamento> pagamentos) throws Exception {
		iniciar();
		
		for(RegistroPagamento pagamento : pagamentos) {
			
			panel.add(factory.gerarJPanelComLabel("Dados do Pagamento: " + pagamento.getId(), fonte, color));
			panel.add(factory.gerarJPanelComLabel("Data: " + pagamento.getData(), fonte, color));
			panel.add(factory.gerarJPanelComLabel("Funcionário: " + pagamento.getFuncionario().getNome(), fonte, color));
			panel.add(factory.gerarJPanelComLabel("Placa: " + pagamento.getPlacaVeiculo(), fonte, color));
			panel.add(factory.gerarJPanelComLabel("Valor Pago: " + pagamento.getValorPago(), fonte, color));
		
		}
	}

	public JScrollPane encerrar() {
		JScrollPane scrollPane = new JScrollPane(panel);
		return scrollPane;
	}
	
	public void reiniciar() {
		panel = factory.gerarJPanel("Relatório de Registros de Pagamento", color);
	}
	
	public void iniciar() {
		FactorySwingComponents.gerarLookAndFeelNimbus();
		reiniciar();
		panel.setSize(550, 450);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	}
	
	public void mostrarProduto() {
		try {			
			JFrame frame = new JFrame();
			FactorySwingComponents.gerarLookAndFeelNimbus();
			frame.setTitle("Relatório Final");
			frame.setSize(500, 600);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.add((JScrollPane) new JScrollPane(panel));
			frame.setVisible(true);		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
