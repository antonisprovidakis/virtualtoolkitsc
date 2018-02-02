package gr.istl.virtualtoolkitsc.widgets;

import java.util.Map;
import java.util.TreeMap;

import gr.istl.virtualtoolkitsc.api.firebase.FirebaseSyncManager;

public abstract class VirtualToolkit {

	private static VirtualToolkit defaultToolkit;
	private Map<String, Object> idToWidget = new TreeMap<String, Object>();
	private FirebaseSyncManager syncManager;

	public VirtualToolkit(boolean collab) {
		setDefaultCollaborative(collab);
		setupSelectors();
	}

	public abstract void setupSelectors();

	public static VirtualToolkit getDefaultToolkit() {
		return defaultToolkit;
	}

	public static void setDefaultToolkit(VirtualToolkit toolkit) {
		defaultToolkit = toolkit;
	}

	public static FirebaseSyncManager getDefaultFirebaseSyncManager() {
		return defaultToolkit.getFirebaseSyncManager();
	}

	public FirebaseSyncManager getFirebaseSyncManager() {
		return syncManager;
	}

	public static boolean isCollaborative() {
		return getDefaultFirebaseSyncManager() != null;
	}

	public void setDefaultCollaborative(boolean collab) {
		setCollaborative(collab);
	}

	public void setCollaborative(boolean collab) {
		if (collab) {
			syncManager = createFirebaseSyncManager();
		} else {
			syncManager = null;
		}
	}

	public abstract FirebaseSyncManager createFirebaseSyncManager();

	public static void defaultAssociate(String widgetId, Object obj) {
		defaultToolkit.associate(widgetId, obj);
	}

	public void associate(String widgetId, Object obj) {
		idToWidget.put(widgetId, obj);
	}

	public static void defaultReassociate(String oldId, String newId, Object obj) {
		defaultToolkit.reassociate(oldId, newId, obj);
	}

	public void reassociate(String oldId, String newId, Object obj) {
		if (newId != null) {
			if (oldId != null) {
				idToWidget.remove(oldId);
			}
			idToWidget.put(newId, obj);
		}
	}

	public static Object getDefaultObjectByID(String widgetId) {
		return defaultToolkit.getObjectByID(widgetId);
	}

	public Object getObjectByID(String widgetId) {
		return idToWidget.get(widgetId);
	}

	public static String defaultCreateNewWidgetId() {
		return defaultToolkit.createNewWidgetId();
	}

	public synchronized String createNewWidgetId() {
		return "widget" + idToWidget.size();
	}

	public static void defaultUpdateFirebaseProperty(String widgetId, String propertyName, Object oldValue, Object newValue) {
		if (isCollaborative()) {
			defaultToolkit.updateFirebaseProperty(widgetId, propertyName, oldValue, newValue);
		}
	}

	public void updateFirebaseProperty(String widgetId, String propertyName, Object oldValue, Object newValue) {
		syncManager.getFirebasePropertiesManager().updateProperty(widgetId, propertyName, oldValue, newValue);
	}

	public static void defaultNotifyPropertyChangeListeners(String widgetId, String propertyName, Object oldValue,
			Object newValue) {
		if (isCollaborative()) {
			defaultToolkit.notifyPropertyChangeListeners(widgetId, propertyName, oldValue, newValue);
		}
	}

	public void notifyPropertyChangeListeners(String widgetId, String propertyName, Object oldValue,
			Object newValue) {
		syncManager.getFirebasePropertiesManager().notifyPropertyChangeListeners(widgetId, propertyName, oldValue,
				newValue);
	}

	public static void defaultStartMonitoringChanges(String widgetId, String propertyName) {
		if (isCollaborative()) {
			defaultToolkit.startMonitoringChanges(widgetId, propertyName);
		}
	}

	public void startMonitoringChanges(String widgetId, String propertyName) {
		syncManager.getFirebasePropertiesManager().startMonitoringProperty(widgetId, propertyName);
	}

	public static void defaultStopMonitoringChanges(String widgetId, String propertyName) {
		if (isCollaborative()) {
			defaultToolkit.stopMonitoringChanges(widgetId, propertyName);
		}
	}

	public void stopMonitoringChanges(String widgetId, String propertyName) {
		syncManager.getFirebasePropertiesManager().stopMonitoringProperty(widgetId, propertyName);
	}

	public static boolean isDefaultPropertyMonitored(String widgetId, String propertyName) {
		if (isCollaborative()) {
			return defaultToolkit.isPropertyMonitored(widgetId, propertyName);
		}

		return false;
	}

	public boolean isPropertyMonitored(String widgetId, String propertyName) {
		return syncManager.getFirebasePropertiesManager().isPropertyMonitored(widgetId, propertyName);
	}

}
