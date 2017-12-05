package gr.istl.virtualtoolkitsc.api.widgets;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

import gr.istl.virtualtoolkitsc.api.listeners.AbstractClickListener;

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
