package gr.istl.virtualtoolkitsc.widgets.swing;

import gr.istl.virtualtoolkitsc.widgets.FrameFactory;
import gr.istl.virtualtoolkitsc.widgets.VirtualFrame;

public class SwingFrameFactory implements FrameFactory {

	@Override
	public VirtualFrame createFrame() {
		return new SwingFrame();
	}

	@Override
	public VirtualFrame createFrame(String title) {
		return new SwingFrame(title);
	}

}
