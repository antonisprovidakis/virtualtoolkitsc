package gr.istl.virtualtoolkitsc.api.listeners;

public interface VirtualFocusListener extends VirtualListener {

	public void focusGained(VirtualFocusEvent event);

	public void focusLost(VirtualFocusEvent event);
}
