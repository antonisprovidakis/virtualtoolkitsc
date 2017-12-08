package gr.istl.virtualtoolkitsc.api.widgets.swing;

import com.google.firebase.database.FirebaseDatabase;

import gr.istl.virtualtoolkitsc.api.listeners.AbstractButtonHandler;
import gr.istl.virtualtoolkitsc.api.listeners.SwingButtonHandler;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.AbstractWindow;
import gr.istl.virtualtoolkitsc.api.widgets.UIFactory;

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
	public AbstractButton createButton(String text, FirebaseDatabase db) {
		return new SwingButton(text, db);
	}

	@Override
	public AbstractButtonHandler createButtonHandler(AbstractButton button) {
		return new SwingButtonHandler((SwingButton)button);
	}

}
