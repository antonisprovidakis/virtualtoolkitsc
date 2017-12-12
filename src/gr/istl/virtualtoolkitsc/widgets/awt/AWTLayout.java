package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.LayoutManager;

import gr.istl.virtualtoolkitsc.widgets.VirtualLayout;

public abstract class AWTLayout implements VirtualLayout {
	protected LayoutManager layout;

	public AWTLayout() {
	}

	public AWTLayout(LayoutManager layout) {
		this.layout = layout;
	}

	public LayoutManager getLayout() {
		return layout;
	}
}
