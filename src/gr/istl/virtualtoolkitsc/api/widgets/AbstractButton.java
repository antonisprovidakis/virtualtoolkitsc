package gr.istl.virtualtoolkitsc.api.widgets;

import gr.istl.virtualtoolkitsc.api.listeners.AbstractClickListener;
import gr.istl.virtualtoolkitsc.api.listeners.AbstractEvent;

public interface AbstractButton {

	public void setButtonText(String text);

	public void addAbstractClickListener(AbstractClickListener listener);

}
