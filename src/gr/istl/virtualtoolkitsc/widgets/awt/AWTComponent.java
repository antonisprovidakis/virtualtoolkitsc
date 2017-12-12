package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.Component;
import java.util.HashSet;
import java.util.Set;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;
import gr.istl.virtualtoolkitsc.widgets.UniversalWidget;
import gr.istl.virtualtoolkitsc.widgets.VirtualComponent;

public abstract class AWTComponent extends UniversalWidget implements VirtualComponent {

	private Set<VirtualMouseListener> vMouseListeners = new HashSet<VirtualMouseListener>();

	public AWTComponent(Component component) {
		super(component);
	}

	@Override
	protected void init() {
		super.init();
		AWTComponentEventForwarder forwarder = new AWTComponentEventForwarder(this);
		getComponent().addMouseListener(forwarder);
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
	public void addMouseListener(VirtualMouseListener listener) {
		vMouseListeners.add(listener);
	}

	@Override
	public void setSize(int width, int height) {
		getComponent().setSize(width, height);
	}

	public Set<VirtualMouseListener> getVirtualMouseListeners() {
		return vMouseListeners;
	}

}
