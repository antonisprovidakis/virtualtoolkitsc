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

	public FirebaseSyncManager getFirebaseSyncManager() {
		return syncManager;
	}

	public static boolean isCollaborative() {
		return getDefaultFirebaseSyncManager() != null;
	}

	public static FirebaseSyncManager getDefaultFirebaseSyncManager() {
		return defaultToolkit.getFirebaseSyncManager();
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

	public static void defaultAssociate(String widgetID, Object obj) {
		defaultToolkit.associate(widgetID, obj);
	}

	public void associate(String widgetID, Object obj) {
		idToWidget.put(widgetID, obj);
	}

	public static void defaultReassociate(String oldID, String newID, Object obj) {
		defaultToolkit.reassociate(oldID, newID, obj);
	}

	public void reassociate(String oldID, String newID, Object obj) {
		if (newID != null) {
			if (oldID != null) {
				idToWidget.remove(oldID);
			}
			idToWidget.put(newID, obj);
		}
	}

	public static Object getDefaultObjectByID(String widgetID) {
		return defaultToolkit.getObjectByID(widgetID);
	}

	public Object getObjectByID(String widgetID) {
		return idToWidget.get(widgetID);
	}

	public static String createNewWidgetId() {
		return defaultToolkit.getWidgetId();
	}

	public synchronized String getWidgetId() {
		return "widget" + idToWidget.size();
	}

	public static void updateFirebaseProperty(String widgetId, String propertyName, Object oldValue, Object newValue) {
		if (isCollaborative()) {
			defaultToolkit.execUpdateFirebaseProperty(widgetId, propertyName, oldValue, newValue);
		}
	}

	public void execUpdateFirebaseProperty(String widgetId, String propertyName, Object oldValue, Object newValue) {
		syncManager.updateProperty(widgetId, propertyName, oldValue, newValue);
	}

	public static void notifyPropertyChangeListeners(String widgetId, String propertyName, Object oldValue,
			Object newValue) {
		if (isCollaborative()) {
			defaultToolkit.execNotifyPropertyChangeListeners(widgetId, propertyName, oldValue, newValue);
		}
	}

	public void execNotifyPropertyChangeListeners(String widgetId, String propertyName, Object oldValue,
			Object newValue) {
		syncManager.notifyPropertyChangeListeners(widgetId, propertyName, oldValue, newValue);
	}

	public static void startMonitoringChanges(String widgetId, String propertyName) {
		if (isCollaborative()) {
			defaultToolkit.execStartMonitoringChanges(widgetId, propertyName);
		}
	}

	public void execStartMonitoringChanges(String widgetId, String propertyName) {
		syncManager.startMonitoringProperty(widgetId, propertyName);
	}

	public static void stopMonitoringChanges(String widgetId, String propertyName) {
		if (isCollaborative()) {
			defaultToolkit.execStopMonitoringChanges(widgetId, propertyName);
		}
	}

	public void execStopMonitoringChanges(String widgetId, String propertyName) {
		syncManager.stopMonitoringProperty(widgetId, propertyName);
	}

	public static boolean isPropertyMonitored(String widgetId, String propertyName) {
		if (isCollaborative()) {
			return defaultToolkit.execIsPropertyMonitored(widgetId, propertyName);
		}

		return false;
	}

	public boolean execIsPropertyMonitored(String widgetId, String propertyName) {
		return syncManager.isPropertyMonitored(widgetId, propertyName);
	}

}
