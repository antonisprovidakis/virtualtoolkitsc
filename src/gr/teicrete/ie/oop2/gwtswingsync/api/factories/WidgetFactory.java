package gr.teicrete.ie.oop2.gwtswingsync.api.factories;

import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.AbstractButton;
import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.AbstractFlowPanel;
import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.AbstractWindow;

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
