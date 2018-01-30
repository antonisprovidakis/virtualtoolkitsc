package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.Button;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public class AWTButton extends AWTComponent implements VirtualButton {

	public final static String TEXT_PROPERTY = "text";

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
		VirtualToolkit.notifyPropertyChangeListeners(getUniversalWidgetId(), TEXT_PROPERTY, oldValue, text);
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
	public boolean getIsCollaborativeText() {
		return VirtualToolkit.isPropertyMonitored(getUniversalWidgetId(), TEXT_PROPERTY);
	}

	@Override
	public void setIsCollaborativeText(boolean collab) {
		if (collab) {
			VirtualToolkit.startMonitoringChanges(getUniversalWidgetId(), TEXT_PROPERTY);
		} else {
			VirtualToolkit.stopMonitoringChanges(getUniversalWidgetId(), TEXT_PROPERTY);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		VirtualToolkit.updateFirebaseProperty(getUniversalWidgetId(), e.getPropertyName(), e.getOldValue(),
				e.getNewValue());

	}

	@Override
	public void updateLocalUI(String propertyName, Object newValue) {
		switch (propertyName) {
		case TEXT_PROPERTY:
			setText((String) newValue);
			break;
		default:
			break;
		}
	}

}
