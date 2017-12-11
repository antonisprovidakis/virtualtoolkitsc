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

	@Override
	public int getColumns() {
		return super.getColumns();
	}

	@Override
	public void setColumns(int cols) {
		super.setColumns(cols);
	}

	@Override
	public int getRows() {
		return super.getRows();
	}

	@Override
	public void setRows(int rows) {
		super.setRows(rows);
	}

}
