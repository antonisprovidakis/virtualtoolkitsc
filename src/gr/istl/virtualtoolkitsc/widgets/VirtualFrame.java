package gr.istl.virtualtoolkitsc.widgets;

public interface VirtualFrame extends /* VirtualComponent */ VirtualContainer {

	public void setTitle(String title);

	public String getTitle();

	public void setVisible(boolean visible);
	
	public void pack();

	// public VirtualContainer getContentPane();

	// public void add(VirtualComponent c);

	// public void removeAll();

	// public int getComponentCount();

	// public void add(VirtualComponent c, int pos);

	// public void add(VirtualContainer c);

	// public void setContentPane(VirtualContainer container);

	// public void setLayout(VirtualLayout layout);

	// public Object getLayout();

	// public void setDefaultCloseOperation(int arg);
}
