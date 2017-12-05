package gr.istl.virtualtoolkitsc.api.factories;


import gr.istl.virtualtoolkitsc.api.widgets.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractWindow;
import gr.istl.virtualtoolkitsc.api.widgets.SwingButton;
import gr.istl.virtualtoolkitsc.api.widgets.SwingFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.SwingWindow;

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
