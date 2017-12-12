package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.Container;
import java.awt.Panel;

import gr.istl.virtualtoolkitsc.widgets.PanelFactory;
import gr.istl.virtualtoolkitsc.widgets.VirtualContainer;

public class AWTPanelFactory implements PanelFactory {

	@Override
	public VirtualContainer createPanel() {
		Container panel = new Panel();
		return new AWTContainer(panel);
	}

}
