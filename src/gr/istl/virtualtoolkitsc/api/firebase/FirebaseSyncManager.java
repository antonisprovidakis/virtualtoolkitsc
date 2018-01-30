package gr.istl.virtualtoolkitsc.api.firebase;

public abstract class FirebaseSyncManager {

	private FirebasePropertiesManager fpcm;

	public FirebaseSyncManager() {
		fpcm = createFirebasePropertiesManager();
	}

	public abstract FirebasePropertiesManager createFirebasePropertiesManager();

	public abstract void addWidgetIdIntoWidgetIdToDatabaseReferenceMap(String widgetId);

	// cast to appropriate type
	public abstract Object getDBRefForWidgetId(String widgetId);

	public void updateProperty(String widgetId, String propertyName, Object oldValue, Object newValue) {
		fpcm.updateProperty(widgetId, propertyName, oldValue, newValue);
	}

	public void notifyPropertyChangeListeners(String widgetId, String propertyName, Object oldValue, Object newValue) {
		fpcm.notifyPropertyChangeListeners(widgetId, propertyName, oldValue, newValue);
	}

	public void startMonitoringProperty(String widgetId, String propertyName) {
		fpcm.startMonitoringProperty(widgetId, propertyName);
	}

	public void stopMonitoringProperty(String widgetId, String propertyName) {
		fpcm.stopMonitoringProperty(widgetId, propertyName);
	}

	public boolean isPropertyMonitored(String widgetId, String propertyName) {
		return fpcm.isPropertyMonitored(widgetId, propertyName);
	}

}
