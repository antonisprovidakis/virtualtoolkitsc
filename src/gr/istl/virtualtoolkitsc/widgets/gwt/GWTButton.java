package gr.istl.virtualtoolkitsc.widgets.gwt;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import com.google.gwt.user.client.ui.Button;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;
import gr.istl.virtualtoolkitsc.exceptions.VirtualToolkitCollaborativeException;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public class GWTButton extends GWTComponent implements VirtualButton {

	public final static String TEXT_PROPERTY = "text";

	private boolean pressed = false;

	private ArrayList<VirtualActionListener> vActionListeners = new ArrayList<VirtualActionListener>();
	// private ArrayList<VirtualMouseMoveListener> vMouseMoveListeners = new
	// ArrayList<VirtualMouseMoveListener>();

	public GWTButton(Button button) {
		super(button);
	}

	@Override
	protected void init() {
		super.init();
		getButton().addClickHandler(new GWTButtonEventForwarder(this));
	}

	public Button getButton() {
		return (Button) component;
	}

	@Override
	public void addActionListener(VirtualActionListener listener) {
		vActionListeners.add(listener);
	}

	// @Override
	// public void addMouseMoveListener(VirtualMouseMoveListener listener) {
	// vMouseMoveListeners.add(listener);
	// }

	@Override
	public ArrayList<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
	}

	// public ArrayList<VirtualMouseMoveListener> getVirtualMouseMoveListeners() {
	// return vMouseMoveListeners;
	// }

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
		return pressed;
	}

	@Override
	public void setPressed(boolean pressed) {

		if (pressed) {
			addStyleName("gwt-Button-pressed");
		} else {
			removeStyleName("gwt-Button-pressed");
		}

		this.pressed = pressed;
	}

	@Override
	public void addStyleName(String style) {
		getButton().addStyleName(style);
	}

	@Override
	public void removeStyleName(String name) {
		getButton().removeStyleName(name);
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
