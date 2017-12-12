package gr.istl.virtualtoolkitsc.widgets;

import java.util.Hashtable;

public abstract class UniversalWidget {
	protected Object component;

	// native widget to Universal widget mapping
	private static transient Hashtable<Object, UniversalWidget> componentsToUniversalWidgets = new Hashtable<Object, UniversalWidget>();

	public UniversalWidget(Object component) {
		this.component = component;
		componentsToUniversalWidgets.put(component, this);
		init();
	}
	
	protected void init() {
	}
	
	public Object getWidget() {
		return component;
	}

	public static UniversalWidget universalWidget(Object c) {
		if (c == null) {
			return null;
		}

		return componentsToUniversalWidgets.get(c);
	}
}
