package gr.istl.virtualtoolkitsc.main;

import gr.istl.virtualtoolkitsc.api.factories.WidgetFactory;
import gr.istl.virtualtoolkitsc.api.factories.WidgetFactory.Architecture;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractWindow;

public class Main {

	public static void main(String[] args) {
		
		WidgetFactory factory = WidgetFactory.getFactory(Architecture.SWING);
		
		AbstractWindow window = factory.createWindow();
		AbstractFlowPanel panel = factory.createFlowPanel();
		AbstractButton button = factory.createButton();
		
		button.setButtonText("Hello");
		
		
		panel.addButton(button);
		window.addPanel(panel);
		
		window.setVisible(true);

	}

}
