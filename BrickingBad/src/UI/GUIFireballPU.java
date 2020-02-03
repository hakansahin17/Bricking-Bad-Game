package UI;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

public class GUIFireballPU extends GUIGameObject {

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) getX(), (int) getY(), Game.WIDTH / 80, 50);

		
	}

}
