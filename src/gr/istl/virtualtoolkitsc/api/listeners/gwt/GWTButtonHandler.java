package gr.istl.virtualtoolkitsc.api.listeners.gwt;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.ui.Button;

import gr.istl.virtualtoolkitsc.api.listeners.abstraction.AbstractButtonHandler;

public class GWTButtonHandler extends AbstractButtonHandler implements MouseDownHandler, MouseUpHandler {
	
	private final Button button;
	
	public GWTButtonHandler(Button button) {
		this.button = button;
	}

	@Override
	public void onMouseDown(MouseDownEvent e) {
		Button b = (Button) e.getSource();
		GWT.log("mouse pressed on button: " + b.getText());
	}

	@Override
	public void onMouseUp(MouseUpEvent e) {
		GWT.log("mouse released on button: " + button.getText());
	}

}
