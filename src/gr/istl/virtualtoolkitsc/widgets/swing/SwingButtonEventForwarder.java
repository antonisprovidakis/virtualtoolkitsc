package gr.istl.virtualtoolkitsc.widgets.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionEvent;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;

public class SwingButtonEventForwarder implements ActionListener {

	private SwingButton button;

	public SwingButtonEventForwarder(SwingButton button) {
		this.button = button;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		VirtualActionEvent virtualEvent = SwingEventPackager.convert(event);

		ArrayList<VirtualActionListener> listeners = button.getVirtualActionListeners();

		for (VirtualActionListener listener : listeners) {
			listener.actionPerformed(virtualEvent);
		}
	}

}
