package util;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class FactorySwingComponents {
	public JPanel gerarJPanel(String titleBorder, Color color) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder(titleBorder));
		panel.setBackground(color);
		
		return panel;
	}
	
	public JPanel gerarJPanelComLabel(String texto, Font font, Color color) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(color);
		JLabel label = new JLabel(texto);
		label.setFont(font);
		label.setForeground(Color.BLACK);
		panel.add(label);
		return panel;
	}
	
	public JPanel gerarLabelIsAtivo(boolean isAtivo, Font font) {
		JPanel pnlIsAtivo = null;
		if(isAtivo)
			pnlIsAtivo = gerarJPanelComLabel("Este item está ativo!", font, new Color(111, 111, 255));
		else
			pnlIsAtivo = gerarJPanelComLabel("Este item não está ativo!", font, new Color(255, 70, 70));
		return pnlIsAtivo;
	}
	
	public static void gerarLookAndFeelNimbus() {
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
	}
}
