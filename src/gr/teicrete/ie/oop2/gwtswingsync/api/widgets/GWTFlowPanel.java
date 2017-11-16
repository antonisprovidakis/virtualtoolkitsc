package gr.teicrete.ie.oop2.gwtswingsync.api.widgets;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;

public class GWTFlowPanel extends FlowPanel implements AbstractFlowPanel{

	public GWTFlowPanel() {
		super();
	}
	
	@Override
	public void addButton(AbstractButton button) {
		// generalize to widget
		add((Button) button);
	}

	@Override
	public void removeAllWidgets() {
		clear();
	}

}
