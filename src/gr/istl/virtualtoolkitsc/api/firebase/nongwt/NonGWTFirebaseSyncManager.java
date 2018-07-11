package gr.istl.virtualtoolkitsc.api.firebase.nongwt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import gr.istl.virtualtoolkitsc.api.firebase.FirebasePropertiesManager;
import gr.istl.virtualtoolkitsc.api.firebase.FirebaseSyncManager;

public class NonGWTFirebaseSyncManager extends FirebaseSyncManager {

	// UPDATE MANUALLY
 	// found in project root folder level, replace with your own
	private final static String CREDENTIALS_PATH = "path/to/serviceAccountKey.json";
	// replace with your own project database url
	private final static String DB_URL = "https://[projectId].firebaseio.com/";
	
	private final static String SESSION_ID = "session1";

	private transient Map<String, DatabaseReference> widgetIdToDatabaseReference = new HashMap<String, DatabaseReference>();
	private FirebaseDatabase database = null;

	public NonGWTFirebaseSyncManager() {
		super();
		database = createDatabase();
	}

	@Override
	public FirebasePropertiesManager createFirebasePropertiesManager() {
		return new NonGWTFirebasePropertiesManager();
	}

	private FirebaseDatabase createDatabase() {
		try {
			FileInputStream serviceAccount = new FileInputStream(CREDENTIALS_PATH);
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl(DB_URL).build();
			FirebaseApp defaultApp = FirebaseApp.initializeApp(options);
			return FirebaseDatabase.getInstance(defaultApp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Credentials File not found.");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO error.");
			System.exit(1);
		}

		return null;
	}

	@Override
	public void addWidgetIdIntoWidgetIdToDatabaseReferenceMap(String widgetId) {
		DatabaseReference dbRef = database.getReference("/" + SESSION_ID + "/" + widgetId);
		widgetIdToDatabaseReference.put(widgetId, dbRef);
	}

	@Override
	public Object getDBRefForWidgetId(String widgetId) {
		return widgetIdToDatabaseReference.get(widgetId);
	}

}
