package gr.teicrete.ie.oop2.gwtswingsync.api.widgets;

import gr.teicrete.ie.oop2.gwtswingsync.api.listeners.AbstractClickListener;
import gr.teicrete.ie.oop2.gwtswingsync.api.listeners.AbstractEvent;

public interface AbstractButton {

	public void setButtonText(String text);

	public void addAbstractClickListener(AbstractClickListener listener);

}
