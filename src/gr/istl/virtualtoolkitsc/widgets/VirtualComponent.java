package gr.istl.virtualtoolkitsc.widgets;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;

public interface VirtualComponent {
	
	public int getHeight();

	public int getWidth();
	
	public void addMouseListener(VirtualMouseListener listener);
	
	public void setSize(int width, int height);
	
//	public VirtualContainer getParent();
	
//	public void revalidate();
//	public void repaint();
//	public void setBackground(Object newColor);
//	public Object getBackground();
//	public void setForeground(Object newColor);
//	public Object getForeground();
//	public void setEnabled(boolean enabled);

}
