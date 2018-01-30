package gr.istl.virtualtoolkitsc.api.firebase.gwt;

import java.util.HashMap;
import java.util.Map;

import com.github.spirylics.xgwt.essential.Fn.Arg;
import com.github.spirylics.xgwt.firebase.Event;
import com.github.spirylics.xgwt.firebase.database.Reference;
import com.github.spirylics.xgwt.firebase.database.XDataSnapshot;

import gr.istl.virtualtoolkitsc.api.firebase.FirebasePropertiesManager;
import gr.istl.virtualtoolkitsc.widgets.CollaborativeWidget;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public class GWTFirebasePropertiesManager extends FirebasePropertiesManager {

	private Map<String, Arg<XDataSnapshot>> valueEventListenerMap;

	public GWTFirebasePropertiesManager() {
		super();
		valueEventListenerMap = new HashMap<String, Arg<XDataSnapshot>>();
	}

	@Override
	public void updateProperty(String widgetId, String propertyName, Object oldValue, Object newValue) {
		Reference dbRef = (Reference) VirtualToolkit.getDefaultFirebaseSyncManager().getDBRefForWidgetId(widgetId);

		if (dbRef == null) {
			return;
		}

		if (!oldValue.equals(newValue)) {
			dbRef.child(propertyName).xSet(newValue);
		}
	}

	@Override
	public void createValueEventListener(final String widgetId, final String propertyName) {
		Arg<XDataSnapshot> vel = new Arg<XDataSnapshot>() {

			@Override
			public void e(XDataSnapshot xData) {
				if (xData.dataSnapshot.val() != null) {
					CollaborativeWidget cw = (CollaborativeWidget) VirtualToolkit.getDefaultObjectByID(widgetId);
					cw.updateLocalUI(propertyName, xData.dataSnapshot.val());
				}
			}
		};

		Reference dbRef = (Reference) VirtualToolkit.getDefaultFirebaseSyncManager().getDBRefForWidgetId(widgetId);
		dbRef.child(propertyName).xOn(Event.value, vel);

		valueEventListenerMap.put(widgetId + "_" + propertyName, vel);
	}

	@Override
	public void destroyValueEventListener(String widgetId, String propertyName) {
		Reference dbRef = (Reference) VirtualToolkit.getDefaultFirebaseSyncManager().getDBRefForWidgetId(widgetId);

		String listenerId = widgetId + "_" + propertyName;

		Arg<XDataSnapshot> listener = valueEventListenerMap.get(listenerId);

		if (listener == null) {
			return;
		}

		dbRef.child(propertyName).xOff(Event.value, listener);

		valueEventListenerMap.remove(listenerId);
	}

}
