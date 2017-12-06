package gr.istl.virtualtoolkitsc.api.listeners.gwt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import gr.istl.virtualtoolkitsc.api.listeners.abstraction.AbstractButtonHandler;
import gr.istl.virtualtoolkitsc.api.widgets.gwt.GWTButton;

public class GWTButtonHandler extends AbstractButtonHandler implements MouseDownHandler, MouseUpHandler {

	public GWTButtonHandler(GWTButton button) {
		super(button);
	}

	@Override
	public void onMouseDown(MouseDownEvent e) {
		GWT.log("mouse pressed on button: " + getButton().getButtonText());
	}

	@Override
	public void onMouseUp(MouseUpEvent e) {
		GWT.log("mouse released on button: " + getButton().getButtonText());
	}

}
