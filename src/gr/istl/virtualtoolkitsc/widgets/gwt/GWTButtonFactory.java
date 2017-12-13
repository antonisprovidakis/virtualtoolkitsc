package gr.istl.virtualtoolkitsc.widgets.gwt;

import com.google.gwt.user.client.ui.Button;

import gr.istl.virtualtoolkitsc.widgets.ButtonFactory;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;

public class GWTButtonFactory implements ButtonFactory {

	@Override
	public VirtualButton createButton(String text) {
		Button button = new Button(text);
		return new GWTButton(button);
	}

	@Override
	public VirtualButton createButton() {
		Button button = new Button();
		return new GWTButton(button);
	}

}
