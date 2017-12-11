package gr.istl.virtualtoolkitsc.test.main;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionEvent;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;
import gr.istl.virtualtoolkitsc.widgets.ButtonSelector;
import gr.istl.virtualtoolkitsc.widgets.FrameSelector;
import gr.istl.virtualtoolkitsc.widgets.GridLayoutSelector;
import gr.istl.virtualtoolkitsc.widgets.PanelSelector;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;
import gr.istl.virtualtoolkitsc.widgets.VirtualFrame;
import gr.istl.virtualtoolkitsc.widgets.VirtualLayout;
import gr.istl.virtualtoolkitsc.widgets.VirtualPanel;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;
import gr.istl.virtualtoolkitsc.widgets.swing.SwingToolkit;

public class SwingMain {

	public static void main(String[] args) {
		/*
		 * FirebaseApp defaultApp = null;
		 * 
		 * try { FileInputStream serviceAccount = new
		 * FileInputStream("virtualtoolkitsc-firebase-credentials.json");
		 * FirebaseOptions options = new FirebaseOptions.Builder()
		 * .setCredentials(GoogleCredentials.fromStream(serviceAccount))
		 * .setDatabaseUrl("https://virtualtoolkitsc.firebaseio.com/").build();
		 * 
		 * defaultApp = FirebaseApp.initializeApp(options); } catch
		 * (FileNotFoundException e) { e.printStackTrace();
		 * System.out.println("Credentials File not found."); System.exit(1); } catch
		 * (IOException e) { e.printStackTrace(); System.out.println("IO error.");
		 * System.exit(1); }
		 * 
		 * FirebaseDatabase db = FirebaseDatabase.getInstance(defaultApp);
		 */

		VirtualToolkit.setDefaultToolkit(new SwingToolkit());

		VirtualFrame frame = FrameSelector.createFrame("A test window");
		frame.setSize(300, 300);

		VirtualLayout vl = GridLayoutSelector.createLayout(2, 2);
		frame.setLayout(vl);

		VirtualButton button = ButtonSelector.createButton("Button1");

		VirtualActionListener ac = new VirtualActionListener() {

			@Override
			public void actionPerformed(VirtualActionEvent e) {
				VirtualButton b = (VirtualButton) e.getSource();
				System.out.println("Hello from button: " + b.getText());
			}
		};

		button.addActionListener(ac);

		frame.add(button);


		VirtualButton button2 = ButtonSelector.createButton("Button2");
		button2.addActionListener(ac);
		frame.add(button2);

		VirtualButton button3 = ButtonSelector.createButton("Button3");
		button3.addActionListener(ac);
		frame.add(button3);


		frame.setVisible(true);
	}

}
