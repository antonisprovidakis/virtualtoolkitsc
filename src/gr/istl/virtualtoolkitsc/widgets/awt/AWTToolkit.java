package gr.istl.virtualtoolkitsc.widgets.awt;

import gr.istl.virtualtoolkitsc.widgets.ButtonSelector;
import gr.istl.virtualtoolkitsc.widgets.FrameSelector;
import gr.istl.virtualtoolkitsc.widgets.GridLayoutSelector;
import gr.istl.virtualtoolkitsc.widgets.PanelSelector;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;


public class AWTToolkit extends VirtualToolkit {

	public AWTToolkit() {
		super();
	}

	@Override
	public void setupSelectors() {
		FrameSelector.setFrameFactory(new AWTFrameFactory());
		PanelSelector.setPanelFactory(new AWTPanelFactory());
		GridLayoutSelector.setGridLayoutFactory(new AWTGridLayoutFactory());
		ButtonSelector.setButtonFactory(new AWTButtonFactory());
	}

}
