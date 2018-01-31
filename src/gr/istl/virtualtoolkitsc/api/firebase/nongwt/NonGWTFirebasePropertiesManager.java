package gr.istl.virtualtoolkitsc.api.firebase.nongwt;

import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import gr.istl.virtualtoolkitsc.api.firebase.CollaborativeWidget;
import gr.istl.virtualtoolkitsc.api.firebase.FirebasePropertiesManager;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public class NonGWTFirebasePropertiesManager extends FirebasePropertiesManager {
	private Map<String, ValueEventListener> valueEventListenerMap;

	public NonGWTFirebasePropertiesManager() {
		super();
		valueEventListenerMap = new HashMap<String, ValueEventListener>();
	}

	@Override
	public void updateProperty(String widgetId, String propertyName, Object oldValue, Object newValue) {
		DatabaseReference dbRef = (DatabaseReference) VirtualToolkit.getDefaultFirebaseSyncManager()
				.getDBRefForWidgetId(widgetId);

		if (dbRef == null) {
			return;
		}

		if (!oldValue.equals(newValue)) {
			dbRef.child(propertyName).setValueAsync(newValue);
		}
	}

	@Override
	public void createValueEventListener(String widgetId, String propertyName) {
		CollaborativeWidget cw = (CollaborativeWidget) VirtualToolkit.getDefaultObjectByID(widgetId);

		NonGWTFirebaseValueEventHandler veh = new NonGWTFirebaseValueEventHandler(cw, propertyName);

		DatabaseReference dbRef = (DatabaseReference) VirtualToolkit.getDefaultFirebaseSyncManager()
				.getDBRefForWidgetId(widgetId);
		dbRef.child(propertyName).addValueEventListener(veh);

		valueEventListenerMap.put(widgetId + "_" + propertyName, veh);
	}

	@Override
	public void destroyValueEventListener(String widgetId, String propertyName) {
		DatabaseReference dbRef = (DatabaseReference) VirtualToolkit.getDefaultFirebaseSyncManager()
				.getDBRefForWidgetId(widgetId);

		String listenerId = widgetId + "_" + propertyName;

		ValueEventListener listener = valueEventListenerMap.get(listenerId);

		if (listener == null) {
			return;
		}

		dbRef.child(propertyName).removeEventListener(listener);
		valueEventListenerMap.remove(listenerId);
	}

}
