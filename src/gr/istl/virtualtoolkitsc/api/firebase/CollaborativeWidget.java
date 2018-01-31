package gr.istl.virtualtoolkitsc.api.firebase;

public interface CollaborativeWidget {

	/**
	 * This method gets called after a Firebase property has been updated and it's
	 * responsible to redirect new value to the appropriate mutator method
	 * 
	 * @param propertyName
	 *            The name of the changed property
	 * @param newValue
	 *            The new value of the changed property
	 */
	public void collaborativePropertyChanged(String propertyName, Object newValue);

}
