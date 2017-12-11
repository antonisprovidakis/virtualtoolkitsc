package gr.istl.virtualtoolkitsc.widgets.swing;

import gr.istl.virtualtoolkitsc.widgets.GridLayoutFactory;
import gr.istl.virtualtoolkitsc.widgets.VirtualGridLayout;

public class SwingGridLayoutFactory implements GridLayoutFactory{

	@Override
	public VirtualGridLayout createLayout() {
		return new SwingGridLayout();
	}

	@Override
	public VirtualGridLayout createLayout(int rows, int cols) {
		return new SwingGridLayout(rows, cols);

	}

}
