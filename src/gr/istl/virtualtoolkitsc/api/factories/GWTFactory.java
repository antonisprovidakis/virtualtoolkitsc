package gr.istl.virtualtoolkitsc.api.factories;

import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractWindow;
import gr.istl.virtualtoolkitsc.api.widgets.gwt.GWTButton;
import gr.istl.virtualtoolkitsc.api.widgets.gwt.GWTFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.gwt.GWTWindow;

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
