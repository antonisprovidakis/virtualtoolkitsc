package gr.istl.virtualtoolkitsc.widgets.gwt;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Panel;

import gr.istl.virtualtoolkitsc.widgets.VirtualComponent;
import gr.istl.virtualtoolkitsc.widgets.VirtualGridLayout;

public class GWTGridLayout extends GWTLayout implements VirtualGridLayout {

	private Grid grid;
	int rowPos = 0;
	int colPos = 0;

	public GWTGridLayout() {
		grid = new Grid(1, 1);
	}

	public GWTGridLayout(int rows, int cols) {
		grid = new Grid(rows, cols);
	}

	@Override
	public int getColumns() {
		return grid.getColumnCount();
	}

	@Override
	public void setColumns(int cols) {
		grid.resizeColumns(cols);
	}

	@Override
	public int getRows() {
		return grid.getRowCount();
	}

	@Override
	public void setRows(int rows) {
		grid.resizeRows(rows);
	}

	@Override
	public Panel getComponent() {
		return grid;
	}

	@Override
	public void add(VirtualComponent c) {
		if (colPos >= getColumns()) {
			colPos = 0;
			rowPos++;
		}

		if (rowPos >= getRows()) {
			setRows(getRows() + 1);
		}

		grid.setWidget(rowPos, colPos, ((GWTComponent) c).getWidget());
		colPos++;
	}

}
