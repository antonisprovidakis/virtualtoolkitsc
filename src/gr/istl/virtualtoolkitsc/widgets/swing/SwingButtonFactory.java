package gr.istl.virtualtoolkitsc.widgets.swing;

import javax.swing.JButton;

import gr.istl.virtualtoolkitsc.widgets.ButtonFactory;
import gr.istl.virtualtoolkitsc.widgets.VirtualButton;

public class SwingButtonFactory implements ButtonFactory {

	@Override
	public VirtualButton createButton(String text) {
		JButton button = new JButton(text);
		return new SwingButton(button);
	}

	@Override
	public VirtualButton createButton() {
		JButton button = new JButton();
		return new SwingButton(button);
	}

}
