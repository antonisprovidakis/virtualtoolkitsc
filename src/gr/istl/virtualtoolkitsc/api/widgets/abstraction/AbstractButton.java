package gr.istl.virtualtoolkitsc.api.widgets.abstraction;

import com.google.firebase.database.DatabaseReference;

import gr.istl.virtualtoolkitsc.api.listeners.abstraction.AbstractButtonHandler;

public interface AbstractButton {

	public void setButtonText(String text);
	
	public String getButtonText();

	public void addAbstractMouseListener(AbstractButtonHandler buttonHandler);
	
	public DatabaseReference getDbRef();

}
