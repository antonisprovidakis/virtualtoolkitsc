package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.GridLayout;

import gr.istl.virtualtoolkitsc.widgets.VirtualGridLayout;

public class AWTGridLayout extends AWTLayout implements VirtualGridLayout {

	public AWTGridLayout() {
		layout = new GridLayout();
	}

	public AWTGridLayout(int rows, int cols) {
		layout = new GridLayout(rows, cols);
	}

	public GridLayout getGridLayout() {
		return (GridLayout) layout;
	}

	@Override
	public int getColumns() {
		return getGridLayout().getColumns();
	}

	@Override
	public void setColumns(int cols) {
		getGridLayout().setColumns(cols);
	}

	@Override
	public int getRows() {
		return getGridLayout().getRows();
	}

	@Override
	public void setRows(int rows) {
		getGridLayout().setRows(rows);
	}

}
