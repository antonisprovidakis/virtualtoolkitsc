package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.Component;
import java.util.ArrayList;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;
import gr.istl.virtualtoolkitsc.widgets.UniversalWidget;
import gr.istl.virtualtoolkitsc.widgets.VirtualComponent;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public abstract class AWTComponent extends UniversalWidget implements VirtualComponent {

	private ArrayList<VirtualMouseListener> vMouseListeners = new ArrayList<VirtualMouseListener>();
//	private ArrayList<VirtualMouseMoveListener> vMouseMoveListeners = new ArrayList<VirtualMouseMoveListener>();

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

//	@Override
//	public void addMouseMoveListener(VirtualMouseMoveListener listener) {
//		vMouseMoveListeners.add(listener);
//	}
//
//	@Override
//	public void addMouseTrackListener(VirtualMouseListener listener) {
//		addMouseListener(listener);
//	}

	public ArrayList<VirtualMouseListener> getVirtualMouseListeners() {
		return vMouseListeners;
	}

//	public ArrayList<VirtualMouseMoveListener> getVirtualMouseMoveListeners() {
//		return vMouseMoveListeners;
//	}

}
