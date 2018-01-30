package gr.istl.virtualtoolkitsc.widgets.swing;

import gr.istl.virtualtoolkitsc.api.firebase.FirebaseSyncManager;
import gr.istl.virtualtoolkitsc.api.firebase.nongwt.NonGWTFirebaseSyncManager;
import gr.istl.virtualtoolkitsc.widgets.ButtonSelector;
import gr.istl.virtualtoolkitsc.widgets.FrameSelector;
import gr.istl.virtualtoolkitsc.widgets.GridLayoutSelector;
import gr.istl.virtualtoolkitsc.widgets.PanelSelector;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;
import gr.istl.virtualtoolkitsc.widgets.awt.AWTGridLayoutFactory;

public class SwingToolkit extends VirtualToolkit {

	public SwingToolkit(boolean collab) {
		super(collab);
	}
	
	@Override
	public FirebaseSyncManager createFirebaseSyncManager() {
		return new NonGWTFirebaseSyncManager();
	}

	@Override
	public void setupSelectors() {
		FrameSelector.setFrameFactory(new SwingFrameFactory());
		PanelSelector.setPanelFactory(new SwingPanelFactory());
		GridLayoutSelector.setGridLayoutFactory(new AWTGridLayoutFactory());
		ButtonSelector.setButtonFactory(new SwingButtonFactory());
	}
}
