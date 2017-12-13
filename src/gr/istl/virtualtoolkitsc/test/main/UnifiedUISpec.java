package gr.istl.virtualtoolkitsc.test.main;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseAdapter;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseEvent;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;
import gr.istl.virtualtoolkitsc.widgets.ButtonSelector;
import gr.istl.virtualtoolkitsc.widgets.FrameSelector;
import gr.istl.virtualtoolkitsc.widgets.GridLayoutSelector;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;
import gr.istl.virtualtoolkitsc.widgets.VirtualFrame;
import gr.istl.virtualtoolkitsc.widgets.VirtualGridLayout;
import gr.istl.virtualtoolkitsc.widgets.VirtualLayout;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;
import gr.istl.virtualtoolkitsc.widgets.awt.AWTToolkit;
import gr.istl.virtualtoolkitsc.widgets.swing.SwingToolkit;

public final class UnifiedUISpec {
	private UnifiedUISpec() {}
	
	public static void engageDialogue(VirtualToolkit virtualToolkit) {
		VirtualToolkit.setDefaultToolkit(virtualToolkit	);

		VirtualFrame frame = FrameSelector.createFrame("demo");

		VirtualLayout vl = GridLayoutSelector.createLayout(2, 4);
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

		for (int i = 0; i < ((VirtualGridLayout) vl).getRows() * ((VirtualGridLayout) vl).getColumns(); i++) {
			VirtualButton b = ButtonSelector.createButton("Button" + i);
			b.addMouseListener(ml);
			frame.add(b);
		}

		frame.pack();

		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		VirtualToolkit virtualToolkit = null;
		
//		virtualToolkit = new SwingToolkit();
//		virtualToolkit = new AWTToolkit();
				
		UnifiedUISpec.engageDialogue(virtualToolkit);
	}
	
}
