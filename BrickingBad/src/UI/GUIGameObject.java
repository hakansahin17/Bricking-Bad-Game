package UI;

import java.awt.Graphics;
import java.io.Serializable;


public abstract class GUIGameObject implements Serializable {

	protected double x, y;

	public GUIGameObject() {
		this.x = getX();
		this.y = getY();
	}

	public abstract void render(Graphics g);

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

}
