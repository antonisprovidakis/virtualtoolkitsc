package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.Button;

import gr.istl.virtualtoolkitsc.widgets.ButtonFactory;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;

public class AWTButtonFactory implements ButtonFactory {

	@Override
	public VirtualButton createButton(String text) {
		Button button = new Button(text);
		return new AWTButton(button);
	}

	@Override
	public VirtualButton createButton() {
		Button button = new Button();
		return new AWTButton(button);
	}

}
