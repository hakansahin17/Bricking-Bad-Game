package UI;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

@SuppressWarnings("serial")
public class GUISimpleBrick extends GUIBrick {

	public GUISimpleBrick() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect((int) getX(), (int) getY(), Game.WIDTH / 50, 20);

	}

}
