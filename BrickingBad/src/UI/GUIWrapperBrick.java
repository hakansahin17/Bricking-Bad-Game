package UI;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

@SuppressWarnings("serial")
public class GUIWrapperBrick extends GUIBrick {

	public GUIWrapperBrick() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect((int) getX(), (int) getY(), Game.WIDTH / 50, 20);
		g.setColor(Color.YELLOW);
		g.fillRect((int) getX() + Game.WIDTH / 400, (int) getY() + 2 , Game.WIDTH / 50 - (Game.WIDTH / 400) - 3, 16);
	}

}
