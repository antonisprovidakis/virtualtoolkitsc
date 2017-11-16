package gr.teicrete.ie.oop2.gwtswingsync.api.widgets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SwingFlowPanel extends JPanel implements AbstractFlowPanel {

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
