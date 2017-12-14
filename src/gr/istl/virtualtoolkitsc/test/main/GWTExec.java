package gr.istl.virtualtoolkitsc.test.main;

import com.google.gwt.core.client.EntryPoint;

import gr.istl.virtualtoolkitsc.widgets.gwt.GWTToolkit;

public class GWTExec implements EntryPoint {

	@Override
	public void onModuleLoad() {
		UnifiedUISpec.engageDialogue(new GWTToolkit(false));
	}

}