package gr.istl.virtualtoolkitsc.test.main;

import com.google.gwt.core.client.GWT;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseAdapter;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseEvent;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;
import gr.istl.virtualtoolkitsc.widgets.ButtonSelector;
import gr.istl.virtualtoolkitsc.widgets.FrameSelector;
import gr.istl.virtualtoolkitsc.widgets.GridLayoutSelector;
import gr.istl.virtualtoolkitsc.widgets.PanelSelector;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;
import gr.istl.virtualtoolkitsc.widgets.VirtualContainer;
import gr.istl.virtualtoolkitsc.widgets.VirtualFrame;
import gr.istl.virtualtoolkitsc.widgets.VirtualLayout;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;
import gr.istl.virtualtoolkitsc.widgets.awt.AWTToolkit;

public class AwtMain {
	public static void main(String[] args) {

		VirtualToolkit.setDefaultToolkit(new AWTToolkit());

		VirtualFrame frame = FrameSelector.createFrame("Demo");
		frame.setSize(300, 300);

		VirtualLayout vl = GridLayoutSelector.createLayout(2, 2);
		frame.setLayout(vl);

		VirtualMouseListener ml = new VirtualMouseAdapter() {
			@Override
			public void mouseReleased(VirtualMouseEvent e) {
				VirtualButton b = (VirtualButton) e.getSource();
				System.out.println("released on button: " + b.getText());
			}

			@Override
			public void mousePressed(VirtualMouseEvent e) {
				VirtualButton b = (VirtualButton) e.getSource();
				System.out.println("pressed on button: " + b.getText());
			}
		};

		for (int i = 0; i < 4; i++) {
			VirtualButton b = ButtonSelector.createButton("Button" + i);
			b.addMouseListener(ml);
			frame.add(b);
		}

		frame.setVisible(true);
	}
}
