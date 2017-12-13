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
import gr.istl.virtualtoolkitsc.widgets.swing.SwingToolkit;

public class SwingMain {

	public static void main(String[] args) {

		/*
		FirebaseApp defaultApp = null;

		try {
			FileInputStream serviceAccount = new FileInputStream("virtualtoolkitsc-firebase-credentials.json");
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://virtualtoolkitsc.firebaseio.com/").build();

			defaultApp = FirebaseApp.initializeApp(options);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Credentials File not found.");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO error.");
			System.exit(1);
		}

		FirebaseDatabase db = FirebaseDatabase.getInstance(defaultApp);
		*/

		VirtualToolkit.setDefaultToolkit(new SwingToolkit());

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

}
