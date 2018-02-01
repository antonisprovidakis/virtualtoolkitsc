package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.Button;
import java.util.ArrayList;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;

public class AWTButton extends AWTComponent implements VirtualButton {

	private ArrayList<VirtualActionListener> vActionListeners = new ArrayList<VirtualActionListener>();

	public AWTButton(Button button) {
		super(button);
	}

	@Override
	protected void init() {
		super.init();
		getButton().addActionListener(new AWTButtonEventForwarder(this));
	}

	public Button getButton() {
		return (Button) component;
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
		getButton().setLabel(text);
	}

	@Override
	public String getText() {
		return getButton().getLabel();
	}

	@Override
	public void addStyleName(String name) {
	}

	@Override
	public void removeStyleName(String name) {
	}

}
