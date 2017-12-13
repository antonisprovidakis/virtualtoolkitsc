package gr.istl.virtualtoolkitsc.widgets.gwt;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class GWTPanel extends GWTContainer {

	public GWTPanel(FlowPanel panel) {
		super(panel);
	}
	
	public FlowPanel getPanel() {
		return (FlowPanel) component;
	}
	
	public void add(Widget w) {
		getPanel().add(w);
	}
	
	public void addStyleName(String style) {
		getPanel().addStyleName(style);
	}

}
