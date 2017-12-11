package gr.istl.virtualtoolkitsc.api.listeners;

public class VirtualActionEvent {

	public static final int SELECTED = 2;// SWT.SELECTED;
	public static final int MODIFIED = 24;// SWT.Modify;

	private String cmd;
	private long when;
	private int type;
	private int modifiers;

	private Object source;

	public VirtualActionEvent() {
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object val) {
		source = val;
	}

	public String getActionCommand() {
		return cmd;
	}

	public void setActionCommand(String cmd) {
		this.cmd = cmd;
	}

	public long when() {
		return when;
	}

	public void setWhen(long when) {
		this.when = when;
	}

	public int modifiers() {
		return modifiers;
	}

	public void setModifies(int modifiers) {
		this.modifiers = modifiers;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

}
