package gr.istl.virtualtoolkitsc.widgets;

public class FrameSelector {

	static FrameFactory factory;

	public static void setFrameFactory(FrameFactory frameFactory) {
		factory = frameFactory;
	}

	public static VirtualFrame createFrame() {
		return factory.createFrame();
	}

	public static VirtualFrame createFrame(String title) {
		return factory.createFrame(title);
	}
}
