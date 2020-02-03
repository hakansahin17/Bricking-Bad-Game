package UI;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

@SuppressWarnings("serial")
public class GUIHalfMetalBrick extends GUIBrick{

	public GUIHalfMetalBrick() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.ORANGE);
		g.fillRect((int) getX(), (int) getY(), Game.WIDTH / 50, 20);
		g.setColor(Color.GRAY);
		g.fillRect((int) getX(), (int) getY() + 10, Game.WIDTH / 50, 10);
	}

}
