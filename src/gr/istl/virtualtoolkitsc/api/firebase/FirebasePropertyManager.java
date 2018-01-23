package gr.istl.virtualtoolkitsc.api.firebase;

import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import gr.istl.virtualtoolkitsc.widgets.CollaborativeWidget;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public class FirebasePropertyManager {
	private Map<String, PropertyChangeSupport> firebasePropertyChangeSupportMap;
	private Map<String, ValueEventListener> valueEventListenerMap;

	public FirebasePropertyManager() {
		firebasePropertyChangeSupportMap = new HashMap<String, PropertyChangeSupport>();
		valueEventListenerMap = new HashMap<String, ValueEventListener>();
	}

	public void updateProperty(DatabaseReference dbRef, Object oldValue, Object newValue) {
		if (!oldValue.equals(newValue)) {
			dbRef.setValueAsync(newValue);
		}
	}

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

	public void createValueEventListener(String widgetId, String propertyName) {
		ValueEventListener vel = new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				if (snapshot.getValue() != null) {
					CollaborativeWidget cw = (CollaborativeWidget) VirtualToolkit.getDefaultObjectByID(widgetId);
					cw.updateLocalUI(propertyName, snapshot.getValue());
				}
			}

			@Override
			public void onCancelled(DatabaseError error) {
			}
		};

		DatabaseReference dbRef = FirebaseSyncManager.getInstance().getDBRefForWidgetId(widgetId);
		dbRef.child(propertyName).addValueEventListener(vel);

		valueEventListenerMap.put(widgetId + "_" + propertyName, vel);
	}

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

	public void destroyValueEventListener(String widgetId, String propertyName) {
		DatabaseReference dbRef = FirebaseSyncManager.getInstance().getDBRefForWidgetId(widgetId);

		ValueEventListener listener = valueEventListenerMap.get(widgetId + "_" + propertyName);

		if (listener == null) {
			return;
		}

		dbRef.child(propertyName).removeEventListener(listener);
	}

	public boolean isPropertyMonitored(String widgetId, String propertyName) {
		PropertyChangeSupport pcs = firebasePropertyChangeSupportMap.get(widgetId);

		if (pcs == null) {
			return false;
		}

		return firebasePropertyChangeSupportMap.get(widgetId).hasListeners(propertyName);
	}

}
