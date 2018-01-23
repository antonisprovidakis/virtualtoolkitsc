package gr.istl.virtualtoolkitsc.widgets;

import java.util.HashMap;

import gr.istl.virtualtoolkitsc.api.firebase.FirebaseSyncManager;

public abstract class UniversalWidget {
	protected Object component;

	// private static int idCounter = 0;
	private String universalWidgetId;

	// native widget to Universal widget mapping
	public static transient HashMap<Object, UniversalWidget> componentsToUniversalWidgets = new HashMap<Object, UniversalWidget>();

	public UniversalWidget(Object component) {
		this.component = component;
		addComponentIntoComponentsToUniversalWidgetsMap(component, this);
//		universalWidgetId = createNewWidgetId();
		universalWidgetId = VirtualToolkit.createNewWidgetId();
		VirtualToolkit.defaultAssociate(universalWidgetId, this);
		init();
	}

	protected void init() {
		if (VirtualToolkit.isCollaborative()) {
			FirebaseSyncManager fsm = FirebaseSyncManager.getInstance();
			fsm.addWidgetIdIntoWidgetIdToDatabaseReferenceMap(universalWidgetId);
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
	
	// TODO: fix all other places this method modifies
	public void setUniversalWidgetId(String id) {
		universalWidgetId = id;
	}

//	private String createNewWidgetId() {
//		return "widget" + componentsToUniversalWidgets.size();
//	}

}
