package UI;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;


public class GUIProtectingAlien extends GUIGameObject {

	public GUIProtectingAlien() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval((int) getX(), (int) getY(), Game.WIDTH / 50, 20); 
		
	}

}
