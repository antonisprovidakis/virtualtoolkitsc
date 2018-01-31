package gr.istl.virtualtoolkitsc.api.firebase.gwt;

import com.github.spirylics.xgwt.essential.Fn.Arg;
import com.github.spirylics.xgwt.firebase.database.XDataSnapshot;

import gr.istl.virtualtoolkitsc.api.firebase.CollaborativeWidget;

public class GWTFirebaseValueEventHandler implements Arg<XDataSnapshot> {
	private final CollaborativeWidget cw;
	private final String propertyName;

	public GWTFirebaseValueEventHandler(CollaborativeWidget cw, String propertyName) {
		this.cw = cw;
		this.propertyName = propertyName;
	}

	@Override
	public void e(XDataSnapshot xData) {
		if (xData.dataSnapshot.val() != null) {
			cw.collaborativePropertyChanged(propertyName, xData.dataSnapshot.val());
		}
	}

}