package gr.istl.virtualtoolkitsc.widgets.swing;

import javax.swing.JFrame;

import gr.istl.virtualtoolkitsc.widgets.FrameFactory;
import gr.istl.virtualtoolkitsc.widgets.VirtualFrame;

public class SwingFrameFactory implements FrameFactory {

	@Override
	public VirtualFrame createFrame() {
		JFrame frame = new JFrame();
		return new SwingFrame(frame);
	}

	@Override
	public VirtualFrame createFrame(String title) {
		JFrame frame = new JFrame(title);
		return new SwingFrame(frame);
	}

}
