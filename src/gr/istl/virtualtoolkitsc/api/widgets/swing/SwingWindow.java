package gr.istl.virtualtoolkitsc.api.widgets.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractWindow;

public class SwingWindow extends JFrame implements AbstractWindow {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7868610134885820389L;

	public SwingWindow() {
		super();
		setSize(500, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
//		setVisible(true);
	}
	
	@Override
	public void addPanel(AbstractFlowPanel panel) {
		add((JPanel) panel);
	}
	
	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
	}

}
