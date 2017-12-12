package gr.istl.virtualtoolkitsc.widgets.swing;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;
import gr.istl.virtualtoolkitsc.widgets.VirtualComponent;
import gr.istl.virtualtoolkitsc.widgets.VirtualFrame;
import gr.istl.virtualtoolkitsc.widgets.VirtualLayout;

public class SwingFrame extends JFrame implements VirtualFrame {

	public SwingFrame() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public SwingFrame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
