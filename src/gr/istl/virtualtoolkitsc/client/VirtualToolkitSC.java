package gr.istl.virtualtoolkitsc.client;

import com.google.gwt.core.client.EntryPoint;

import gr.istl.virtualtoolkitsc.api.factories.abstraction.UIFactory;
import gr.istl.virtualtoolkitsc.api.factories.abstraction.UIFactory.Architecture;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractWindow;

public class VirtualToolkitSC implements EntryPoint{

	@Override
	public void onModuleLoad() {
		UIFactory factory = UIFactory.getFactory(Architecture.GWT);
		AbstractWindow window = factory.createWindow();
		AbstractFlowPanel panel = factory.createFlowPanel();
		AbstractButton button = factory.createButton("button_1", null);
		
		button.addAbstractMouseListener(factory.createButtonHandler(button));
				
		panel.addButton(button);
		window.addPanel(panel);
		
		window.setVisible(true);
	}

}
