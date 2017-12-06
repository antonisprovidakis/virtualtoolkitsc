package gr.istl.virtualtoolkitsc.api.factories;

import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractWindow;

public abstract class WidgetFactory {

	public enum Architecture {
		GWT, SWING
	}

	public static WidgetFactory getFactory(Architecture architecture) {
		WidgetFactory factory = null;

		switch (architecture) {
		case GWT:
			factory = new GWTFactory();
			break;
		case SWING:
			factory = new SwingFactory();
			break;
		}

		return factory;
	}

	public abstract AbstractWindow createWindow();

	public abstract AbstractFlowPanel createFlowPanel();

	public abstract AbstractButton createButton();

}
