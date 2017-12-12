package gr.istl.virtualtoolkitsc.widgets.awt;

import gr.istl.virtualtoolkitsc.widgets.GridLayoutFactory;
import gr.istl.virtualtoolkitsc.widgets.VirtualGridLayout;

public class AWTGridLayoutFactory extends AWTLayout implements GridLayoutFactory {

	@Override
	public VirtualGridLayout createLayout() {
		return new AWTGridLayout();
	}

	@Override
	public VirtualGridLayout createLayout(int rows, int cols) {
		return new AWTGridLayout(rows, cols);
	}

}
