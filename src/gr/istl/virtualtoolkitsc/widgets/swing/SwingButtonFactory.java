package gr.istl.virtualtoolkitsc.widgets.swing;

import gr.istl.virtualtoolkitsc.widgets.ButtonFactory;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;

public class SwingButtonFactory implements ButtonFactory {

	@Override
	public VirtualButton createButton(String text) {
		return new SwingButton(text);
	}

	@Override
	public VirtualButton createButton() {
		return new SwingButton();
	}

}
