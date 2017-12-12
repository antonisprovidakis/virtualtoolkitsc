package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.Frame;

import gr.istl.virtualtoolkitsc.widgets.FrameFactory;
import gr.istl.virtualtoolkitsc.widgets.VirtualFrame;

public class AWTFrameFactory implements FrameFactory {

	@Override
	public VirtualFrame createFrame() {
		Frame frame = new Frame();
		return new AWTFrame(frame);
	}

	@Override
	public VirtualFrame createFrame(String title) {
		Frame frame = new Frame(title);
		return new AWTFrame(frame);
	}

}
