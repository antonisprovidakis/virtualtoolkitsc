package gr.teicrete.ie.oop2.gwtswingsync.api.widgets;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import gr.teicrete.ie.oop2.gwtswingsync.api.listeners.AbstractClickListener;

public class SwingButton extends JButton implements AbstractButton{
	
	public SwingButton() {
		super();
	}

	@Override
	public void setButtonText(String text) {
		setText(text);
	}
	
	@Override
	public void addAbstractClickListener(AbstractClickListener listener) {
		addActionListener((ActionListener)listener);
	}

}
