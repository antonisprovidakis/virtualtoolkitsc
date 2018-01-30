package gr.istl.virtualtoolkitsc.widgets.swing;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import javax.swing.AbstractButton;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public class SwingButton extends SwingComponent implements VirtualButton {

	public final static String TEXT_PROPERTY = "text";

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
		String oldValue = getText();
		getButton().setText(text);
		VirtualToolkit.notifyPropertyChangeListeners(getUniversalWidgetId(), TEXT_PROPERTY, oldValue, text);
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
