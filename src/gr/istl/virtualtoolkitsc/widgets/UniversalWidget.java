package gr.istl.virtualtoolkitsc.widgets;

import java.util.HashMap;

import gr.istl.virtualtoolkitsc.api.firebase.FirebaseSyncManager;

public abstract class UniversalWidget {
	protected Object component;

	private static int idCounter = 0;
	private String universalWidgetId;

	// native widget to Universal widget mapping
	private static transient HashMap<Object, UniversalWidget> componentsToUniversalWidgets = new HashMap<Object, UniversalWidget>();

	public UniversalWidget(Object component) {
		this.component = component;

		universalWidgetId = createNewWidgetId();
		
		componentsToUniversalWidgets.put(component, this);
		init();
	}

	public UniversalWidget() {
//		init();
	}

	protected void init() {
		if (VirtualToolkit.isInSync()) {
			FirebaseSyncManager firebaseSyncManager = FirebaseSyncManager.getInstance();
			firebaseSyncManager.addWidgetIdToWidgetIdToDatabaseReferenceMap(universalWidgetId);
		}
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
		return "widget" + idCounter++;
	}

}
