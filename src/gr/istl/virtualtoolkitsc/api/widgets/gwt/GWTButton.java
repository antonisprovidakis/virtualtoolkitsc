package gr.istl.virtualtoolkitsc.api.widgets.gwt;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.ui.Button;

import gr.istl.virtualtoolkitsc.api.listeners.AbstractButtonHandler;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractButton;

public class GWTButton extends Button implements AbstractButton {
	private final DatabaseReference dbRef = null;
	
	public GWTButton(String text, FirebaseDatabase db) {
		super(text);
		// TODO: connect to db reference
	}
	
	@Override
	public void setButtonText(String text) {
		setText(text);
	}
	
	@Override
	public String getButtonText() {
		return getText();
	}

	@Override
	public void addAbstractMouseListener(AbstractButtonHandler buttonHandler) {
		addMouseUpHandler((MouseUpHandler) buttonHandler);
		addMouseDownHandler((MouseDownHandler) buttonHandler);
	}
	
	@Override
	public DatabaseReference getDbRef() {
		return dbRef;
	}

}
