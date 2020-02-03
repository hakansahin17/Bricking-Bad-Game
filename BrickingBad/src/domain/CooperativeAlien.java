package domain;

import java.awt.Rectangle;
import java.awt.Shape;

import main.Game;

@SuppressWarnings("serial")
public class CooperativeAlien extends Alien {

	public CooperativeAlien() {
		this.id = ID.CooperativeAlien;
	}

	public void update() {
		x += 5;
	}
	@Override
	public Shape getBounds() {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(Game.WIDTH / 50, 20);
		rect.setLocation((int) x, (int)y);
		return rect;
	}
}
