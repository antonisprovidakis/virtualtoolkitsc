package gr.istl.virtualtoolkitsc.api.firebase;

public abstract class FirebaseSyncManager {

	private FirebasePropertiesManager fpcm;

	public FirebaseSyncManager() {
		fpcm = createFirebasePropertiesManager();
	}

	public FirebasePropertiesManager getFirebasePropertiesManager() {
		return fpcm;
	}

	public abstract FirebasePropertiesManager createFirebasePropertiesManager();

	public abstract void addWidgetIdIntoWidgetIdToDatabaseReferenceMap(String widgetId);

	// cast to appropriate type
	public abstract Object getDBRefForWidgetId(String widgetId);

}
