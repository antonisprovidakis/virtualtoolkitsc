package gr.istl.virtualtoolkitsc.widgets.swing;

import java.util.Set;

import javax.swing.JButton;

import com.google.gwt.dev.util.collect.HashSet;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;

public class SwingButton extends JButton implements VirtualButton {

	Set<VirtualActionListener> vActionListeners = new HashSet<VirtualActionListener>();

	public SwingButton() {
		super();
		init();
	}

	public SwingButton(String text) {
		super(text);
		init();
	}

	private void init() {
		super.addActionListener(new SwingButtonEventForwarder(this));
	}
	
	@Override
	public Set<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
	}

	@Override
	public void addMouseListener(VirtualMouseListener listener) {
		// super.addMouseListener((MouseListener) listener);
	}

	@Override
	public void addActionListener(VirtualActionListener listener) {
		vActionListeners.add(listener);
	}

}
