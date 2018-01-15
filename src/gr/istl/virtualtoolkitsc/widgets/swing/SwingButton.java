package gr.istl.virtualtoolkitsc.widgets.swing;

import java.util.ArrayList;

import javax.swing.AbstractButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import gr.istl.virtualtoolkitsc.api.firebase.FirebaseSyncManager;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public class SwingButton extends SwingComponent implements VirtualButton {

	private boolean isCollaborativeText = false;

	private ArrayList<VirtualActionListener> vActionListeners = new ArrayList<VirtualActionListener>();

	public SwingButton(AbstractButton button) {
		super(button);
	}

	@Override
	protected void init() {
		super.init();
		getButton().addActionListener(new SwingButtonEventForwarder(this));
	}

	public AbstractButton getButton() {
		return (AbstractButton) component;
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

		getButton().setText(text);

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
		return getButton().getText();
	}

	@Override
	public boolean isPressed() {
		return getButton().getModel().isPressed();
	}

	@Override
	public void setPressed(boolean pressed) {
		getButton().getModel().setPressed(pressed);

		// if (VirtualToolkit.isCollaborative()) {
		// FirebaseSyncManager firebaseSyncManager = FirebaseSyncManager.getInstance();
		// DatabaseReference dbRef =
		// firebaseSyncManager.getDBRefForWidgetId(getUniversalWidgetId());
		//
		// System.out.println("in setPressed inSync: " + firebaseSyncManager);
		//
		// dbRef.setValueAsync(pressed);
		// }

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
