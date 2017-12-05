package gr.istl.virtualtoolkitsc.api.factories;

import gr.istl.virtualtoolkitsc.api.widgets.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractWindow;
import gr.istl.virtualtoolkitsc.api.widgets.GWTButton;
import gr.istl.virtualtoolkitsc.api.widgets.GWTFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.GWTWindow;

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
