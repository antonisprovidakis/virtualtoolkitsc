package gr.istl.virtualtoolkitsc.api.factories.abstraction;

import com.google.firebase.database.FirebaseDatabase;

import gr.istl.virtualtoolkitsc.api.factories.gwt.GWTFactory;
import gr.istl.virtualtoolkitsc.api.factories.swing.SwingFactory;
import gr.istl.virtualtoolkitsc.api.listeners.abstraction.AbstractButtonHandler;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractFlowPanel;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractWindow;

public abstract class UIFactory {

	public enum Architecture {
		GWT, SWING
	}

	public static UIFactory getFactory(Architecture architecture) {
		UIFactory factory = null;

		switch (architecture) {
		case GWT:
			factory = new GWTFactory();
			break;
		case SWING:
			factory = new SwingFactory();
			break;
		}

		return factory;
	}

	public abstract AbstractWindow createWindow();

	public abstract AbstractFlowPanel createFlowPanel();

	public abstract AbstractButton createButton(String text, FirebaseDatabase db);
	
	public abstract AbstractButtonHandler createButtonHandler(AbstractButton button);

}
