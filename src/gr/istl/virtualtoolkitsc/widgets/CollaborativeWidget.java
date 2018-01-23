package gr.istl.virtualtoolkitsc.widgets;

import java.beans.PropertyChangeListener;

public interface CollaborativeWidget extends PropertyChangeListener {

	// FROM PropertyChangeListener interface
	//
	// public void propertyChange(PropertyChangeEvent evt);

	/**
	 * This method gets called after a Firebase property has been updated and it's
	 * responsible to redirect new value to the appropriate mutator method
	 * 
	 * @param propertyName
	 *            The name of the changed property
	 * @param newValue
	 *            The new value of the changed property
	 */
	public void updateLocalUI(String propertyName, Object newValue);

}
