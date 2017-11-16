package gr.teicrete.ie.oop2.gwtswingsync.api.factories;


import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.AbstractButton;
import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.AbstractFlowPanel;
import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.AbstractWindow;
import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.SwingButton;
import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.SwingFlowPanel;
import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.SwingWindow;

public class SwingFactory extends WidgetFactory {

	@Override
	public AbstractWindow createWindow() {
		return new SwingWindow();
	}

	@Override
	public AbstractFlowPanel createFlowPanel() {
		return new SwingFlowPanel();
	}

	@Override
	public AbstractButton createButton() {
		return new SwingButton();
	}

}
