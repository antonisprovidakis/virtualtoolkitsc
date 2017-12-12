package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

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

		Iterator<VirtualMouseListener> listeners = component.getVirtualMouseListeners().iterator();

		while (listeners.hasNext()) {
			VirtualMouseListener listener = listeners.next();
			listener.mouseClicked(virtualEvent);
		}
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event, VirtualMouseEvent.MouseEnter);

		Iterator<VirtualMouseListener> listeners = component.getVirtualMouseListeners().iterator();

		while (listeners.hasNext()) {
			VirtualMouseListener listener = listeners.next();
			listener.mouseEntered(virtualEvent);
		}
	}

	@Override
	public void mouseExited(MouseEvent event) {
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event, VirtualMouseEvent.MouseExit);

		Iterator<VirtualMouseListener> listeners = component.getVirtualMouseListeners().iterator();

		while (listeners.hasNext()) {
			VirtualMouseListener listener = listeners.next();
			listener.mouseExited(virtualEvent);
		}
	}

	@Override
	public void mousePressed(MouseEvent event) {
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event, VirtualMouseEvent.MouseDown);

		Iterator<VirtualMouseListener> listeners = component.getVirtualMouseListeners().iterator();

		while (listeners.hasNext()) {
			VirtualMouseListener listener = listeners.next();
			listener.mousePressed(virtualEvent);
		}
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		VirtualMouseEvent virtualEvent = AWTEventPackager.convert(event, VirtualMouseEvent.MouseUp);

		Iterator<VirtualMouseListener> listeners = component.getVirtualMouseListeners().iterator();

		while (listeners.hasNext()) {
			VirtualMouseListener listener = listeners.next();
			listener.mouseReleased(virtualEvent);
		}
	}

}
