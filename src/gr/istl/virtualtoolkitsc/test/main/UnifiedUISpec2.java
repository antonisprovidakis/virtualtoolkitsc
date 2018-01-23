package gr.istl.virtualtoolkitsc.test.main;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionEvent;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;
import gr.istl.virtualtoolkitsc.widgets.ButtonSelector;
import gr.istl.virtualtoolkitsc.widgets.FrameSelector;
import gr.istl.virtualtoolkitsc.widgets.GridLayoutSelector;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;
import gr.istl.virtualtoolkitsc.widgets.VirtualFrame;
import gr.istl.virtualtoolkitsc.widgets.VirtualLayout;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;
import gr.istl.virtualtoolkitsc.widgets.awt.AWTToolkit;
import gr.istl.virtualtoolkitsc.widgets.swing.SwingToolkit;

public final class UnifiedUISpec2 {

	private UnifiedUISpec2() {
	}

	public static void engageDialogue(VirtualToolkit virtualToolkit) {
		VirtualToolkit.setDefaultToolkit(virtualToolkit);

		VirtualFrame frame = FrameSelector.createFrame("demo");

		VirtualLayout vl = GridLayoutSelector.createLayout(1, 2);
		frame.setLayout(vl);

		VirtualButton vb1 = ButtonSelector.createButton("VB1");
		vb1.setIsCollaborativeText(true);

		VirtualButton vb2 = ButtonSelector.createButton("VB2");
		vb2.setIsCollaborativeText(true);

		vb1.addActionListener(new VirtualActionListener() {

			@Override
			public void actionPerformed(VirtualActionEvent e) {
				vb2.setText("Changed by 1");
			}
		});

		vb2.addActionListener(new VirtualActionListener() {

			@Override
			public void actionPerformed(VirtualActionEvent e) {
				vb1.setText("Changed by 2");
			}
		});

		frame.add(vb1);
		frame.add(vb2);

		frame.pack();

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		VirtualToolkit virtualToolkit = null;

		virtualToolkit = new SwingToolkit(true);
//		 virtualToolkit = new AWTToolkit(true);

		UnifiedUISpec2.engageDialogue(virtualToolkit);

		// System.out.println(virtualToolkit.idToWidget);
		// System.out.println("----");
		// System.out.println(UniversalWidget.componentsToUniversalWidgets);
	}

}
