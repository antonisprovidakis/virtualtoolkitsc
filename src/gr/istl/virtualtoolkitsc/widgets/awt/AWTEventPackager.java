package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionEvent;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseEvent;
import gr.istl.virtualtoolkitsc.widgets.UniversalWidget;

public class AWTEventPackager {

	public static VirtualActionEvent convert(ActionEvent event) {
		VirtualActionEvent virtualActionEvent = new VirtualActionEvent();

		virtualActionEvent.setActionCommand(event.getActionCommand());
		virtualActionEvent.setModifies(event.getModifiers());
		virtualActionEvent.setWhen(event.getWhen());
		virtualActionEvent.setType(event.getID());
		virtualActionEvent.setSource(UniversalWidget.universalWidget(event.getSource()));

		return virtualActionEvent;
	}

	public static VirtualMouseEvent convert(MouseEvent event, int type) {
		VirtualMouseEvent virtualMouseEvent = new VirtualMouseEvent(type);

		virtualMouseEvent.setButton(event.getButton());
		virtualMouseEvent.setWhen(event.getWhen());
		virtualMouseEvent.setModifiers(event.getModifiers());
		virtualMouseEvent.setX(event.getX());
		virtualMouseEvent.setY(event.getY());
		virtualMouseEvent.setXOnScreen(event.getXOnScreen());
		virtualMouseEvent.setYOnScreen(event.getYOnScreen());
		virtualMouseEvent.setIsPopupTrigger(event.isPopupTrigger());
		virtualMouseEvent.setLocationOnScreen(event.getLocationOnScreen());
		virtualMouseEvent.setParamString(event.paramString());
		virtualMouseEvent.setSource(UniversalWidget.universalWidget(event.getSource()));

		return virtualMouseEvent;
	}

}
