package gr.istl.virtualtoolkitsc.widgets.swing;

import gr.istl.virtualtoolkitsc.widgets.PanelFactory;
import gr.istl.virtualtoolkitsc.widgets.VirtualContainer;
import gr.istl.virtualtoolkitsc.widgets.VirtualPanel;

public class SwingPanelFactory implements PanelFactory {

	@Override
	public VirtualPanel createPanel() {
		return new SwingPanel();
	}

}
