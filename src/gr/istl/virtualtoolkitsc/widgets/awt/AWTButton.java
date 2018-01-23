package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.Button;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

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
		String oldValue = getText();
		getButton().setLabel(text);
		VirtualToolkit.notifyPropertyChangeListeners(getUniversalWidgetId(), "text", oldValue, text);
	}

	@Override
	public String getText() {
		return getButton().getLabel();
	}

	@Override
	public boolean isPressed() {
		// TODO: implement
		return false;
	}

	@Override
	public void setPressed(boolean pressed) {
		// TODO: implement
	}

	@Override
	public void addStyleName(String name) {
	}

	@Override
	public void removeStyleName(String name) {
	}

	@Override
	public void setIsCollaborativeText(boolean collab) {
		final String propertyName = "text";

		if (collab && VirtualToolkit.isCollaborative()) {
			VirtualToolkit.startMonitoringChanges(getUniversalWidgetId(), propertyName);
		} else {
			VirtualToolkit.stopMonitoringChanges(getUniversalWidgetId(), propertyName);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		if (VirtualToolkit.isCollaborative()) {
			VirtualToolkit.updateFirebase(getUniversalWidgetId(), e.getPropertyName(), e.getOldValue(),
					e.getNewValue());
		}
	}

	@Override
	public void updateLocalUI(String propertyName, Object newValue) {
		switch (propertyName) {
		case "text":
			setText((String) newValue);
			break;
		default:
			break;
		}
	}

}
