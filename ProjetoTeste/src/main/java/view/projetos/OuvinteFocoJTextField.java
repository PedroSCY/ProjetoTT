package view.projetos;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 * @author NPG
 *
 */
public class OuvinteFocoJTextField implements FocusListener {
	
	private JComponent componente;
	
	public OuvinteFocoJTextField(JComponent comp) {
		this.componente = comp;
	}
	
	public void focusGained(FocusEvent arg0) {
		JTextField tfd = (JTextField) componente;
		tfd.setBackground(Color.WHITE); // Ao se ganhar o foco, o fundo do textField fica branco
	}
	
	public void focusLost(FocusEvent e) {
		JTextField tfd = (JTextField) componente;
		
		if (tfd.getText().isEmpty())
			tfd.setBackground(Color.RED); // Foco perdido sem conteudo: vermelho
		else
			tfd.setBackground(Color.GREEN); // Foco perdido com conteudo: verde
	}
	
}
