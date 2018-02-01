package gr.istl.virtualtoolkitsc.api.firebase.nongwt;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import gr.istl.virtualtoolkitsc.api.firebase.CollaborativeWidget;

public final class NonGWTFirebaseValueEventHandler implements ValueEventListener {

	private final CollaborativeWidget cw;
	private final String propertyName;

	public NonGWTFirebaseValueEventHandler(CollaborativeWidget cw, String propertyName) {
		this.cw = cw;
		this.propertyName = propertyName;
	}

	@Override
	public void onDataChange(DataSnapshot snapshot) {
		if (snapshot.getValue() != null) {
			cw.collaborativePropertyChanged(propertyName, snapshot.getValue());
		}
	}

	@Override
	public void onCancelled(DatabaseError error) {
	}

}
