package gr.istl.virtualtoolkitsc.widgets;

public class GridLayoutSelector {

	static GridLayoutFactory factory;
	
	public static void setGridLayoutFactory(GridLayoutFactory gridLayoutFactory) {
		factory = gridLayoutFactory;
	}

	public static VirtualGridLayout createLayout() {
		return factory.createLayout();
	}

	public static VirtualGridLayout createLayout(int rows, int cols) {
		return factory.createLayout(rows, cols);
	}
}
