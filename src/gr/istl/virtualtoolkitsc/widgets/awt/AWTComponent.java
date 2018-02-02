package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.Component;
import java.util.ArrayList;

import gr.istl.virtualtoolkitsc.api.firebase.CollaborativeWidget;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;
import gr.istl.virtualtoolkitsc.widgets.UniversalWidget;
import gr.istl.virtualtoolkitsc.widgets.VirtualComponent;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public abstract class AWTComponent extends UniversalWidget implements VirtualComponent, CollaborativeWidget {

	public final static String ENABLED_COLLAB_PROPERTY = "enabled";

	private ArrayList<VirtualMouseListener> vMouseListeners = new ArrayList<VirtualMouseListener>();
	// private ArrayList<VirtualMouseMoveListener> vMouseMoveListeners = new
	// ArrayList<VirtualMouseMoveListener>();

	public AWTComponent(Component component) {
		super(component);
	}

	@Override
	protected void init() {
		super.init();

		getComponent().addMouseListener(new AWTComponentEventForwarder(this));
	}

	public Component getAWTComponent() {
		return getComponent();
	}

	public Component getComponent() {
		return (Component) component;
	}

	@Override
	public Object getPhysicalComponent() {
		return getComponent();
	}

	@Override
	public int getHeight() {
		return getComponent().getHeight();
	}

	@Override
	public int getWidth() {
		return getComponent().getWidth();
	}

	@Override
	public void setSize(int width, int height) {
		getComponent().setSize(width, height);
	}

	@Override
	public String getName() {
		return getUniversalWidgetId();
	}

	@Override
	public void setName(String name) {
		String oldId = getUniversalWidgetId();
		getComponent().setName(name);
		setUniversalWidgetId(name);
		VirtualToolkit.defaultReassociate(oldId, name, this);
	}

	@Override
	public void addMouseListener(VirtualMouseListener listener) {
		vMouseListeners.add(listener);
	}

	@Override
	public ArrayList<VirtualMouseListener> getVirtualMouseListeners() {
		return vMouseListeners;
	}

	// @Override
	// public void addMouseMoveListener(VirtualMouseMoveListener listener) {
	// vMouseMoveListeners.add(listener);
	// }

	// public ArrayList<VirtualMouseMoveListener> getVirtualMouseMoveListeners() {
	// return vMouseMoveListeners;
	// }

	//
	// @Override
	// public void addMouseTrackListener(VirtualMouseListener listener) {
	// addMouseListener(listener);
	// }

	@Override
	public boolean isEnabled() {
		return getAWTComponent().isEnabled();
	}

	@Override
	public void setEnabled(boolean enabled) {
		boolean oldValue = isEnabled();
		getAWTComponent().setEnabled(enabled);
		VirtualToolkit.defaultNotifyPropertyChangeListeners(getUniversalWidgetId(), ENABLED_COLLAB_PROPERTY, oldValue,
				isEnabled());
	}

	@Override
	public boolean isCollaborativeEnabled() {
		return VirtualToolkit.isDefaultPropertyMonitored(getUniversalWidgetId(), ENABLED_COLLAB_PROPERTY);
	}

	@Override
	public void setCollaborativeEnabled(boolean collab) {
		if (collab) {
			VirtualToolkit.defaultStartMonitoringChanges(getUniversalWidgetId(), ENABLED_COLLAB_PROPERTY);
		} else {
			VirtualToolkit.defaultStopMonitoringChanges(getUniversalWidgetId(), ENABLED_COLLAB_PROPERTY);
		}
	}

	@Override
	public void collaborativePropertyChanged(String propertyName, Object newValue) {
		switch (propertyName) {
		case ENABLED_COLLAB_PROPERTY:
			setEnabled((boolean) newValue);
			break;
		default:
			break;
		}
	}

}
