package gr.istl.virtualtoolkitsc.widgets.swing;

import javax.swing.JPanel;

import gr.istl.virtualtoolkitsc.widgets.PanelFactory;
import gr.istl.virtualtoolkitsc.widgets.VirtualContainer;

public class SwingPanelFactory implements PanelFactory {

	@Override
	public VirtualContainer createPanel() {
		JPanel panel = new JPanel();
		return new SwingPanel(panel);
	}

}
