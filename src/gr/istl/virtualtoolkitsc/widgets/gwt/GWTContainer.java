package gr.istl.virtualtoolkitsc.widgets.gwt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

import gr.istl.virtualtoolkitsc.widgets.VirtualComponent;
import gr.istl.virtualtoolkitsc.widgets.VirtualContainer;
import gr.istl.virtualtoolkitsc.widgets.VirtualLayout;

public abstract class GWTContainer extends GWTComponent implements VirtualContainer {

	protected GWTLayout layout;

	public GWTContainer(Widget widget) {
		super(widget);
	}

	public GWTContainer() {
		super();
	}

	public Panel getContainer() {
		return (Panel) component;
	}

	@Override
	public void add(VirtualComponent component) {
		if (layout == null) {
			getContainer().add((Widget) component.getPhysicalComponent());
		} else {
			layout.add(component);
		}
	}

	@Override
	public void setLayout(VirtualLayout layout) {
		if (layout == null) {
			return;
		}

		this.layout = (GWTLayout) layout;
		getContainer().add(((GWTLayout) layout).getComponent());

	}

	@Override
	public int getWidth() {
		return getContainer().getOffsetWidth();
	}

	@Override
	public int getHeight() {
		return getContainer().getOffsetHeight();
	}

}
