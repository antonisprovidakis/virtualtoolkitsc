package gr.istl.virtualtoolkitsc.api.listeners;

import gr.istl.virtualtoolkitsc.api.widgets.AbstractButton;

public abstract class AbstractButtonHandler {
	private final AbstractButton button;

	public AbstractButtonHandler(AbstractButton button) {
		this.button = button;
	}

	public AbstractButton getButton() {
		return button;
	}

}
