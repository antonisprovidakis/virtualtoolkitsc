package gr.istl.virtualtoolkitsc.api.listeners;

public interface VirtualMouseListener extends VirtualListener {
	public void mousePressed(VirtualMouseEvent e);

	public void mouseReleased(VirtualMouseEvent e);

	public void mouseExited(VirtualMouseEvent e);

	public void mouseEntered(VirtualMouseEvent e);

	public void mouseClicked(VirtualMouseEvent e);

	// public void mouseDown(VirtualMouseEvent e);

	// public void mouseUp(VirtualMouseEvent e);

	// public void mouseDoubleClick(VirtualMouseEvent e);

	// public void mouseExit(VirtualMouseEvent e);

	// public void mouseEnter(VirtualMouseEvent e);

	// public void mouseHover(VirtualMouseEvent e);

}
