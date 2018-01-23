package gr.istl.virtualtoolkitsc.widgets.gwt;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.Widget;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;
import gr.istl.virtualtoolkitsc.widgets.UniversalWidget;
import gr.istl.virtualtoolkitsc.widgets.VirtualComponent;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public abstract class GWTComponent extends UniversalWidget implements VirtualComponent {

	private ArrayList<VirtualMouseListener> vMouseListeners = new ArrayList<VirtualMouseListener>();
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
		GWTComponentEventForwarder forwarder = new GWTComponentEventForwarder(this);

		if (getWidget() instanceof FocusWidget) {
			((FocusWidget) getWidget()).addMouseDownHandler(forwarder);
			((FocusWidget) getWidget()).addMouseUpHandler(forwarder);
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

	// @Override
	// public void addMouseMoveListener(VirtualMouseMoveListener listener) {
	// vMouseMoveListeners.add(listener);
	// }

	// @Override
	// public void addMouseTrackListener(VirtualMouseListener listener) {
	// addMouseListener(listener);
	// }

	@Override
	public ArrayList<VirtualMouseListener> getVirtualMouseListeners() {
		return vMouseListeners;
	}

	// public ArrayList<VirtualMouseMoveListener> getVirtualMouseMoveListeners() {
	// return vMouseMoveListeners;
	// }

}
