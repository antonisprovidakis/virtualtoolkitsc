package gr.istl.virtualtoolkitsc.widgets.gwt;

import com.google.gwt.user.client.ui.Panel;

import gr.istl.virtualtoolkitsc.widgets.VirtualComponent;
import gr.istl.virtualtoolkitsc.widgets.VirtualLayout;

public abstract class GWTLayout implements VirtualLayout {

	public abstract Panel getComponent();

	public abstract void add(VirtualComponent c);
}
