package gr.istl.virtualtoolkitsc.api.firebase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseSyncManager {

	private final static String CREDENTIALS_PATH = "virtualtoolkitsc-firebase-credentials.json";
	private final static String DB_URL = "https://virtualtoolkitsc.firebaseio.com/";
	private final static String SESSION_ID = "session1";

	private static transient HashMap<String, DatabaseReference> widgetIdToDatabaseReference = new HashMap<String, DatabaseReference>();

	private FirebaseDatabase database = null;

	private static FirebaseSyncManager instance = null;

	private FirebaseSyncManager() {
		init();
	}

	private void init() {
		try {
			FileInputStream serviceAccount = new FileInputStream(CREDENTIALS_PATH);
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl(DB_URL).build();
			FirebaseApp defaultApp = FirebaseApp.initializeApp(options);
			database = FirebaseDatabase.getInstance(defaultApp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Credentials File not found.");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO error.");
			System.exit(1);
		}

	}

	public static FirebaseSyncManager getInstance() {
		if (instance == null) {
			instance = new FirebaseSyncManager();
		}

		return instance;
	}

	public void addWidgetIdToWidgetIdToDatabaseReferenceMap(String widgetId) {
		DatabaseReference dbRef = createDBRefForWidgetId(widgetId);
		widgetIdToDatabaseReference.put(widgetId, dbRef);
	}

	// public FirebaseDatabase getDB() {
	// return database;
	// }

	public DatabaseReference getDBRefForWidgetId(String widgetId) {
		return widgetIdToDatabaseReference.get(widgetId);
	}

	private DatabaseReference createDBRefForWidgetId(String widgetId) {
		return database.getReference("/" + SESSION_ID + "/" + widgetId);
	}

}
