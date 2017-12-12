package gr.istl.virtualtoolkitsc.widgets.swing;

import java.awt.GridLayout;

import gr.istl.virtualtoolkitsc.widgets.VirtualGridLayout;

public class SwingGridLayout extends GridLayout implements VirtualGridLayout {

	public SwingGridLayout() {
		super();
	}

	public SwingGridLayout(int rows, int cols) {
		super(rows, cols);
	}

}
