package gr.istl.virtualtoolkitsc.test.main;

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

		button.addMouseListener(ml);

		frame.add(button);

		VirtualButton button2 = ButtonSelector.createButton("Button2");
		button2.addMouseListener(new VirtualMouseAdapter() {
			@Override
			public void mouseEntered(VirtualMouseEvent e) {
				System.out.println("in");
			}
			
			@Override
			public void mouseExited(VirtualMouseEvent e) {
				System.out.println("out");
			}
		});
		
		
		frame.add(button2);

		VirtualButton button3 = ButtonSelector.createButton("Button3");
		frame.add(button3);
		
		VirtualContainer vc = PanelSelector.createPanel();
		vc.setLayout(GridLayoutSelector.createLayout(2, 1));
		
		vc.add(ButtonSelector.createButton("b1"));
		vc.add(ButtonSelector.createButton("b2"));
		
		frame.add(vc);
		

		frame.setVisible(true);
	}

}
