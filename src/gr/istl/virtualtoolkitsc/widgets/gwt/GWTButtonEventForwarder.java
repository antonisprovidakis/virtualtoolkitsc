package gr.istl.virtualtoolkitsc.widgets.gwt;

import java.util.ArrayList;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionEvent;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;

public class GWTButtonEventForwarder implements ClickHandler /*, MouseMoveHandler*/ {

	private GWTButton button;

	public GWTButtonEventForwarder(GWTButton button) {
		this.button = button;
	}

	@Override
	public void onClick(ClickEvent event) {
		VirtualActionEvent virtualEvent = GWTEventPackager.convert(event);

		ArrayList<VirtualActionListener> listeners = button.getVirtualActionListeners();

		for (VirtualActionListener listener : listeners) {
			listener.actionPerformed(virtualEvent);
		}
	}

//	@Override
//	public void onMouseMove(MouseMoveEvent event) {
//		VirtualMouseEvent virtualEvent = GWTEventPackager.convert(event, VirtualMouseEvent.Mouse_Move);
//
//		ArrayList<VirtualMouseMoveListener> listeners = button.getVirtualMouseMoveListeners();
//
//		for (VirtualMouseMoveListener listener : listeners) {
//			listener.mouseMoved(virtualEvent);
//		}
//
//	}

}
