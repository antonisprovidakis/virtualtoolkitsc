package gr.istl.virtualtoolkitsc.api.widgets.gwt;

import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.ui.Button;

import gr.istl.virtualtoolkitsc.api.listeners.abstraction.AbstractButtonHandler;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractButton;

public class GWTButton extends Button implements AbstractButton {

	@Override
	public void setButtonText(String text) {
		setText(text);
	}

	@Override
	public void addAbstractMouseListener(AbstractButtonHandler buttonHandler) {
		addMouseUpHandler((MouseUpHandler) buttonHandler);
		addMouseDownHandler((MouseDownHandler) buttonHandler);
	}

}
