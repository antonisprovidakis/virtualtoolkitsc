package gr.istl.virtualtoolkitsc.widgets.gwt;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.Widget;

import gr.istl.virtualtoolkitsc.api.firebase.CollaborativeWidget;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualFocusListener;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;
import gr.istl.virtualtoolkitsc.widgets.UniversalWidget;
import gr.istl.virtualtoolkitsc.widgets.VirtualComponent;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public abstract class GWTComponent extends UniversalWidget implements VirtualComponent, CollaborativeWidget {

	public final static String ENABLED_COLLAB_PROPERTY = "enabled";

	private ArrayList<VirtualMouseListener> vMouseListeners = new ArrayList<VirtualMouseListener>();
	private ArrayList<VirtualFocusListener> vFocusListeners = new ArrayList<VirtualFocusListener>();

	// private ArrayList<VirtualMouseMoveListener> vMouseMoveListeners = new
	// ArrayList<VirtualMouseMoveListener>();

	public GWTComponent(Widget widget) {
		super(widget);
	}

	// public GWTComponent() {
	// super();
	// }

	@Override
	protected void init() {
		super.init();

		if (getWidget() instanceof FocusWidget) {
			FocusWidget fw = ((FocusWidget) getWidget());

			GWTComponentEventForwarder forwarder = new GWTComponentEventForwarder(this);
			fw.addMouseDownHandler(forwarder);
			fw.addMouseUpHandler(forwarder);
			fw.addFocusHandler(forwarder);
			fw.addBlurHandler(forwarder);
		}
	}

	public Widget getGWTComponent() {
		return getWidget();
	}

	public Widget getWidget() {
		return (Widget) component;
	}

	@Override
	public Object getPhysicalComponent() {
		return getWidget();
	}

	@Override
	public int getHeight() {
		return getWidget().getOffsetHeight();
	}

	@Override
	public int getWidth() {
		return getWidget().getOffsetWidth();
	}

	@Override
	public void setSize(int width, int height) {
		getWidget().setPixelSize(width, height);
	}

	@Override
	public String getName() {
		return getUniversalWidgetId();
	}

	@Override
	public void setName(String name) {
		String oldId = getUniversalWidgetId();
		getWidget().getElement().setId(name); // maybe remove?
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

	@Override
	public void addFocusListener(VirtualFocusListener listener) {
		vFocusListeners.add(listener);
	}

	@Override
	public ArrayList<VirtualFocusListener> getVirtualFocusListeners() {
		return vFocusListeners;
	}

	// @Override
	// public void addMouseMoveListener(VirtualMouseMoveListener listener) {
	// vMouseMoveListeners.add(listener);
	// }

	// public ArrayList<VirtualMouseMoveListener> getVirtualMouseMoveListeners() {
	// return vMouseMoveListeners;
	// }

	// @Override
	// public void addMouseTrackListener(VirtualMouseListener listener) {
	// addMouseListener(listener);
	// }

	@Override
	public boolean isEnabled() {
		if (getWidget() instanceof FocusWidget) {
			return ((FocusWidget) getWidget()).isEnabled();
		}

		return true;
	}

	@Override
	public void setEnabled(boolean enabled) {
		if (getWidget() instanceof FocusWidget) {
			boolean oldValue = isEnabled();
			((FocusWidget) getWidget()).setEnabled(enabled);
			VirtualToolkit.notifyPropertyChangeListeners(getUniversalWidgetId(), ENABLED_COLLAB_PROPERTY, oldValue,
					isEnabled());
		}
	}

	@Override
	public boolean isCollaborativeEnabled() {
		return VirtualToolkit.isPropertyMonitored(getUniversalWidgetId(), ENABLED_COLLAB_PROPERTY);
	}

	@Override
	public void setCollaborativeEnabled(boolean collab) {
		if (collab) {
			VirtualToolkit.startMonitoringChanges(getUniversalWidgetId(), ENABLED_COLLAB_PROPERTY);
		} else {
			VirtualToolkit.stopMonitoringChanges(getUniversalWidgetId(), ENABLED_COLLAB_PROPERTY);
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
