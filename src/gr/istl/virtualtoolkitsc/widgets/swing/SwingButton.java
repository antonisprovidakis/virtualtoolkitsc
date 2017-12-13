package gr.istl.virtualtoolkitsc.widgets.swing;

import java.util.ArrayList;

import javax.swing.AbstractButton;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;

public class SwingButton extends SwingComponent implements VirtualButton {

	private ArrayList<VirtualActionListener> vActionListeners = new ArrayList<VirtualActionListener>();

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
	public ArrayList<VirtualActionListener> getVirtualActionListeners() {
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
	
	@Override
	public boolean isPressed() {
		return getButton().getModel().isPressed();
	}
	
	@Override
	public void setPressed(boolean pressed) {
		getButton().getModel().setPressed(pressed);
	}

	@Override
	public void addStyleName(String name) {
	}

	@Override
	public void removeStyleName(String name) {
	}
}
