package gr.istl.virtualtoolkitsc.widgets.gwt;

import com.google.gwt.user.client.ui.FlowPanel;

import gr.istl.virtualtoolkitsc.widgets.PanelFactory;
import gr.istl.virtualtoolkitsc.widgets.VirtualContainer;

public class GWTPanelFactory implements PanelFactory {

	@Override
	public VirtualContainer createPanel() {
		FlowPanel panel = new FlowPanel();
		return new GWTPanel(panel);
	}

}
