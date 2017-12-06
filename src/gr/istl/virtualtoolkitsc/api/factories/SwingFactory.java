package gr.istl.virtualtoolkitsc.api.factories;


import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractWindow;
import gr.istl.virtualtoolkitsc.api.widgets.swing.SwingButton;
import gr.istl.virtualtoolkitsc.api.widgets.swing.SwingFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.swing.SwingWindow;

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
