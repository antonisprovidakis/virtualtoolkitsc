package gr.teicrete.ie.oop2.gwtswingsync.api.widgets;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

import gr.teicrete.ie.oop2.gwtswingsync.api.listeners.AbstractClickListener;

public class GWTButton extends Button implements AbstractButton {

	@Override
	public void setButtonText(String text) {
		setText(text);
	}

	@Override
	public void addAbstractClickListener(AbstractClickListener listener) {
		addClickHandler((ClickHandler)listener);
	}

}
