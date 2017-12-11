package gr.istl.virtualtoolkitsc.widgets.swing;

import java.awt.event.ActionEvent;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionEvent;

public class SwingEventPackager {
	public static VirtualActionEvent convert(ActionEvent event) {
		VirtualActionEvent virtualActionEvent = new VirtualActionEvent();

		virtualActionEvent.setActionCommand(event.getActionCommand());
		virtualActionEvent.setModifies(event.getModifiers());
		virtualActionEvent.setWhen(event.getWhen());
		virtualActionEvent.setType(event.getID());
		virtualActionEvent.setSource(event.getSource());

		return virtualActionEvent;
	}
}
