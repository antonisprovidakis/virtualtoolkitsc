package gr.teicrete.ie.oop2.gwtswingsync.api.widgets;

import com.google.gwt.user.client.ui.RootPanel;

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
