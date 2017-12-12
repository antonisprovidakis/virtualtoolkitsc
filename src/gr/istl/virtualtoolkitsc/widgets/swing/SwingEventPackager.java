package gr.istl.virtualtoolkitsc.widgets.swing;

import java.awt.event.ActionEvent;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionEvent;
import gr.istl.virtualtoolkitsc.widgets.UniversalWidget;

public class SwingEventPackager {
	
	public static VirtualActionEvent convert(ActionEvent event) {	
		VirtualActionEvent virtualActionEvent = new VirtualActionEvent();

		virtualActionEvent.setActionCommand(event.getActionCommand());
		virtualActionEvent.setModifies(event.getModifiers());
		virtualActionEvent.setWhen(event.getWhen());
		virtualActionEvent.setType(event.getID());
		virtualActionEvent.setSource(UniversalWidget.universalWidget(event.getSource()));

		return virtualActionEvent;
	}
}
