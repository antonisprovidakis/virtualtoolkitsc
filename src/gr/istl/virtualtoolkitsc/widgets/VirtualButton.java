package gr.istl.virtualtoolkitsc.widgets;

import java.util.ArrayList;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;

public interface VirtualButton extends VirtualComponent {

	public void addActionListener(VirtualActionListener listener);

	public ArrayList<VirtualActionListener> getVirtualActionListeners();

	public void setText(String text);

	public String getText();
	
	public void addStyleName(String name);

	public void removeStyleName(String name);
	
}
