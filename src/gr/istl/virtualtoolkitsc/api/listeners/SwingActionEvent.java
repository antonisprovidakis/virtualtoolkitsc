package gr.istl.virtualtoolkitsc.api.listeners;

import java.awt.event.ActionEvent;

public class SwingActionEvent extends ActionEvent implements AbstractEvent {

	public SwingActionEvent(Object source, int id, String command) {
		super(source, id, command);
	}

	@Override
	public Object getSource() {
		return super.getSource();
	}

}
