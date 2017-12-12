package gr.istl.virtualtoolkitsc.widgets.awt;

import java.awt.Component;
import java.awt.Container;
import gr.istl.virtualtoolkitsc.widgets.VirtualComponent;
import gr.istl.virtualtoolkitsc.widgets.VirtualContainer;
import gr.istl.virtualtoolkitsc.widgets.VirtualLayout;

public class AWTContainer extends AWTComponent implements VirtualContainer {

	public AWTContainer(Container container) {
		super(container);
	}

	public Container getContainer() {
		return (Container) component;
	}

	public void setContainer(Container theContainer) {
		component = theContainer;
	}

	@Override
	public void add(VirtualComponent c) {
		getContainer().add((Component) c.getPhysicalComponent());
	}

	@Override
	public void setLayout(VirtualLayout layout) {
		if (!(layout == null || layout instanceof AWTLayout)) {
			throw new IllegalArgumentException("Argument must be of AWT type");
		}

		getContainer().setLayout(((AWTLayout) layout).getLayout());
	}

}
