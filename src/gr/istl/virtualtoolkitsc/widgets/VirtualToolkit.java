package gr.istl.virtualtoolkitsc.widgets;

public abstract class VirtualToolkit {

	private static VirtualToolkit defaultToolkit;
	private static boolean inSync = false;

	public VirtualToolkit(boolean synced) {
		inSync = synced;
		setupSelectors();
	}

	public abstract void setupSelectors();

	public static void setDefaultToolkit(VirtualToolkit toolkit) {
		defaultToolkit = toolkit;
	}

	public static VirtualToolkit getDefaultToolkit() {
		return defaultToolkit;
	}

	public static boolean isInSync() {
		return inSync;
	}

	public static void setInSync(boolean sync) {
		inSync = sync;
	}

}
