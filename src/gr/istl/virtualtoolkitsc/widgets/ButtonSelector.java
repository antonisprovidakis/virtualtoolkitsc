package gr.istl.virtualtoolkitsc.widgets;

public class ButtonSelector {

	static ButtonFactory factory;

	public static void setButtonFactory(ButtonFactory buttonFactory) {
		factory = buttonFactory;
	}

	public static VirtualButton createButton(String text) {
		return factory.createButton(text);
	}

	public static VirtualButton createButton() {
		return factory.createButton();
	}

}
