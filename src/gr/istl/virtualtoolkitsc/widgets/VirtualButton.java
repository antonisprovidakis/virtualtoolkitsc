package gr.istl.virtualtoolkitsc.widgets;

import java.util.Set;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualActionListener;

public interface VirtualButton extends VirtualComponent {

	public void addActionListener(VirtualActionListener listener);

	public Set<VirtualActionListener> getVirtualActionListeners();

	public void setText(String text);

	public String getText();

	// public void addClickHandler(Object handler);

}
