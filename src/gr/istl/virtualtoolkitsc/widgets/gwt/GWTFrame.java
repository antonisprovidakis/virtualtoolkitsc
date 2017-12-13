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

	private String id;

	public GWTFrame() {
		super();
	}

	public GWTFrame(String id) {
		super();
		this.id = id;
		// setTitle(title);
	}

	public RootPanel getPanel() {
		if (id == null) {
			return RootPanel.get();
		} else {
			RootPanel rootPanel = RootPanel.get(id);

			if (rootPanel != null) {
				return RootPanel.get(id);
			} else {
				// can't find container with specified id.
				// fallback to RootPanel.get() (body element)
				return RootPanel.get();
			}
		}
	}

	private void add(Widget w) {
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

	@Override
	public void pack() {
	}

}
