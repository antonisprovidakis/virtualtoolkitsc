package gr.istl.virtualtoolkitsc.swing.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import gr.istl.virtualtoolkitsc.api.factories.abstraction.UIFactory;
import gr.istl.virtualtoolkitsc.api.factories.abstraction.UIFactory.Architecture;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractWindow;

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
