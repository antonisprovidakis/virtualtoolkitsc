package gr.istl.virtualtoolkitsc.widgets;

public abstract class VirtualToolkit {

	static VirtualToolkit defaultToolkit;

	public VirtualToolkit() {
		setupSelectors();
	}

	public abstract void setupSelectors();

	public static void setDefaultToolkit(VirtualToolkit toolkit) {
		defaultToolkit = toolkit;
	}

	public static VirtualToolkit getDefaultToolkit() {
		return defaultToolkit;
	}

}
