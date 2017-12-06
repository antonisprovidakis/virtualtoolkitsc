package gr.istl.virtualtoolkitsc.api.widgets.swing;

import java.awt.event.MouseListener;

import javax.swing.JButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import gr.istl.virtualtoolkitsc.api.listeners.abstraction.AbstractButtonHandler;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractButton;

public class SwingButton extends JButton implements AbstractButton {

	private final DatabaseReference dbRef;

	/**
	 * 
	 */
	private static final long serialVersionUID = -1765731638488874096L;

	public SwingButton(String text, FirebaseDatabase db) {
		super(text);

		dbRef = db.getReference("session_1/" + getButtonText());

		dbRef.addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				getModel().setPressed((boolean) snapshot.getValue());
			}

			@Override
			public void onCancelled(DatabaseError error) {
			}
		});
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
		addMouseListener((MouseListener) buttonHandler);
	}

	@Override
	public DatabaseReference getDbRef() {
		return dbRef;
	}

}
