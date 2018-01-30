package gr.istl.virtualtoolkitsc.api.firebase;

import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

import gr.istl.virtualtoolkitsc.widgets.CollaborativeWidget;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public abstract class FirebasePropertiesManager {
	private Map<String, PropertyChangeSupport> firebasePropertyChangeSupportMap;

	public FirebasePropertiesManager() {
		firebasePropertyChangeSupportMap = new HashMap<String, PropertyChangeSupport>();
	}

	public abstract void updateProperty(String widgetId, String propertyName, Object oldValue, Object newValue);

	public void notifyPropertyChangeListeners(String widgetId, String propertyName, Object oldValue, Object newValue) {
		PropertyChangeSupport pcs = firebasePropertyChangeSupportMap.get(widgetId);

		if (pcs == null) {
			return;
		}

		pcs.firePropertyChange(propertyName, oldValue, newValue);
	}

	public void startMonitoringProperty(String widgetId, String propertyName) {
		createFirebasePropertyChangeListener(widgetId, propertyName);
		createValueEventListener(widgetId, propertyName);
	}

	public void createFirebasePropertyChangeListener(String widgetId, String propertyName) {
		createPropertyChangeSupport(widgetId);

		PropertyChangeSupport pcs = firebasePropertyChangeSupportMap.get(widgetId);

		if (!pcs.hasListeners(propertyName)) {
			pcs.addPropertyChangeListener(propertyName,
					(CollaborativeWidget) VirtualToolkit.getDefaultObjectByID(widgetId));
		}
	}

	public void createPropertyChangeSupport(String widgetId) {
		if (firebasePropertyChangeSupportMap.containsKey(widgetId)) {
			return;
		}

		firebasePropertyChangeSupportMap.put(widgetId,
				new PropertyChangeSupport(VirtualToolkit.getDefaultObjectByID(widgetId)));
	}

	public abstract void createValueEventListener(String widgetId, String propertyName);

	public void stopMonitoringProperty(String widgetId, String propertyName) {
		destroyFirebasePropertyChangeListener(widgetId, propertyName);
		destroyValueEventListener(widgetId, propertyName);
	}

	public void destroyFirebasePropertyChangeListener(String widgetId, String propertyName) {
		PropertyChangeSupport pcs = firebasePropertyChangeSupportMap.get(widgetId);

		if (pcs == null) {
			return;
		}

		if (pcs.hasListeners(propertyName)) {
			pcs.removePropertyChangeListener(propertyName,
					(CollaborativeWidget) VirtualToolkit.getDefaultObjectByID(widgetId));
		}

		destroyPropertyChangeSupport(widgetId);
	}

	public void destroyPropertyChangeSupport(String widgetId) {
		if (firebasePropertyChangeSupportMap.get(widgetId) == null) {
			return;
		}

		int listenersLength = firebasePropertyChangeSupportMap.get(widgetId).getPropertyChangeListeners().length;

		if (listenersLength > 0) {
			return;
		}

		firebasePropertyChangeSupportMap.remove(widgetId);
	}

	public abstract void destroyValueEventListener(String widgetId, String propertyName);

	public boolean isPropertyMonitored(String widgetId, String propertyName) {
		PropertyChangeSupport pcs = firebasePropertyChangeSupportMap.get(widgetId);

		if (pcs == null) {
			return false;
		}

		return firebasePropertyChangeSupportMap.get(widgetId).hasListeners(propertyName);
	}

}
