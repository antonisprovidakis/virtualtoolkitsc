package gr.istl.virtualtoolkitsc.api.listeners;

public class VirtualFocusEvent {

	public final static int Focus_gain = 15;// SWT.FocusIn;
	public final static int Focus_lost = 16;// SWT.FocusOut;

	private int type;
	private long when;
	private Object source;

	public VirtualFocusEvent(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public long when() {
		return when;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setWhen(long w) {
		this.when = w;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}

	public boolean isTemporary() {// throws PackageMismatchException{
		// if(awtComponent == null)
		// throw new
		// PackageMismatchException("Cannot call isTemporary() from the chosen
		// toolkit");
		// return awtComponent.isTemporary();
		return false;
	}

	public Object getOppositeComponent() {
		// if(awtComponent!=null){
		// return awtComponent.getOppositeComponent();
		// }else{
		return null;
		// }
	}

	public String paramString() {// throws PackageMismatchException{
		// if(awtComponent == null)
		// throw new
		// PackageMismatchException("Cannot call paramString() from the chosen
		// toolkit");
		// return awtComponent.paramString();
		return null;
	}

	public int type() {
		return type;
	}

}