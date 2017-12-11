package gr.istl.virtualtoolkitsc.test.swing.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;

import gr.istl.virtualtoolkitsc.api.widgets.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractWindow;
import gr.istl.virtualtoolkitsc.api.widgets.UIFactory;
import gr.istl.virtualtoolkitsc.api.widgets.UIFactory.Architecture;

public class Main {

	public static void main(String[] args) {

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

		UIFactory factory = UIFactory.getFactory(Architecture.SWING);

		AbstractWindow window = factory.createWindow();
		AbstractFlowPanel panel = factory.createFlowPanel();
		AbstractButton button = factory.createButton("button_1", db);

		button.addAbstractMouseListener(factory.createButtonHandler(button));

		panel.addButton(button);
		window.addPanel(panel);

		window.setVisible(true);

	}

}
