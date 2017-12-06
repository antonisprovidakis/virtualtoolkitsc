package gr.istl.virtualtoolkitsc.api.factories.swing;

import javax.swing.JButton;

import gr.istl.virtualtoolkitsc.api.factories.abstraction.UIFactory;
import gr.istl.virtualtoolkitsc.api.listeners.abstraction.AbstractButtonHandler;
import gr.istl.virtualtoolkitsc.api.listeners.swing.SwingButtonHandler;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractWindow;
import gr.istl.virtualtoolkitsc.api.widgets.swing.SwingButton;
import gr.istl.virtualtoolkitsc.api.widgets.swing.SwingFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.swing.SwingWindow;

public class SwingFactory extends UIFactory {

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

	@Override
	public AbstractButtonHandler createButtonHandler(AbstractButton button) {
		return new SwingButtonHandler((JButton)button);
	}

}
