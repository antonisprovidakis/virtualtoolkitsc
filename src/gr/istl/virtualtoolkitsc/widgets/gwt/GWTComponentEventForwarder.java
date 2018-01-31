package gr.istl.virtualtoolkitsc.widgets.gwt;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualFocusEvent;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualFocusListener;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseEvent;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;
import gr.istl.virtualtoolkitsc.widgets.awt.AWTEventPackager;

public class GWTComponentEventForwarder implements MouseDownHandler, MouseUpHandler, FocusHandler, BlurHandler {

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

	@Override
	public void onFocus(FocusEvent event) {
		VirtualFocusEvent virtualFocusEvent = GWTEventPackager.convert(event, VirtualFocusEvent.Focus_gain);

		ArrayList<VirtualFocusListener> listeners = component.getVirtualFocusListeners();

		for (VirtualFocusListener listener : listeners) {
			listener.focusGained(virtualFocusEvent);
		}
	}

	@Override
	public void onBlur(BlurEvent event) {
		VirtualFocusEvent virtualFocusEvent = GWTEventPackager.convert(event, VirtualFocusEvent.Focus_lost);

		ArrayList<VirtualFocusListener> listeners = component.getVirtualFocusListeners();

		for (VirtualFocusListener listener : listeners) {
			listener.focusLost(virtualFocusEvent);
		}
	}

}
