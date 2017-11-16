package gr.teicrete.ie.oop2.gwtswingsync.api.factories;

import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.AbstractButton;
import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.AbstractFlowPanel;
import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.AbstractWindow;
import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.GWTButton;
import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.GWTFlowPanel;
import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.GWTWindow;

public class GWTFactory extends WidgetFactory {

	@Override
	public AbstractWindow createWindow() {
		return new GWTWindow();
	}

	@Override
	public AbstractFlowPanel createFlowPanel() {
		return new GWTFlowPanel();
	}

	@Override
	public AbstractButton createButton() {
		return new GWTButton();
	}

}
