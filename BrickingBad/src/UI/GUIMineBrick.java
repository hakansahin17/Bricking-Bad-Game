package UI;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class GUIMineBrick extends GUIBrick{
	
	public GUIMineBrick() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.PINK);
		g.fillOval((int) getX(), (int) getY(), 34, 34);
	}
}
