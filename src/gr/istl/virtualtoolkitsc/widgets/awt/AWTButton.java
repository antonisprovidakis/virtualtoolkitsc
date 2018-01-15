package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.Button;
import java.util.ArrayList;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import gr.istl.virtualtoolkitsc.api.firebase.FirebaseSyncManager;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public class AWTButton extends AWTComponent implements VirtualButton {

	private boolean isCollaborativeText = false;

	private ArrayList<VirtualActionListener> vActionListeners = new ArrayList<VirtualActionListener>();

	public AWTButton(Button button) {
		super(button);
	}

	@Override
	protected void init() {
		super.init();
		getButton().addActionListener(new AWTButtonEventForwarder(this));
	}

	public Button getButton() {
		return (Button) component;
	}

	@Override
	public void addActionListener(VirtualActionListener listener) {
		vActionListeners.add(listener);
	}

	@Override
	public ArrayList<VirtualActionListener> getVirtualActionListeners() {
		return vActionListeners;
	}

	@Override
	public void setText(String text) {
		String oldText = getText();

		getButton().setLabel(text);

		if (isCollaborativeText && VirtualToolkit.isCollaborative()) {
			if (!oldText.equals(text)) {
				FirebaseSyncManager firebaseSyncManager = FirebaseSyncManager.getInstance();
				DatabaseReference dbRef = firebaseSyncManager.getDBRefForWidgetId(getUniversalWidgetId());

				dbRef.child("text").setValueAsync(text);
			}
		}
	}

	@Override
	public String getText() {
		return getButton().getLabel();
	}

	@Override
	public boolean isPressed() {

		// TODO: implement
		return false;
	}

	@Override
	public void setPressed(boolean pressed) {
		// TODO: implement
	}

	@Override
	public void addStyleName(String name) {
	}

	@Override
	public void removeStyleName(String name) {
	}

	@Override
	public boolean isCollaborativeText() {
		return isCollaborativeText;
	}

	@Override
	public void setIsCollaborativeText(boolean collabText) {
		isCollaborativeText = collabText;

		if (collabText == true) {
			if (VirtualToolkit.isCollaborative()) {
				FirebaseSyncManager firebaseSyncManager = FirebaseSyncManager.getInstance();
				DatabaseReference dbRef = firebaseSyncManager.getDBRefForWidgetId(getUniversalWidgetId());

				dbRef.child("text").addValueEventListener(new ValueEventListener() {

					@Override
					public void onDataChange(DataSnapshot data) {
						// setText(data.getValue(String.class));
						String text = data.getValue(String.class);

						if (text != null) {
							setText(text);
						}
					}

					@Override
					public void onCancelled(DatabaseError arg0) {
					}
				});

			}
		}

	}

}
