package gr.istl.virtualtoolkitsc.widgets.swing;

import java.util.Set;

import javax.swing.AbstractButton;

import com.google.gwt.dev.util.collect.HashSet;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;

public class SwingButton extends SwingComponent implements VirtualButton {

	private Set<VirtualActionListener> vActionListeners = new HashSet<VirtualActionListener>();

	public SwingButton(AbstractButton button) {
		super(button);
	}

	@Override
	protected void init() {
		super.init();
		getButton().addActionListener(new SwingButtonEventForwarder(this));
	}

	public AbstractButton getButton() {
		return (AbstractButton) component;
	}

	@Override
	public void addActionListener(VirtualActionListener listener) {
		vActionListeners.add(listener);
	}

	@Override
	public Set<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
	}

	@Override
	public void setText(String text) {
		getButton().setText(text);
	}

	@Override
	public String getText() {
		return getButton().getText();
	}
}
