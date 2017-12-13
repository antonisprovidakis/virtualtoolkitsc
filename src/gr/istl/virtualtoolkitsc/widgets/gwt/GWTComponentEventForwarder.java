package gr.istl.virtualtoolkitsc.widgets.gwt;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseEvent;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;

public class GWTComponentEventForwarder implements MouseDownHandler, MouseUpHandler {

	private GWTComponent component;

	public GWTComponentEventForwarder(GWTComponent c) {
		component = c;
	}

	@Override
	public void onMouseUp(MouseUpEvent event) {

		VirtualMouseEvent virtualMouseEvent = GWTEventPackager.convert(event, VirtualMouseEvent.MouseUp);

		ArrayList<VirtualMouseListener> listeners = component.getVirtualMouseListeners();

		for (VirtualMouseListener listener : listeners) {
			listener.mouseReleased(virtualMouseEvent);
		}
	}

	@Override
	public void onMouseDown(MouseDownEvent event) {
		VirtualMouseEvent virtualMouseEvent = GWTEventPackager.convert(event, VirtualMouseEvent.MouseDown);

		ArrayList<VirtualMouseListener> listeners = component.getVirtualMouseListeners();

		for (VirtualMouseListener listener : listeners) {
			listener.mousePressed(virtualMouseEvent);
		}
	}

}
