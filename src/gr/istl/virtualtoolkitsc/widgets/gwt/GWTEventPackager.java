package gr.istl.virtualtoolkitsc.widgets.gwt;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionEvent;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseEvent;
import gr.istl.virtualtoolkitsc.widgets.UniversalWidget;

public class GWTEventPackager {
	public static VirtualActionEvent convert(ClickEvent event) {
		VirtualActionEvent virtualActionEvent = new VirtualActionEvent();
		virtualActionEvent.setSource(UniversalWidget.universalWidget(event.getSource()));
		return virtualActionEvent;
	}

	public static VirtualActionEvent convert(ValueChangeEvent<String> event) {
		return new VirtualActionEvent();
	}

	public static VirtualMouseEvent convert(MouseMoveEvent event, int type) {
		return new VirtualMouseEvent(type);
	}

	public static VirtualMouseEvent convert(MouseUpEvent event, int type) {
		VirtualMouseEvent virtualMouseEvent = new VirtualMouseEvent(type);

		virtualMouseEvent.setX(event.getX());
		virtualMouseEvent.setY(event.getY());
		virtualMouseEvent.setXOnScreen(event.getScreenX());
		virtualMouseEvent.setYOnScreen(event.getScreenY());
		virtualMouseEvent.setSource(UniversalWidget.universalWidget(event.getSource()));

		return virtualMouseEvent;
	}

	public static VirtualMouseEvent convert(MouseDownEvent event, int type) {
		VirtualMouseEvent virtualMouseEvent = new VirtualMouseEvent(type);

		virtualMouseEvent.setX(event.getX());
		virtualMouseEvent.setY(event.getY());
		virtualMouseEvent.setXOnScreen(event.getScreenX());
		virtualMouseEvent.setYOnScreen(event.getScreenY());
		virtualMouseEvent.setSource(UniversalWidget.universalWidget(event.getSource()));

		return virtualMouseEvent;
	}
}
