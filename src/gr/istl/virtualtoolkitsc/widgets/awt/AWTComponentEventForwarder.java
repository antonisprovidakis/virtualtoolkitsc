package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseEvent;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;

public class AWTComponentEventForwarder implements MouseListener {

	private AWTComponent component;

	public AWTComponentEventForwarder(AWTComponent c) {
		component = c;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event, VirtualMouseEvent.MouseClick);

		ArrayList<VirtualMouseListener> listeners = component.getVirtualMouseListeners();

		for (VirtualMouseListener listener : listeners) {
			listener.mouseClicked(virtualEvent);
		}
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event, VirtualMouseEvent.MouseEnter);

		ArrayList<VirtualMouseListener> listeners = component.getVirtualMouseListeners();

		for (VirtualMouseListener listener : listeners) {
			listener.mouseEntered(virtualEvent);
		}
	}

	@Override
	public void mouseExited(MouseEvent event) {
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event, VirtualMouseEvent.MouseExit);

		ArrayList<VirtualMouseListener> listeners = component.getVirtualMouseListeners();

		for (VirtualMouseListener listener : listeners) {
			listener.mouseExited(virtualEvent);
		}
	}

	@Override
	public void mousePressed(MouseEvent event) {
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event, VirtualMouseEvent.MouseDown);

		ArrayList<VirtualMouseListener> listeners = component.getVirtualMouseListeners();

		for (VirtualMouseListener listener : listeners) {
			listener.mousePressed(virtualEvent);
		}
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event, VirtualMouseEvent.MouseUp);

		ArrayList<VirtualMouseListener> listeners = component.getVirtualMouseListeners();

		for (VirtualMouseListener listener : listeners) {
			listener.mouseReleased(virtualEvent);
		}
	}

}
