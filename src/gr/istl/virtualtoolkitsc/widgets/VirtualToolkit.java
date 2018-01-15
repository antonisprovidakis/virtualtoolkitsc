package gr.istl.virtualtoolkitsc.widgets;

public abstract class VirtualToolkit {

	private static VirtualToolkit defaultToolkit;
	private static boolean collaborative = false;

	public VirtualToolkit(boolean collab) {
		collaborative = collab;
		setupSelectors();
	}

	public abstract void setupSelectors();

	public static VirtualToolkit getDefaultToolkit() {
		return defaultToolkit;
	}

	public static void setDefaultToolkit(VirtualToolkit toolkit) {
		defaultToolkit = toolkit;
	}

	public static boolean isCollaborative() {
		return collaborative;
	}

	public static void setCollaborative(boolean collab) {
		collaborative = collab;
	}

}
