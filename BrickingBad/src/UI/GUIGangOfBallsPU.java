package UI;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

public class GUIGangOfBallsPU extends GUIGameObject {

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int) getX(), (int) getY(), Game.WIDTH / 80, 50);
		
	}

}
