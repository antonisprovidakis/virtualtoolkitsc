package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionEvent;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;

public class AWTButtonEventForwarder implements ActionListener {
	private AWTButton button;

	public AWTButtonEventForwarder(AWTButton button) {
		this.button = button;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		VirtualActionEvent virtualEvent = AWTEventPackager.convert(event);

		Iterator<VirtualActionListener> listeners = button.getVirtualActionListeners().iterator();
		while (listeners.hasNext()) {
			VirtualActionListener listener = listeners.next();
			listener.actionPerformed(virtualEvent);
		}
	}

}
