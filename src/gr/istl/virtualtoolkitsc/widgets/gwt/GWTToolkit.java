package gr.istl.virtualtoolkitsc.widgets.gwt;

import gr.istl.virtualtoolkitsc.widgets.ButtonSelector;
import gr.istl.virtualtoolkitsc.widgets.FrameSelector;
import gr.istl.virtualtoolkitsc.widgets.GridLayoutSelector;
import gr.istl.virtualtoolkitsc.widgets.PanelSelector;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public class GWTToolkit extends VirtualToolkit {

	public GWTToolkit(boolean collab) {
		super(collab);
	}

	@Override
	public void setupSelectors() {
		FrameSelector.setFrameFactory(new GWTFrameFactory());
		PanelSelector.setPanelFactory(new GWTPanelFactory());
		GridLayoutSelector.setGridLayoutFactory(new GWTGridLayoutFactory());
		ButtonSelector.setButtonFactory(new GWTButtonFactory());
	}

}
