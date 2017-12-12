package gr.istl.virtualtoolkitsc.widgets.swing;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;
import gr.istl.virtualtoolkitsc.widgets.VirtualComponent;
import gr.istl.virtualtoolkitsc.widgets.VirtualLayout;
import gr.istl.virtualtoolkitsc.widgets.VirtualPanel;

public class SwingPanel extends JPanel implements VirtualPanel {

	public SwingPanel() {
		super();
	}

	@Override
	public void add(VirtualComponent c) {
		super.add((Component) c);
	}


	@Override
	public void setLayout(VirtualLayout layout) {
		super.setLayout((LayoutManager) layout);
	}

	@Override
	public void addMouseListener(VirtualMouseListener listener) {
		// TODO: implement using a set (check VirtualActionListeners set)
	}
	

}
