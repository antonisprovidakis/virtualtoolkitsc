package gr.istl.virtualtoolkitsc.api.listeners.swing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import gr.istl.virtualtoolkitsc.api.listeners.abstraction.AbstractButtonHandler;
import gr.istl.virtualtoolkitsc.api.widgets.swing.SwingButton;

public class SwingButtonHandler extends AbstractButtonHandler implements MouseListener {

	public SwingButtonHandler(SwingButton button) {
		super(button);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		getButton().getDbRef().setValueAsync(true);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		getButton().getDbRef().setValueAsync(false);
	}

}
