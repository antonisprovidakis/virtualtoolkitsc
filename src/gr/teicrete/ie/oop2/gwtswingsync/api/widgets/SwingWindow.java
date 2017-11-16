package gr.teicrete.ie.oop2.gwtswingsync.api.widgets;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingWindow extends JFrame implements AbstractWindow {

	public SwingWindow() {
		super();
		setSize(500, 250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
//		setVisible(true);
	}
	
	@Override
	public void addPanel(AbstractFlowPanel panel) {
		add((JPanel) panel);
	}
	
	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
	}

}
