package gr.istl.virtualtoolkitsc.widgets.swing;

import javax.swing.JFrame;

import gr.istl.virtualtoolkitsc.widgets.VirtualFrame;
import gr.istl.virtualtoolkitsc.widgets.awt.AWTFrame;

public class SwingFrame extends AWTFrame implements VirtualFrame {

	public SwingFrame(JFrame frame) {
		super(frame);
	}

	public JFrame getJFrame() {
		return (JFrame) component;
	}

	@Override
	protected void init() {
		getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
