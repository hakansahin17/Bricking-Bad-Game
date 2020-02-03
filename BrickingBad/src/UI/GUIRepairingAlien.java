package UI;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;


public class GUIRepairingAlien extends GUIGameObject{

	public GUIRepairingAlien() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillOval((int) getX(), (int) getY(), Game.WIDTH / 50, 20); 
		
		
	}

}
