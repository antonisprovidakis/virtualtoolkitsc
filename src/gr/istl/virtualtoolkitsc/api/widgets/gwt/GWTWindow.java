package gr.istl.virtualtoolkitsc.api.widgets.gwt;

import com.google.gwt.user.client.ui.RootPanel;

import gr.istl.virtualtoolkitsc.api.widgets.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractWindow;

public class GWTWindow implements AbstractWindow {

	public GWTWindow() {
	}

	@Override
	public void addPanel(AbstractFlowPanel panel) {
		// generalize to container/panel
		RootPanel.get().add((GWTFlowPanel) panel);
	}
	
	@Override
	public void setVisible(boolean isVisible) {
	}

}
