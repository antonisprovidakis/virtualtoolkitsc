package gr.istl.virtualtoolkitsc.widgets.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import gr.istl.virtualtoolkitsc.api.listeners.VirtualMouseListener;
import gr.istl.virtualtoolkitsc.widgets.VirtualComponent;
import gr.istl.virtualtoolkitsc.widgets.VirtualContainer;
import gr.istl.virtualtoolkitsc.widgets.VirtualFrame;
import gr.istl.virtualtoolkitsc.widgets.VirtualLayout;

public class SwingFrame extends JFrame implements VirtualFrame {

	public SwingFrame() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public SwingFrame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void add(VirtualComponent c) {
		super.add((Component) c);
	}

	@Override
	public void setLayout(VirtualLayout layout) {
		super.setLayout((LayoutManager) layout);
	}

	@Override
	public void setSize(int width, int height) {
		super.setSize(width, height);
	}

	@Override
	public int getHeight() {
		return super.getHeight();
	}

	@Override
	public int getWidth() {
		return super.getWidth();
	}

	@Override
	public void addMouseListener(VirtualMouseListener listener) {
		super.addMouseListener((MouseListener) listener);
	}

	@Override
	public VirtualContainer getTheContentPane() {
		return (VirtualContainer) super.getContentPane();
	}

	@Override
	public void setTheContentPane(VirtualContainer container) {
		super.setContentPane((Container) container);

	}

	@Override
	public void setTitle(String title) {
		super.setTitle(title);
	}

	@Override
	public String getTitle() {
		return super.getTitle();
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
	}

}
