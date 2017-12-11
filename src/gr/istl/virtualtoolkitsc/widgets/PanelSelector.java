package gr.istl.virtualtoolkitsc.widgets;

public class PanelSelector {

	static PanelFactory factory;

	public static void setPanelFactory(PanelFactory panelFactory) {
		factory = panelFactory;
	}

	public static VirtualPanel createPanel() {
		return factory.createPanel();
	}
}
