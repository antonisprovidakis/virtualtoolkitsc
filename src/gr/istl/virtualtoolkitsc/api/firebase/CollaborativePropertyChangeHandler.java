package gr.istl.virtualtoolkitsc.api.firebase;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public class CollaborativePropertyChangeHandler implements PropertyChangeListener {

	private final String widgetId;

	public CollaborativePropertyChangeHandler(String widgetId) {
		this.widgetId = widgetId;
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		VirtualToolkit.defaultUpdateFirebaseProperty(widgetId, e.getPropertyName(), e.getOldValue(), e.getNewValue());
	}

}
