package gr.istl.virtualtoolkitsc.widgets.gwt;

import gr.istl.virtualtoolkitsc.widgets.GridLayoutFactory;
import gr.istl.virtualtoolkitsc.widgets.VirtualGridLayout;

public class GWTGridLayoutFactory implements GridLayoutFactory {

	@Override
	public VirtualGridLayout createLayout() {
		return new GWTGridLayout();
	}

	@Override
	public VirtualGridLayout createLayout(int rows, int cols) {
		return new GWTGridLayout(rows, cols);
	}

}
