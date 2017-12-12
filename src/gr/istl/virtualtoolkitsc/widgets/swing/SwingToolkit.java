package gr.istl.virtualtoolkitsc.widgets.swing;

import gr.istl.virtualtoolkitsc.widgets.ButtonSelector;
import gr.istl.virtualtoolkitsc.widgets.FrameSelector;
import gr.istl.virtualtoolkitsc.widgets.GridLayoutSelector;
import gr.istl.virtualtoolkitsc.widgets.PanelSelector;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public class SwingToolkit extends VirtualToolkit {

	public SwingToolkit() {
		super();
	}

	@Override
	public void setupSelectors() {
		FrameSelector.setFrameFactory(new SwingFrameFactory());
		PanelSelector.setPanelFactory(new SwingPanelFactory());
		GridLayoutSelector.setGridLayoutFactory(new SwingGridLayoutFactory());
		ButtonSelector.setButtonFactory(new SwingButtonFactory());

	}

	// public void startFrame(VirtualFrame frame) {
	// receiveStartFrameCommand(frame);
	//
	// if (frame != null && VirtualToolkit.isDistributedByDefault()) {
	// VirtualToolkit.sendCommandByDefault(COMMAND_LABEL + COMMAND_START
	// + frame.getName() + ")");
	// }
	// }
	//
	// public void receiveStartFrameCommand(VirtualFrame frame) {
	// if (frame != null) {
	// frame.setVisible(true);
	// }
	// }
}
