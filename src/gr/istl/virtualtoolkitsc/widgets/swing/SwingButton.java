package gr.istl.virtualtoolkitsc.widgets.swing;

import java.util.ArrayList;

import javax.swing.AbstractButton;

import com.google.firebase.database.DatabaseReference;

import gr.istl.virtualtoolkitsc.api.firebase.FirebaseSyncManager;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;
import gr.istl.virtualtoolkitsc.widgets.VirtualToolkit;

public class SwingButton extends SwingComponent implements VirtualButton {

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
		getButton().setText(text);
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

//		if (VirtualToolkit.isInSync()) {
//			FirebaseSyncManager firebaseSyncManager = FirebaseSyncManager.getInstance();
//			DatabaseReference dbRef = firebaseSyncManager.getDBRefForWidgetId(getUniversalWidgetId());
//			
//			System.out.println("in setPressed inSync: " + firebaseSyncManager);
//
//			dbRef.setValueAsync(pressed);
//		}

	}

	@Override
	public void addStyleName(String name) {
	}

	@Override
	public void removeStyleName(String name) {
	}
}
