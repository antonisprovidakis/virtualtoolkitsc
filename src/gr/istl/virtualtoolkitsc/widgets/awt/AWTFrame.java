package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gr.istl.virtualtoolkitsc.widgets.VirtualFrame;

public class AWTFrame extends AWTContainer implements VirtualFrame {

	public AWTFrame(Frame frame) {
		super(frame);
	}

	@Override
	protected void init() {
		super.init();

		getFrame().addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public Frame getFrame() {
		return (Frame) component;
	}

	@Override
	public void setTitle(String title) {
		getFrame().setTitle(title);
	}

	@Override
	public String getTitle() {
		return getFrame().getTitle();
	}

	@Override
	public void setVisible(boolean visible) {
		getFrame().setVisible(visible);
	}
	
	@Override
	public void pack() {
		getFrame().pack();
	}

}
