package gr.istl.virtualtoolkitsc.widgets.gwt;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.Widget;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseMoveListener;
import gr.istl.virtualtoolkitsc.widgets.UniversalWidget;
import gr.istl.virtualtoolkitsc.widgets.VirtualComponent;

public abstract class GWTComponent extends UniversalWidget implements VirtualComponent {

	private ArrayList<VirtualMouseListener> vMouseListeners = new ArrayList<VirtualMouseListener>();
	// private ArrayList<VirtualMouseMoveListener> vMouseMoveListeners = new
	// ArrayList<VirtualMouseMoveListener>();

	public GWTComponent(Widget widget) {
		super(widget);
	}

	public GWTComponent() {
		super();
	}

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
		return 0;
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public void setSize(int width, int height) {
		getWidget().setPixelSize(width, height);
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