package gr.istl.virtualtoolkitsc.api.widgets.abstraction;

import gr.istl.virtualtoolkitsc.api.listeners.abstraction.AbstractButtonHandler;

public interface AbstractButton {

	public void setButtonText(String text);

	public void addAbstractMouseListener(AbstractButtonHandler buttonHandler);

}
