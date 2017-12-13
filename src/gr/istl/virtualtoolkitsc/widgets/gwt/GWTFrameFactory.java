package gr.istl.virtualtoolkitsc.widgets.gwt;

import gr.istl.virtualtoolkitsc.widgets.FrameFactory;
import gr.istl.virtualtoolkitsc.widgets.VirtualFrame;

public class GWTFrameFactory implements FrameFactory {

	@Override
	public VirtualFrame createFrame() {
		return new GWTFrame();
	}

	@Override
	public VirtualFrame createFrame(String id) {
		return new GWTFrame(id);
	}

}
