package gr.istl.virtualtoolkitsc.widgets.gwt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gr.istl.virtualtoolkitsc.widgets.VirtualComponent;
import gr.istl.virtualtoolkitsc.widgets.VirtualContainer;
import gr.istl.virtualtoolkitsc.widgets.VirtualFrame;
import gr.istl.virtualtoolkitsc.widgets.VirtualLayout;

import com.google.gwt.user.client.Window;

public class GWTFrame extends GWTContainer implements VirtualFrame, VirtualContainer {

	// private String id;

	public GWTFrame() {
		super();
	}

	public GWTFrame(String title) {
		super();
		setTitle(title);
	}

	public RootPanel getPanel() {
		// if (id == null) {
		// GWT.log("1");
		// return RootPanel.get();
		// } else {
		// GWT.log("2");
		// return RootPanel.get(id);
		// }

		return RootPanel.get();
	}

	private void add(Widget w) {
		// GWT.log("this.frame: " + this);
		// GWT.log("getPanel(): " + getPanel());
		// GWT.log("widget: " + w);

		getPanel().add(w);
	}

	@Override
	public void add(VirtualComponent component) {
		if (layout == null) {
			add((Widget) component.getPhysicalComponent());
		} else {
			layout.add(component);
		}
	}

	@Override
	public void setLayout(VirtualLayout layout) {
		if (layout == null)
			return;
		this.layout = (GWTLayout) layout;
		this.getPanel().add(((GWTLayout) layout).getComponent());
	}

	@Override
	public void setTitle(String title) {
		Window.setTitle(title);
	}

	@Override
	public String getTitle() {
		return Window.getTitle();
	}

	@Override
	public void setSize(int width, int height) {
	}

	@Override
	public void setVisible(boolean visible) {
	}

}
