package gr.istl.virtualtoolkitsc.widgets;

import java.util.ArrayList;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualFocusListener;
import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;

public interface VirtualComponent {

	public Object getPhysicalComponent();

	public int getHeight();

	public int getWidth();

	public void setSize(int width, int height);

	public String getName();

	public void setName(String name);

	public void addMouseListener(VirtualMouseListener listener);

	public ArrayList<VirtualMouseListener> getVirtualMouseListeners();

	public void addFocusListener(VirtualFocusListener listener);

	public ArrayList<VirtualFocusListener> getVirtualFocusListeners();

	public boolean isEnabled();

	public void setEnabled(boolean enabled);

	public boolean isCollaborativeEnabled();

	public void setCollaborativeEnabled(boolean collab);

	// public ArrayList<VirtualMouseMoveListener> getVirtualMouseMoveListeners();

	// public void addMouseTrackListener(VirtualMouseListener listener);

	// public void addMouseMoveListener(VirtualMouseMoveListener listener);

	// public VirtualContainer getParent();
	// public void revalidate();
	// public void repaint();
	// public void setBackground(Object newColor);
	// public Object getBackground();
	// public void setForeground(Object newColor);
	// public Object getForeground();
	// public void setEnabled(boolean enabled);

}
