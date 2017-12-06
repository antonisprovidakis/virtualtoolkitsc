package gr.istl.virtualtoolkitsc.api.widgets.swing;

import javax.swing.JButton;
import javax.swing.JPanel;

import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractButton;
import gr.istl.virtualtoolkitsc.api.widgets.abstraction.AbstractFlowPanel;

public class SwingFlowPanel extends JPanel implements AbstractFlowPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6558784934226950764L;

	public SwingFlowPanel() {
		super();
	}

	@Override
	public void addButton(AbstractButton button) {
		add((JButton) button);
	}

	@Override
	public void removeAllWidgets() {
		removeAll();
	}

}
