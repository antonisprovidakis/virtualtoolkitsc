package gr.istl.virtualtoolkitsc.api.firebase.gwt;

import java.util.HashMap;
import java.util.Map;

import com.github.spirylics.xgwt.firebase.Config;
import com.github.spirylics.xgwt.firebase.Firebase;
import com.github.spirylics.xgwt.firebase.database.Database;
import com.github.spirylics.xgwt.firebase.database.Reference;

import gr.istl.virtualtoolkitsc.api.firebase.FirebasePropertiesManager;
import gr.istl.virtualtoolkitsc.api.firebase.FirebaseSyncManager;

public class GWTFirebaseSyncManager extends FirebaseSyncManager {

	private final static String SESSION_ID = "session1";

	private transient Map<String, Reference> widgetIdToDatabaseReference = new HashMap<String, Reference>();
	private Database database = null;

	public GWTFirebaseSyncManager() {
		super();
		database = createDatabase();
	}

	private Database createDatabase() {
		Config config = new Config();

		// UPDATE MANUALLY
		config.setApiKey("some_api_key");
		config.setAuthDomain("some_auth_domain");
		config.setDatabaseURL("some_database_url");
		config.setStorageBucket("some_storage_bucket");

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
