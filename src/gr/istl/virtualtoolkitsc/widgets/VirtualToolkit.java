package gr.istl.virtualtoolkitsc.widgets;

public abstract class VirtualToolkit {

	static VirtualToolkit defaultToolkit;

	public abstract void select();

	public static void setDefaultToolkit(VirtualToolkit toolkit) {
		defaultToolkit = toolkit;
	}

	public static VirtualToolkit getDefaultToolkit() {
		return defaultToolkit;
	}

	// public abstract void startFrame(VirtualFrame frame);

	// public static void start(VirtualFrame frame) {
	// defaultToolkit.startFrame(frame);
	// }
}
