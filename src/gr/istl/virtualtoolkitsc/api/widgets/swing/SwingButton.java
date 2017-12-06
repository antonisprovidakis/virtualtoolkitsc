package gr.istl.virtualtoolkitsc.api.widgets.swing;

import java.awt.event.MouseListener;

import javax.swing.JButton;

import gr.istl.virtualtoolkitsc.api.listeners.abstraction.AbstractButtonHandler;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractButton;

public class SwingButton extends JButton implements AbstractButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1765731638488874096L;

	public SwingButton() {
		super();
	}

	@Override
	public void setButtonText(String text) {
		setText(text);
	}

	@Override
	public void addAbstractMouseListener(AbstractButtonHandler buttonHandler) {
		addMouseListener((MouseListener) buttonHandler);
	}

	// @Override
	// public void addAbstractMouseListener(AbstractMouseListener listener) {
	// addActionListener((ActionListener)listener);
	// }

}
