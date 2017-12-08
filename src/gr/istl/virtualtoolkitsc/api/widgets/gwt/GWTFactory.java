package gr.istl.virtualtoolkitsc.api.widgets.gwt;

import com.google.firebase.database.FirebaseDatabase;

import gr.istl.virtualtoolkitsc.api.listeners.AbstractButtonHandler;
import gr.istl.virtualtoolkitsc.api.listeners.GWTButtonHandler;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractWindow;
import gr.istl.virtualtoolkitsc.api.widgets.UIFactory;

public class GWTFactory extends UIFactory {

	@Override
	public AbstractWindow createWindow() {
		return new GWTWindow();
	}

	@Override
	public AbstractFlowPanel createFlowPanel() {
		return new GWTFlowPanel();
	}

	@Override
	public AbstractButton createButton(String text, FirebaseDatabase db) {
		return new GWTButton(text, db);
	}

	@Override
	public AbstractButtonHandler createButtonHandler(AbstractButton button) {
		return new GWTButtonHandler((GWTButton) button);
	}

}
