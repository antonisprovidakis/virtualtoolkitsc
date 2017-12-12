package gr.istl.virtualtoolkitsc.widgets;

public class PanelSelector {

	static PanelFactory factory;

	public static void setPanelFactory(PanelFactory panelFactory) {
		factory = panelFactory;
	}

	public static VirtualContainer createPanel() {
		return factory.createPanel();
	}
}
