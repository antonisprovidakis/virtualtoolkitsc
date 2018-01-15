package gr.istl.virtualtoolkitsc.widgets;

import java.util.HashMap;

import gr.istl.virtualtoolkitsc.api.firebase.FirebaseSyncManager;

public abstract class UniversalWidget {
	protected Object component;

	// private static int idCounter = 0;
	private String universalWidgetId;

	// native widget to Universal widget mapping
	private static transient HashMap<Object, UniversalWidget> componentsToUniversalWidgets = new HashMap<Object, UniversalWidget>();

	public UniversalWidget(Object component) {
		this.component = component;
		addComponentIntoComponentsToUniversalWidgetsMap(component, this);
		universalWidgetId = createNewWidgetId();
		init();
	}

	protected void init() {
		if (VirtualToolkit.isCollaborative()) {
			FirebaseSyncManager firebaseSyncManager = FirebaseSyncManager.getInstance();
			firebaseSyncManager.addWidgetIdIntoWidgetIdToDatabaseReferenceMap(universalWidgetId);
		}
	}

	private static void addComponentIntoComponentsToUniversalWidgetsMap(Object c, UniversalWidget classInstance) {
		if (c == null) {
			return;
		}

		componentsToUniversalWidgets.put(c, classInstance);
	}

	public static UniversalWidget universalWidget(Object c) {
		if (c == null) {
			return null;
		}

		return componentsToUniversalWidgets.get(c);
	}

	public String getUniversalWidgetId() {
		return universalWidgetId;
	}

	private String createNewWidgetId() {
		return "widget" + componentsToUniversalWidgets.size();
	}

}
