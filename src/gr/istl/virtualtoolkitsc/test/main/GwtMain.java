package gr.istl.virtualtoolkitsc.test.gwt.main;

import com.google.gwt.core.client.EntryPoint;

import gr.istl.virtualtoolkitsc.api.widgets.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractWindow;
import gr.istl.virtualtoolkitsc.api.widgets.UIFactory;
import gr.istl.virtualtoolkitsc.api.widgets.UIFactory.Architecture;

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
