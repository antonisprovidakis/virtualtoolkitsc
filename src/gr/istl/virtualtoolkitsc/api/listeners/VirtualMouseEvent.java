package gr.istl.virtualtoolkitsc.api.listeners;

public class VirtualMouseEvent {
	public static final int MouseDown = 3;
	public static final int MouseUp = 4;
	public static final int MouseDoubleClick = 8;
	public static final int MouseClick = 101;
	public static final int MouseEnter = 6;
	public static final int MouseExit = 7;
	public static final int MouseHover = 102;
	public static final int Mouse_Move = 5;
	public static final int Mouse_Drag = 102;

	private int type;
	private long when = -1;
	private int modifiers;
	private int x = -1;
	private int y = -1;
	private int clickCount = 0;
	private int button;
	private boolean popUpTrigger = false;
	private Object loc;
	private Object point;
	private int xOnScreen = -1;
	private int yOnScreen = -1;
	private String paramString;

	private Object source;

	public VirtualMouseEvent(int type) {
		this.type = type;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object val) {
		source = val;
	}

	public int type() {
		return type;
	}

	public long when() {
		return when;
	}

	public void setWhen(long w) {
		when = w;
	}

	public int modifiers() {
		return this.modifiers;
	}

	public void setModifiers(int m) {
		modifiers = m;
	}

	public int getButton() {
		return this.button;
	}

	public void setButton(int b) {
		button = b;
	}

	public int getClickCount() {
		return this.clickCount;
	}

	public void setClickCount(int c) {
		clickCount = c;
	}

	public Object getLocationOnScreen() {
		return loc;
	}

	public void setLocationOnScreen(Object l) {
		loc = l;
	}

	public Object getPoint() {
		return point;
	}

	public void setPoint(Object p) {
		point = p;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getXOnScreen() {
		return xOnScreen;
	}

	public void setXOnScreen(int x) {
		xOnScreen = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getYOnScreen() {
		return yOnScreen;
	}

	public void setYOnScreen(int y) {
		yOnScreen = y;
	}

	public boolean isPopupTrigger() {
		return popUpTrigger;
	}

	public void setIsPopupTrigger(boolean p) {
		popUpTrigger = p;
	}

	public String paramString() {
		return paramString;
	}

	public void setParamString(String p) {
		paramString = p;
	}

}
