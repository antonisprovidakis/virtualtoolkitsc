package gr.teicrete.ie.oop2.gwtswingsync.main;

import gr.teicrete.ie.oop2.gwtswingsync.api.factories.WidgetFactory;
import gr.teicrete.ie.oop2.gwtswingsync.api.factories.WidgetFactory.Architecture;
import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.AbstractButton;
import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.AbstractFlowPanel;
import gr.teicrete.ie.oop2.gwtswingsync.api.widgets.AbstractWindow;

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
