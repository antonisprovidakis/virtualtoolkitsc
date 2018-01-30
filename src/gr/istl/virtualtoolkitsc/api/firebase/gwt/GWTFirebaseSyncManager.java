package gr.istl.virtualtoolkitsc.api.firebase.gwt;

import java.util.HashMap;

import com.github.spirylics.xgwt.firebase.Config;
import com.github.spirylics.xgwt.firebase.Firebase;
import com.github.spirylics.xgwt.firebase.database.Database;
import com.github.spirylics.xgwt.firebase.database.Reference;

import gr.istl.virtualtoolkitsc.api.firebase.FirebasePropertiesManager;
import gr.istl.virtualtoolkitsc.api.firebase.FirebaseSyncManager;

public class GWTFirebaseSyncManager extends FirebaseSyncManager {

	private final static String SESSION_ID = "session1";

	private transient HashMap<String, Reference> widgetIdToDatabaseReference = new HashMap<String, Reference>();
	private Database database = null;

	public GWTFirebaseSyncManager() {
		super();
		database = createDatabase();
	}

	private Database createDatabase() {
		Config config = new Config();
		config.setApiKey("AIzaSyAA_xSvC043XQeOpAbW-f3O7LUGQIcz3bA");
		config.setAuthDomain("virtualtoolkitsc.firebaseapp.com");
		config.setDatabaseURL("https://virtualtoolkitsc.firebaseio.com");
		config.setStorageBucket("virtualtoolkitsc.appspot.com");

		Firebase firebase = Firebase.initializeApp(config);

		return firebase.database();
	}

	@Override
	public FirebasePropertiesManager createFirebasePropertiesManager() {
		return new GWTFirebasePropertiesManager();
	}

	@Override
	public void addWidgetIdIntoWidgetIdToDatabaseReferenceMap(String widgetId) {
		Reference dbRef = database.ref("/" + SESSION_ID + "/" + widgetId);
		widgetIdToDatabaseReference.put(widgetId, dbRef);
	}

	@Override
	public Object getDBRefForWidgetId(String widgetId) {
		return widgetIdToDatabaseReference.get(widgetId);
	}

}
