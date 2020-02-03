package UI;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

public class GUILaser extends GUIGameObject{
	
	public GUILaser() {
		super();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.yellow);
		g.fillRect((int) getX(), (int) getY(), 5, 10);
	}

}