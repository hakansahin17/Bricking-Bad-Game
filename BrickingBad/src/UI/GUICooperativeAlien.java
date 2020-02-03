package UI;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

@SuppressWarnings("serial")
public class GUICooperativeAlien extends GUIGameObject{

	public GUICooperativeAlien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void render(Graphics g) {
	      g.setColor(Color.GREEN);
	      g.fillOval((int) getX(), (int) getY(), Game.WIDTH / 50, 20);
	}

}
