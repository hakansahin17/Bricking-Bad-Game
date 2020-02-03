package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;



public class GUIPaddle extends GUIGameObject {
	private int[] xs = new int[4],ys = new int[4];
	private boolean isMagnet = false;
	
	public GUIPaddle() {
		super();
	} 

	public void render(Graphics g) {
		if(isMagnet) {
			g.setColor(Color.BLUE);
		} else {
			g.setColor(Color.ORANGE);
		}
		
		//for a smooth paddle
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//
		g.fillPolygon(xs, ys, 4);
	}

	public int[] getXs() {
		return xs;
	}

	public void setXs(int[] xs) {
		this.xs = xs;
	}

	public int[] getYs() {
		return ys;
	}

	public void setYs(int[] ys) {
		this.ys = ys;
	}

	public boolean isMagnet() {
		return isMagnet;
	}

	public void setMagnet(boolean isMagnet) {
		this.isMagnet = isMagnet;
	}
	

}