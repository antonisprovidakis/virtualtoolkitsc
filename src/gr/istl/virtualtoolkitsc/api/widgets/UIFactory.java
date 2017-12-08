package gr.istl.virtualtoolkitsc.api.widgets;

import com.google.firebase.database.FirebaseDatabase;

import gr.istl.virtualtoolkitsc.api.listeners.AbstractButtonHandler;
import gr.istl.virtualtoolkitsc.api.widgets.gwt.GWTFactory;
import gr.istl.virtualtoolkitsc.api.widgets.swing.SwingFactory;

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
