package gr.istl.virtualtoolkitsc.api.listeners.abstraction;

import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractButton;

public abstract class AbstractButtonHandler {
	private final AbstractButton button;

	public AbstractButtonHandler(AbstractButton button) {
		this.button = button;
	}

	public AbstractButton getButton() {
		return button;
	}

}
