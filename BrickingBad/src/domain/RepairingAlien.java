package domain;

import java.awt.Rectangle;
import java.awt.Shape;

import main.Game;

@SuppressWarnings("serial")
public class RepairingAlien extends Alien {

	GameController GC;
	int counter;

	public RepairingAlien() {
		this.id = ID.RepairingAlien;
	}

	public void update() {
		/*
		if (counter == 300) {
			SimpleBrick addedBrick = new SimpleBrick();
			addedBrick.x = x;
			addedBrick.y = y;
			GC.addObject(addedBrick);
			x += Game.WIDTH / 50;
			counter = 0;
		} else {
			counter++;
		}*/
	}
	public Shape getBounds() {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(Game.WIDTH / 50, 20);
		rect.setLocation((int) x, (int)y);
		return rect;
	}
}