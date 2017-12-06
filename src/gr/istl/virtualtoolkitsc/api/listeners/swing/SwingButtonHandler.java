package gr.istl.virtualtoolkitsc.api.listeners.swing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import gr.istl.virtualtoolkitsc.api.listeners.abstraction.AbstractButtonHandler;

public class SwingButtonHandler extends AbstractButtonHandler implements MouseListener {
	private final JButton button;
	
	
	public SwingButtonHandler(JButton button) {
		this.button = button;
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
		System.out.println("mouse pressed on button: " + button.getText());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouse released on button: " + button.getText());
	}

}
