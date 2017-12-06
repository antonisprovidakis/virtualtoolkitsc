package gr.istl.virtualtoolkitsc.api.widgets.gwt;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;

import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractFlowPanel;

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
